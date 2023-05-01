import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

const PatientInfo = () => {

    const [patient, setPatient] = useState({
        patientFirstName: "",
        patientLastName: "",
        patientGender: "",
        patientMedicalRecord: "",
        patientPhone: "",
        patientDob: "",
        patientEmail: "",
        patientPassword: ""
    });
    
    useEffect(() => {
        loadPatient();
    },[]);

    const loadPatient = async () => {
        let patientId = localStorage.getItem("id");
        await axios.get(`http://localhost:8090/patients/${patientId}`)
        .then(response => {
            console.log(response);
            setPatient(response.data);
        })
        .catch(error => {
            console.log(error);
        });
    };

    return (
        <div className="container">
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center m-4">Patient Details</h2>

                    <div className='card'>
                        <div className='card-header'>
                            <ul className='list-group list-group-frush'>
                                <li className='list-group-item'>
                                    <b>Name: </b>
                                    {patient.patientFirstName + " " + patient.patientLastName}
                                </li>
                                <li className='list-group-item'>
                                    <b>Phone number: </b>
                                    {patient.patientPhone}
                                </li>
                                <li className='list-group-item'>
                                    <b>Date of birth: </b>
                                    {patient.patientDob}
                                </li>
                                <li className='list-group-item'>
                                    <b>Email: </b>
                                    {patient.patientEmail}
                                </li>
                                <li className='list-group-item'>
                                    <b>Medical record: </b>
                                    {patient.patientMedicalRecord}
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div className='buttons-container'>
                        <Link className='btn btn-secondary' to={`/edituser/${patient.patientId}`}>Edit</Link>
                        <Link className='btn btn-primary' to='/'>Back to home</Link>
                    </div>
                </div>
            </div>
        </div>
    )
};

export default PatientInfo;