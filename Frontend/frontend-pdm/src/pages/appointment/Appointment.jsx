import React from 'react'
import './Appointment.css';
import DoctorAppointment from './DoctorAppointment';
import PatientAppointment from './PatientAppointment';

const Appointment = () => {
    const role = localStorage.getItem('role');

    return (
        <>
            {role.includes('Doctor') && <DoctorAppointment/>}
            {role.includes('Patient') && <PatientAppointment/>}
        </>
      )
}

export default Appointment