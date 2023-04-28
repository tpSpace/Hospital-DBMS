import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

const ViewInfo = () => {
    const role = localStorage.getItem('role');

    const [doctors, setDoctors] = useState([]);
    const [doctor, setDoctor] = useState([]);

    const [patients, setPatients] = useState([]);
    const [patient, setPatient] = useState([]);

    const [nurses, setNurses] = useState([]);
    const [nurse, setNurse] = useState([]);

    const [staffs, setStaffs] = useState([]);
    const [staff, setStaff] = useState([]);

    useEffect(() => {
        loadDoctors();
        loadPatients();
        loadNurses();
        loadStaffs();
    }, [role]);

    // display doctor
    const loadDoctors = async () => {
        const result = await axios.get("http://localhost:8090/doctors").catch((err) => {console.log(err)});
        setDoctors(result.data);
    }

    const getDoctorId = (email) => {
        const result = doctors.filter((doctor) => doctor.doctorEmail.includes(email));
        if (result.length > 0) {
            return result[0].doctorId;
        } else {
            return null;
        }
    }

    const loadDoctor = async (id) => {
        const result = await axios.get(`http://localhost:8090/doctor/${id}`).catch((err) => {console.log(err)});
        setDoctor(result.data);
    }

    // display patient
    const loadPatients = async () => {
        const result = await axios.get("http://localhost:8090/patients").catch((err) => {console.log(err)});
        setPatients(result.data);
    }

    const getPatientId = (email) => {
        const result = patients.filter((patient) => patient.patientEmail.includes(email));
        if (result.length > 0) {
            return result[0].patientId;
        } else {
            return null;
        }
    }

    const loadPatient = async (id) => {
        const result = await axios.get(`http://localhost:8090/patients/${id}`).catch((err) => {console.log(err)});
        setPatient(result.data);
    }

    // display nurse
    const loadNurses = async () => {
        const result = await axios.get("http://localhost:8090/nurse").catch((err) => {console.log(err)});
        setNurses(result.data);
    }

    const getNurseId = (email) => {
        const result = nurses.filter((nurse) => nurse.nurseEmail.includes(email));
        if (result.length > 0) {
            return result[0].nurseId;
        } else {
            return null;
        }
    }

    const loadNurse = async (id) => {
        const result = await axios.get(`http://localhost:8090/nurse/${id}`).catch((err) => {console.log(err)});
        setNurse(result.data);
    }

    // display staff
    const loadStaffs = async () => {
        const result = await axios.get("http://localhost:8090/staff").catch((err) => {console.log(err)});
        setStaffs(result.data);
    }

    const getStaffId = (email) => {
        const result = staffs.filter((staff) => staff.staffEmail.includes(email));
        if (result.length > 0) {
            return result[0].staffId;
        } else {
            return null;
        }
    }

    const loadStaff = async (id) => {
        const result = await axios.get(`http://localhost:8090/staff/${id}`).catch((err) => {console.log(err)});
        setStaff(result.data);
    }

    const display = () => {
        if(role.includes('Doctor')) {
            loadDoctor(getDoctorId(localStorage.getItem('email')));
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
                            <Link className='btn btn-outline mx-2' to={`/edituser/${doctor.doctorId}`}>Edit</Link>
                            <Link className='btn btn-primary my-2' to='/'>Back to home</Link>
                        </div>
                    </div>
                </div>
            )
        } else if (role.includes('Patient')) {
            loadPatient(getPatientId(localStorage.getItem('email')));
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
                                            <b>Date of birth </b>
                                            {patient.patientDob}
                                        </li>
                                        <li className='list-group-item'>
                                            <b>Email </b>
                                            {patient.patientEmail}
                                        </li>
                                        <li className='list-group-item'>
                                            <b>Medical record </b>
                                            {patient.patientMedicalRecord}
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <Link className='btn btn-outline mx-2' to={`/edituser/${patient.patientId}`}>Edit</Link>
                            <Link className='btn btn-primary my-2' to='/'>Back to home</Link>
                        </div>
                    </div>
                </div>
            )
        } else if(role.includes('Nurse')) {
            loadNurse(getNurseId(localStorage.getItem('email')));
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
                            <Link className='btn btn-outline mx-2' to={`/edituser/${nurse.nurseId}`}>Edit</Link>
                            <Link className='btn btn-primary my-2' to='/'>Back to home</Link>
                        </div>
                    </div>
                </div>
            )
        } else if (role.includes('Staff')) {
            loadStaff(getStaffId(localStorage.getItem('email')));
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
                            <Link className='btn btn-outline mx-2' to={`/edituser/${staff.staffId}`}>Edit</Link>
                            <Link className='btn btn-primary my-2' to='/'>Back to home</Link>
                        </div>
                    </div>
                </div>
            )
        } else {
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