import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import { Form } from "react-bootstrap";
import axios from "axios";

function Create() {
  const [values, setValues] = useState({
    name: "",
    email: "",
    address: "",
    major_id: "", // Thay đổi thành string để phù hợp với giá trị option
  });

  const [majors, setMajors] = useState([]); // State để lưu danh sách các ngành

  const navigate = useNavigate();

  useEffect(() => {
    // Lấy ds của major
    axios
      .get("http://localhost:8080/api/v1/majors")
      .then((response) => {
        setMajors(response.data);
      })
      .catch((error) => {
        console.error("Error fetching majors:", error);
      });
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    axios
      .post("http://localhost:8080/api/v1/students", values)
      .then((res) => {
        console.log(res);
        navigate("/");
      })
      .catch((err) => console.log(err));
  };

  const handleChange = (e) => {
    setValues({ ...values, [e.target.name]: e.target.value });
  };

  return (
    <div className="d-flex w-100 vh-100 justify-content-center align-items-center bg-light">
      <div className="w-50 border bg-white shadow px-5 pb-4 pt-5 rounded ">
        <h1>Add student</h1>
        <form onSubmit={handleSubmit}>
          <div className="mb-2">
            <label htmlFor="name">Full Name :</label>
            <input
              type="text"
              name="name"
              className="form-control"
              placeholder="Enter Name ..."
              onChange={handleChange}
            />
          </div>

          <div className="mb-2">
            <label htmlFor="email">Email :</label>
            <input
              type="text"
              name="email"
              className="form-control"
              placeholder="Enter Email ..."
              onChange={handleChange}
            />
          </div>

          <div className="mb-2 mb-3">
            <label htmlFor="address">Address :</label>
            <input
              type="text"
              name="address"
              className="form-control"
              placeholder="Enter address ..."
              onChange={handleChange}
            />
          </div>

          <Form.Select
            aria-label="Default select example"
            name="major_id"
            value={values.major_id}
            onChange={handleChange}
          >
            <option>Choose a major</option>
            {majors.map((major) => (
              <option key={major.id} value={major.id}>
                {major.name}
              </option>
            ))}
          </Form.Select>

          <button className="btn btn-success mt-4">Submit</button>
          <Link to="/" className="btn btn-primary ms-3 mt-4">
            Back
          </Link>
        </form>
      </div>
    </div>
  );
}

export default Create;
