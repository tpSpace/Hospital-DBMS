import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

const NurseInfo = () => {
    const [nurse, setNurse] = useState({
        nurseName: "",
        nursePhone: "",
        nurseDoB: "",
        nurseEmail: "",
        nursePassword: ""
    });
    useEffect(() => {
        loadNurse();
    },[]);
    const loadNurse = async () => {
        let nurseId = localStorage.getItem("id");
        await axios.get(`http://localhost:8090/nurse/${nurseId}`)
        .then(response => {
            setNurse(response.data);
        })
        .catch(error => {
            console.log(error);
        });
    };
    
    return (
        <div className="container">
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center m-4">Nurse Details</h2>

                    <div className='card'>
                        <div className='card-header'>
                            <ul className='list-group list-group-frush'>
                                <li className='list-group-item'>
                                    <b>Name: </b>
                                    {nurse.nurseName}
                                </li>
                                <li className='list-group-item'>
                                    <b>Phone number: </b>
                                    {nurse.nursePhone}
                                </li>
                                <li className='list-group-item'>
                                    <b>Date of birth </b>
                                    {nurse.nurseDoB}
                                </li>
                                <li className='list-group-item'>
                                    <b>Email </b>
                                    {nurse.nurseEmail}
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div className='buttons-container'>
                        <Link className='btn btn-secondary' to={`/edituser/${nurse.nurseId}`}>Edit</Link>
                        <Link className='btn btn-primary' to='/'>Back to home</Link>
                    </div>
                </div>
            </div>
        </div>
    )
};

export default NurseInfo;