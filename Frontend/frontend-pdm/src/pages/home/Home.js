import axios from 'axios';
import React, { useEffect, useState } from 'react';

const Home = () => {
    const [appointments, setAppointments] = useState([]);

    useEffect(() => {
        loadAppointments();
    }, []);

    const loadAppointments = async() => {
        const result = await axios.get("http://localhost:8080/appointments");
        setAppointments(result);
    };

    return (
        <div className='container-home'>
            <div className='py-4'>
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
                                    <th scope="row" key={index}>{index + 1}</th>
                                    <td>{appointment.doctocName}</td>
                                    <td>{appointment.patientName}</td>
                                    <td>{appointment.Date}</td>
                                    
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>
        </div>
    );
};
// 
export default Home;