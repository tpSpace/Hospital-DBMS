import React, { useState } from 'react';
import { useEffect } from 'react';

const Shift = () => {

    const [nurses, setNurses] = useState([]);
    const [shift, setShift] = useState([]);

    useEffect(() => {
        loadNurses();
    }, []);

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

    const loadShift = async (id) => {
        const result = await axios.get(`http://localhost:8090/incharge/nurse/${id}`).catch((err) => {console.log(err)});
        setShift(result.data);
    }

    const render = () => {
        loadShift(getNurseId(localStorage.getItem('email')));
        return (
            <div className="container">
                <div className="row">
                    <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                        <h2 className="text-center m-4">Shift detail</h2>

                        <div className='card'>
                            <div className='card-header'>
                                <ul className='list-group list-group-frush'>
                                    <li className='list-group-item'>
                                        <b>Room ID </b>
                                        {shift.roomID}
                                    </li>
                                    <li className='list-group-item'>
                                        <b>Date </b>
                                        {shift.date}
                                    </li>
                                    <li className='list-group-item'>
                                        <b>Shift </b>
                                        {shift.shift}
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <Link className='btn btn-primary my-2' to='/'>Back to home</Link>
                    </div>
                </div>
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