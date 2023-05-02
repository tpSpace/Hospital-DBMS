import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";

const EditNurse = () => {
    let navigate = useNavigate();

    const [nurse, setNurse] = useState({
        nurseName: "",
        nurseDoB: "",
        nursePhone: "",
        nurseEmail: "",
        nursePassword: ""
    });

    const { nurseName, nurseDoB, nursePhone, nurseEmail, nursePassword } = nurse;

    useEffect(() => {
        const loadNurse = async () => {
            const id = localStorage.getItem("id");
            await axios.get(`http://localhost:8090/nurse/${id}`)
            .then(response => {
                setNurse(response.data);
                console.log(response.data);
            })
            .catch(error => console.log(error));
        };
        loadNurse();
    }, []);

    const onInputChange = (e) => {
        setNurse({...nurse, [e.target.name]: e.target.value});
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        const id = localStorage.getItem("id");
        for (var k in nurse) {
            if (nurse.hasOwnProperty(k)) {
                nurse[k] = String(nurse[k]);
            }
        }
        await axios.put(`http://localhost:8090/nurse/${id}`, nurse)
        .then(response => {
            console.log(response.data);
            alert("Nurse information updated successfully!");
        })
        .catch(error => console.log(error));

        navigate("/viewinfo");
    };

    return (
        <div className="Container">

            <div className="register">
                <h1>Edit information</h1>
                <form id="register-form" onSubmit={e => onSubmit(e)}> 
                
                    <label htmlFor="nurseName">Nurse name</label><br/>
                    <input 
                        type={"text"}
                        id="nurseName" 
                        name="nurseName" 
                        placeholder="Enter your name" 
                        value={nurseName}
                        onChange={(e) => onInputChange(e)}
                        required
                    /><br/>

                    <label htmlFor="nurseDob">Date of birth</label><br/>
                    <input 
                        type="date" 
                        id="nurseDob" 
                        name="nurseDob" 
                        placeholder="Enter your date of birth" 
                        value={nurseDoB}
                        onChange={(e) => onInputChange(e)}
                        required
                    /><br/>

                    <label htmlFor="nursePhone">Phone Number</label><br/>
                    <input 
                        type="tel" 
                        id="nursePhone" 
                        name="nursePhone" 
                        placeholder="Enter your phone number" 
                        value={nursePhone}
                        onChange={(e) => onInputChange(e)}
                        required
                    /><br/>

                    <label htmlFor="nurseEmail">Email</label><br/>
                    <input 
                        type="email" 
                        id="nurseEmail"
                        name="nurseEmail"
                        placeholder="Enter your email" 
                        value={nurseEmail}
                        onChange={(e) => onInputChange(e)}
                        required
                    /><br/>            

                    <label htmlFor="nursePassword">Password</label><br/>
                    <input 
                        type="password" 
                        id="nursePassword" 
                        name="nursePassword" 
                        placeholder="Enter your password" 
                        value={nursePassword}
                        onChange={(e) => onInputChange(e)}
                        required
                    /><br/> 
                                                        
                    <button type="submit" value="Submit" id="submit">Submit</button>
                    <Link className="btn btn-outline-danger mx-2" to="/">
                        Cancel
                    </Link>
                </form>
            </div>
        </div>
    )
};

export default EditNurse;