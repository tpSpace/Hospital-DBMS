import axios from 'axios';
import React, { useEffect, useState } from 'react';

const Shift = () => {

    const [shifts, setShifts] = useState([]);

    const id = localStorage.getItem('id');

    useEffect(() => {
        loadShifts();
    }, []);

    const loadShifts = async () => {
        await axios.get(`http://localhost:8090/incharge/nurse/${id}`)
        .then(response => {
            setShifts(response.data);
        })
        .catch(err => {
            console.log(err);
        })
    }

    return (
        <div className='py-4'>
            { shifts.length > 0 ? (
                <div className='text-center'>
                    <h2 className="text-center m-4">You have {shifts.length} shifts</h2>
                    <br></br>
                    <table className="table border shadow">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">RoomID</th>
                                <th scope="col">Date</th>
                                <th scope="col">Shift Time</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                shifts.map((shift, index) => (
                                    <tr key={index}>
                                        <th scope="row" >{index + 1}</th>
                                        <td>{shift.roomID}</td>
                                        <td>{shift.date}</td>
                                        <td>{shift.shift}</td>
                                    </tr>
                                ))
                            }
                        </tbody>
                    </table>
                </div>
                
            ) : (
                <h2 className="m-4">Well done! You can rest :D</h2>
            )}
            
        </div>
    )
}

export default Shift