import axios from 'axios';
import React, { useEffect, useState } from 'react';

const Shift = () => {

    const [nurses, setNurses] = useState([]);
    const [shifts, setShifts] = useState([]);

    const email = localStorage.getItem('email');

    // display nurse
    const loadNurses = async () => {
        const result = await axios.get("http://localhost:8090/nurse").catch((err) => {console.log(err)});
        setNurses(result.data);
    }

    const getNurseId = (email) => {
        loadNurses();
        const result = nurses.filter((nurse) => nurse.nurseEmail.includes(email));
        if (result.length > 0) {
            return result[0].nurseId;
        } else {
            return null;
        }
    }

    const loadShifts = async () => {
        const id = getNurseId(email);
        const result = await axios.get(`http://localhost:8090/incharge/nurse/${id}`);
        setShifts(result.data);
    }

    const render = () => {
        loadShifts();
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

    return (
        <div>
            {render()}
        </div>
    )
}

export default Shift