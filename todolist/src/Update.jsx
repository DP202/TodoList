import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams, useNavigate } from "react-router-dom";

function Update() {
  const [data, setData] = useState({
    name: "",
    email: "",
    address: "",
    major_id: "",
  });
  const [majors, setMajors] = useState([]);
  const { id } = useParams();

  const navigate = useNavigate();
  useEffect(() => {
    axios
      .get(`http://localhost:8080/api/v1/students/${id}`) // lấy thông tin sinh viên
      .then((res) => {
        setData(res.data);
      })
      .catch((err) => console.log(err));
  }, [id]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/v1/majors") // lấy ds chuyên ngành
      .then((res) => {
        setMajors(res.data);
      })
      .catch((err) => console.log(err));
  }, []);

  const handleChange = (e) => {
    setData({ ...data, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Gửi dữ liệu cập nhật lên API
    axios
      .put("http://localhost:8080/api/v1/students/" + id, data)
      .then((res) => {
        console.log(res);
        navigate("/");
      })
      .catch((err) => console.log(err));
  };

  return (
    <div className="d-flex w-100 vh-100 justify-content-center align-items-center bg-light">
      <div className="w-50 border bg-white shadow px-5 pb-4 pt-5 rounded">
        <h1>Edit student</h1>
        <form onSubmit={handleSubmit}>
          <div className="mb-2">
            <label htmlFor="name">Full Name :</label>
            <input
              type="text"
              name="name"
              className="form-control"
              placeholder="Enter Name ..."
              value={data.name}
              onChange={(e) => setData({ ...data, name: e.target.value })}
            />
          </div>

          <div className="mb-2">
            <label htmlFor="email">Email :</label>
            <input
              type="text"
              name="email"
              className="form-control"
              placeholder="Enter Email ..."
              value={data.email}
              onChange={(e) => setData({ ...data, email: e.target.value })}
            />
          </div>

          <div className="mb-2 mb-3">
            <label htmlFor="address">Address :</label>
            <input
              type="text"
              name="address"
              className="form-control"
              placeholder="Enter address ..."
              value={data.address}
              onChange={(e) => setData({ ...data, address: e.target.value })}
            />
          </div>

          <select
            className="form-select mb-3"
            name="major_id"
            value={data.major_id}
            onChange={handleChange}
          >
            <option>Chọn chuyên ngành</option>
            {majors.map((major) => (
              <option key={major.id} value={major.id}>
                {major.name}
              </option>
            ))}
          </select>

          <button type="submit" className="btn btn-success mt-4">
            Edit
          </button>
          <Link to="/" className="btn btn-primary ms-3 mt-4">
            Back
          </Link>
        </form>
      </div>
    </div>
  );
}

export default Update;
