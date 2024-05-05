import axios from "axios";
import React, { useEffect, useState } from "react";
import { Form, Link, useParams } from "react-router-dom";

function Read() {
  const [data, setData] = useState([]);
  const [majorData, setMajorData] = useState({});
  const { id } = useParams();

  useEffect(() => {
    axios
      .get(`http://localhost:8080/api/v1/students/${id}`)
      .then((res) => {
        setData(res.data);
        if (res.data.major) {
          axios
            .get(`http://localhost:8080/api/v1/majors/${res.data.major.id}`)
            .then((res) => {
              setMajorData(res.data);
            })
            .catch((error) => console.log(error));
        }
      })
      .catch((err) => console.log(err));
  }, [id]);

  return (
    <div className="d-flex w-100 vh-100 justify-content-center align-items-center bg-light">
      <div className="w-50 border bg-white shadow px-5 pt-3 pb-5 rounded">
        <h3>Student details</h3>
        <div className="mb-2">
          <strong>Name: {data.name}</strong>
        </div>
        <div className="mb-2">
          <strong>Email: {data.email}</strong>
        </div>
        <div className="mb-2">
          <strong>Address: {data.address}</strong>
        </div>
        {majorData && (
          <div className="mb-2">
            <strong>Major: {majorData.name}</strong>
          </div>
        )}

        <div className="mt-3">
          <Link to={`/update/${id}`} className="btn btn-success">
            Edit
          </Link>
          <Link to="/" className="btn btn-primary m-2">
            Back
          </Link>
        </div>
      </div>
    </div>
  );
}

export default Read;
