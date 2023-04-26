import axios from 'axios';
import React, { useEffect, useState } from 'react'

const Appointment = () => {
    const role = localStorage.getItem('role');

    const [doctors, setDoctors] = useState([]);
    const [patients, setPatients] = useState([]);
    const [appointments, setAppointments] = useState([]);

    useEffect(() => {
        loadDoctors();
        loadPatients();
        getAppointments();
    }, []);

    // get doctor's id
    const loadDoctors = async () => {
        const result = await axios.get("http://localhost:8090/doctors");
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

    // get patient's id
    const loadPatients = async () => {
        const result = await axios.get("http://localhost:8090/patients");
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

    // get the corresponding appointment
    const getAppointments = async (id) => {
        if(role.includes('Doctor')){
            const result = await axios.get(`http://localhost:8090/appointment/doctor/${id}`);
            console.log(result.data);
            setAppointments(result.data);
        } else if(role.includes('Patient')){
            const result = await axios.get(`http://localhost:8090/appointment/patient/${id}`);
            setAppointments(result.data);
        }
    }

    const loadAppointments = () => {
        if(role.includes('Doctor')){
            getAppointments(getDoctorId(localStorage.getItem('email')));
        } else if(role.includes('Patient')) {
            getAppointments(getPatientId(localStorage.getItem('email')));
        }
        //console.log(appointments);
    }

    loadAppointments();

    return (
        <div className='py-4'>
            { appointments.length > 0 ? (
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
                        {
                            appointments.map((appointment, index) => (
                                <tr>
                                    <th scope="row" key={appointment}>{index + 1}</th>
                                    <td>{appointment.doctorName}</td>
                                    <td>{appointment.patientName}</td>
                                    <td>{appointment.date}</td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            ) : (
                <p>You have no appointment</p>
            )}
            
        </div>
    )
}

export default Appointment