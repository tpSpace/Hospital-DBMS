import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

const ViewInfoDoctor = () => {
    
    const [doctor, setDoctor] = useState({
        doctorName: "",
        doctorPhoneNum: "",
        doctorDob: "",
        doctorEmail: "",
        doctorPassword: ""
    });
    
    useEffect(() => {
        loadDoctor();
    },[]);

    const loadDoctor = async () => {
        let doctorId = localStorage.getItem("id");
        await axios.get(`http://localhost:8090/doctor/${doctorId}`)
        .then(response => {
            setDoctor(response.data);
        })
        .catch(error => {
            console.log(error);
        });
    };

    return (
        <div className="container">
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center m-4">Doctor Details</h2>

                    <div className='card'>
                        <div className='card-header'>
                            <ul className='list-group list-group-frush'>
                                <li className='list-group-item'>
                                    <b>Name: </b>
                                    {doctor.doctorName}
                                </li>
                                <li className='list-group-item'>
                                    <b>Phone number: </b>
                                    {doctor.doctorPhoneNum}
                                </li>
                                <li className='list-group-item'>
                                    <b>Date of birth: </b>
                                    {doctor.doctorDob}
                                </li>
                                <li className='list-group-item'>
                                    <b>Email: </b>
                                    {doctor.doctorEmail}
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div className='buttons-container'>
                        <Link className='btn btn-secondary' to={`/edituser/${doctor.doctorId}`}>Edit</Link>
                        <Link className='btn btn-primary' to='/'>Back to home</Link>
                    </div>
                </div>
            </div>
        </div>
    )
};

export default ViewInfoDoctor;