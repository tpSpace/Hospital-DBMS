import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

const StaffInfo = () => {
    const [staff, setStaff] = useState({
        staffName: "",
        staffPhone: "",
        staffDoB: "",
        staffEmail: "",
        staffPassword: ""
    });
    useEffect(() => {
        loadStaff();
    },[]);
    const loadStaff = async () => {
        let staffId = localStorage.getItem("id");
        await axios.get(`http://localhost:8090/staff/${staffId}`)
        .then(response => {
            setStaff(response.data);
        })
        .catch(error => {
            console.log(error);
        });
    };
    
    return (
        <div className="container">
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center m-4">Staff Details</h2>

                    <div className='card'>
                        <div className='card-header'>
                            <ul className='list-group list-group-frush'>
                                <li className='list-group-item'>
                                    <b>Name: </b>
                                    {staff.staffName}
                                </li>
                                <li className='list-group-item'>
                                    <b>Phone number: </b>
                                    {staff.staffPhone}
                                </li>
                                <li className='list-group-item'>
                                    <b>Date of birth </b>
                                    {staff.staffDoB}
                                </li>
                                <li className='list-group-item'>
                                    <b>Email </b>
                                    {staff.staffEmail}
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div className='buttons-container'>
                        <Link className='btn btn-secondary' to={`/edituser/${staff.staffId}`}>Edit</Link>
                        <Link className='btn btn-primary' to='/'>Back to home</Link>
                    </div>
                </div>
            </div>
        </div>
        )
};

export default StaffInfo;