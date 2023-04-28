import axios from 'axios';
import React, { useEffect, useState } from 'react'
import './Appointment.css';

const Appointment = () => {
    const role = localStorage.getItem('role');

    const [doctors, setDoctors] = useState([]);
    const [patients, setPatients] = useState([]);
    const [appointments, setAppointments] = useState([]);
    const [appointment, setAppointment] = useState({
        patient: "",
        Date: ""
    });
    const email = localStorage.getItem('email');

    useEffect(() => {
        loadDoctors();
        loadPatients();
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

    // get the corresponding appointments
    const getAppointments = async (id) => {
        if(role.includes('Doctor')){
            const result = await axios.get(`http://localhost:8090/appointment/doctor/${id}`);
            setAppointments(result.data);
        } else if(role.includes('Patient')){
            const result = await axios.get(`http://localhost:8090/appointment/patient/${id}`);
            setAppointments(result.data);
        }
    }

    // load all the appropriate appointments
    const loadAppointments = () => {
        if(role.includes('Doctor')){
            getAppointments(getDoctorId(email));
        } else if(role.includes('Patient')) {
            getAppointments(getPatientId(email));
        }
    }

    loadAppointments();

    const handleAddAppointment = async (e) => {
        e.preventDefault();
        const datePicker = document.getElementById('date-picker');
        const dueDate = datePicker.value;
        const Patient = patients.filter((patient) => patient.patientEmail.includes(localStorage.getItem('email')))
        setAppointment({
            patient: Patient,
            Date: dueDate
        });
        await axios.post('http://localhost:8090/appointment', appointment);
        loadAppointments();
    }

    return (
        <div className='py-4'>
            { appointments.length > 0 ? (
                <div className='text-center'>
                    <h2 className="text-center m-4">You have {appointments.length} appointments</h2>
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
                            {
                                appointments.map((appointment, index) => (
                                    <tr key={index}>
                                        <th scope="row" >{index + 1}</th>
                                        <td>{appointment.doctorName}</td>
                                        <td>{appointment.patientName}</td>
                                        <td>{appointment.date}</td>
                                    </tr>
                                ))
                            }
                        </tbody>
                    </table>
                    { role.includes('Patient') ? (
                        <div className='appointment-picker'>
                            <h2>Make a new appointment</h2>
                            <input id="date-picker" type="datetime-local" required></input>
                            <button className='btn btn-primary mx-2' onClick={() => handleAddAppointment()}>Add new appointment</button>
                        </div>
                    ) : (
                        <></>
                    )}
                </div>
                
            ) : (
                <h2 className="m-4">You have no appointment</h2>
            )}
            
        </div>
    )
}

export default Appointment