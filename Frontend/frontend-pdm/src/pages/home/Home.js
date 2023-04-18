import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { getAuthorize } from '../login/Login';

const Home = () => {
    const role = getAuthorize();
    const [appointments, setAppointments] = useState([]);
    const [auth, setAuth] = useState(false);

    if(role){
        setAuth(true);
    }

    useEffect(() => {
        loadAppointments();
    }, []);

    const loadAppointments = async() => {
        const result = await axios.get("http://localhost:8090/appointment");
        setAppointments(result.data);
    }

    return (
        <>
            {auth ? (
                <div className='container'>
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
                                            <td>{appointment.doctorName}</td>
                                            <td>{appointment.patientName}</td>
                                            <td>{appointment.date}</td>
                                            
                                        </tr>
                                    ))
                                }
                            </tbody>
                        </table>
                    </div>
                
                </div>
            
            ) : (
                <div>Nothing to display</div>
            )}
            
        </>
    );
};
// 
export default Home;