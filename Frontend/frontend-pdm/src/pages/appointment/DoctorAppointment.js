import React, { useState, useEffect } from 'react';
import axios from 'axios';

const DoctorAppointment = () => {

    const [appointments, setAppointments] = useState([]);

    const id = localStorage.getItem('id');

    useEffect(() => {
        loadAppointments();
    }, []);

    const loadAppointments = async () => {
        await axios.get(`http://localhost:8090/appointment/doctor/${id}`)
        .then(response => {
            setAppointments(response.data);
        })
        .catch(err => {
            console.log(err);
        });
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
            </div>
            
        ) : (
            <h2 className="text-center m-4">You have no appointment</h2>
        )}
        
    </div>
    )
}

export default DoctorAppointment