import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const PatientAppointment = () => {

    let navigate = useNavigate();

    const [appointments, setAppointments] = useState([]);
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
    const [appointment, setAppointment] = useState({
        patient: {},
        Date: ""
    });

    const id = localStorage.getItem('id');

    useEffect(() => {
        loadAppointments();
        loadPatient();
    }, []);

    const loadPatient = async () => {
        await axios.get(`http://localhost:8090/patients/${id}`)
        .then(response => {
            console.log(response);
            setPatient(response.data);
        })
        .catch(error => {
            console.log(error);
        });

        navigate("/viewinfo");
    }

    const loadAppointments = async () => {
        await axios.get(`http://localhost:8090/appointment/patient/${id}`)
        .then(response => {
            setAppointments(response.data);
        })
        .catch(err => {
            console.log(err);
        });
    }

    const handleAddAppointment = async (e) => {
        e.preventDefault();
        const datePicker = document.getElementById('date-picker');
        const dueDate = datePicker.value;
        setAppointment({
            patient: patient,
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
                    <div className='appointment-picker'>
                        <h2>Make a new appointment</h2>
                        <input id="date-picker" type="datetime-local" required></input>
                        <button className='btn btn-primary mx-2' onClick={() => handleAddAppointment()}>Add new appointment</button>
                    </div>
                </div>
                
            ) : (
                <h2 className="m-4">You have no appointment</h2>
            )}
            
        </div>
    )
}

export default PatientAppointment