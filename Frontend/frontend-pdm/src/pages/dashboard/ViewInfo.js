import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

const ViewInfo = () => {
    const role = localStorage.getItem('role');

    const [doctors, setDoctors] = useState([]);
    const [doctor, setDoctor] = useState([]);
    const [patient, setpatient] = useState([]);

    useEffect(() => {
        loadDoctors();
    }, []);

    const loadDoctors = async () => {
        const result = await axios.get("http://localhost:8090/doctors");
        setDoctors(result.data);
    }

    const getDoctorId = (email) => {
        const result = doctors.filter((doctor) => doctor.doctorEmail.includes(email));
        if (result.length > 0) {
            console.log(result);
            console.log(result[0].doctorId);
            return result[0].doctorId;
        } else {
            return null;
        }
    }

    const loadDoctor = async (id) => {
        const result = await axios.get(`http://localhost:8090/doctor/${id}`);
        setDoctor(result.data);
        console.log(result.data);
    }

    const loadPatient = async () => {
        const result = await axios.get("http://localhost:8090/patient");
        setpatient(result.data);
    }

    const display = () => {
        if(role.includes('Doctor')){
            console.log(getDoctorId(localStorage.getItem('email')));
            loadDoctor(getDoctorId(localStorage.getItem('email')));
            return (
                <div className="container">
                    <div className="row">
                        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                            <h2 className="text-center m-4">User Details</h2>

                            <div className='card'>
                                <div className='card-header'>
                                    Details of user: 
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
                                            <b>Date of birth </b>
                                            {doctor.doctorDob}
                                        </li>
                                        <li className='list-group-item'>
                                            <b>Email </b>
                                            {doctor.doctorEmail}
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <Link className='btn btn-primary my-2' to='/'>Back to home</Link>
                        </div>
                    </div>
                </div>
            )
        }else{
            return (
                <h2>View hey</h2>
            )
        }
    }
    return (
        
        <div>
            {display()}
        </div>
    )
}

export default ViewInfo;