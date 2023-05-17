import axios from "axios";
import React, { useEffect, useState } from "react";
import "./Operation.css";
import { useNavigate } from "react-router-dom";

const Operation = () => {
  const [appointments, setAppointments] = useState([]);
  const [doctors, setDoctors] = useState([]);
  const [patients, setPatients] = useState([]);
  const [nurses, setNurses] = useState([]);

  let navigate = useNavigate();

  useEffect(() => {
    loadAppointments();
    loadDoctors();
    loadPatients();
    loadNurses();
    localStorage.setItem("role", "Staff");
  }, []);

  const loadAppointments = async () => {
    try {
      const result = await axios.get("http://localhost:8090/appointment");
      setAppointments(result.data);
    } catch (err) {
      console.log(err);
    }
  };

  const loadDoctors = async () => {
    try {
      const result = await axios.get("http://localhost:8090/doctors");
      setDoctors(result.data);
    } catch (err) {
      console.log(err);
    }
  };

  const loadPatients = async () => {
    try {
      const result = await axios.get("http://localhost:8090/patients");
      setPatients(result.data);
    } catch (err) {
      console.log(err);
    }
  };

  const loadNurses = async () => {
    try {
      const result = await axios.get("http://localhost:8090/nurse");
      setNurses(result.data);
    } catch (err) {
      console.log(err);
    }
  };

  const handleEdit = (role, id) => {
    if (role === "Doctor") {
      localStorage.setItem("role", "Doctor");
    } else if (role === "Patient") {
      localStorage.setItem("role", "Patient");
    } else if (role === "Nurse") {
      localStorage.setItem("role", "Nurse");
    }
    navigate(`edituser/${id}`);
  };

  return (
    <div>
      <div className="py-4">
        {appointments.length > 0 ? (
          <div>
            <h2 className="text-center m-4">
              There are {appointments.length} appointments
            </h2>
            <br></br>
            <table className="table border shadow">
              <thead>
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">doctor</th>
                  <th scope="col">patient</th>
                  <th scope="col">date</th>
                </tr>
              </thead>
              <tbody>
                {appointments.map((appointment, index) => (
                  <tr key={index}>
                    <th scope="row">{index + 1}</th>
                    <td>{appointment.doctorName}</td>
                    <td>{appointment.patientName}</td>
                    <td>{appointment.date}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        ) : (
          <h2 className="m-4">Their is no appointment</h2>
        )}
      </div>

      <div>
        {doctors.length > 0 ? (
          <div>
            <h2 className="text-center m-4">
              There are {doctors.length} doctors under management
            </h2>
            <br></br>
            <table className="table border shadow">
              <thead>
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">ID</th>
                  <th scope="col">Name</th>
                  <th scope="col">Phone number</th>
                  <th scope="col">Date of birth</th>
                  <th scope="col" style={{ width: 250 }}>
                    Email
                  </th>
                  <th scope="col">Action</th>
                </tr>
              </thead>
              <tbody>
                {doctors.map((doctor, index) => (
                  <tr key={index}>
                    <th scope="row">{index + 1}</th>
                    <td>{doctor.doctorId}</td>
                    <td>{doctor.doctorName}</td>
                    <td>{doctor.doctorPhoneNum}</td>
                    <td>{doctor.doctorDob}</td>
                    <td style={{ width: 250 }}>{doctor.doctorEmail}</td>
                    <td>
                      <button
                        onClick={() => handleEdit("Doctor", doctor.doctorId)}
                      >
                        Edit
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        ) : (
          <h2 className="text-center m-4">Their is no doctor to be shown</h2>
        )}
      </div>

      <div>
        {patients.length > 0 ? (
          <div>
            <h2 className="text-center m-4">
              There are {patients.length} patients under management
            </h2>
            <br></br>
            <table className="table">
              <thead>
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">ID</th>
                  <th scope="col">Name</th>
                  <th scope="col">Phone number</th>
                  <th scope="col">Date of birth</th>
                  <th scope="col" style={{ width: 250 }}>
                    Email
                  </th>
                  <th scope="col">Medical Record</th>
                  <th scope="col">Action</th>
                </tr>
              </thead>
              <tbody>
                {patients.map((patient, index) => (
                  <tr key={index}>
                    <th scope="row">{index + 1}</th>
                    <td>{patient.patientId}</td>
                    <td>
                      {patient.patientFirstName + " " + patient.patientLastName}
                    </td>
                    <td>{patient.patientPhone}</td>
                    <td>{patient.patientDob}</td>
                    <td style={{ width: 250 }}>{patient.patientEmail}</td>
                    <td>{patient.patientMedicalRecord}</td>
                    <td>
                      <button
                        onClick={() => handleEdit("Patient", patient.patientId)}
                      >
                        Edit
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        ) : (
          <h2 className="text-center m-4">Their is no patient to be shown</h2>
        )}
      </div>

      <div>
        {nurses.length > 0 ? (
          <div>
            <h2 className="text-center m-4">
              There are {nurses.length} nurses under management
            </h2>
            <br></br>
            <table className="table border shadow">
              <thead>
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">ID</th>
                  <th scope="col">Name</th>
                  <th scope="col">Phone number</th>
                  <th scope="col">Date of birth</th>
                  <th scope="col" style={{ width: 250 }}>
                    Email
                  </th>
                  <th scope="col">Action</th>
                </tr>
              </thead>
              <tbody>
                {nurses.map((nurse, index) => (
                  <tr key={index}>
                    <th scope="row">{index + 1}</th>
                    <td>{nurse.nurseId}</td>
                    <td>{nurse.nurseName}</td>
                    <td>{nurse.nursePhone}</td>
                    <td>{nurse.nurseDoB}</td>
                    <td style={{ width: 250 }}>{nurse.nurseEmail}</td>
                    <td>
                      <button
                        onClick={() => handleEdit("Nurse", nurse.nurseId)}
                      >
                        Edit
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        ) : (
          <h2 className="text-center m-4">Their is no nurse to be shown</h2>
        )}
      </div>
    </div>
  );
};

export default Operation;
