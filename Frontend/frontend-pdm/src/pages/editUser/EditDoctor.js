import React, { useState, useEffect } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import axios from "axios";

const EditDoctor = () => {

    let navigate = useNavigate();
    
    const [doctor, setDoctor] = useState({
        doctorName: "",
        doctorPhoneNum: "",
        doctorDob: "",
        doctorEmail: "",
        doctorPassword: "",

    });
    
    const { doctorName, doctorPhoneNum, doctorDob, doctorEmail, doctorPassword } = doctor;

    let { id } = useParams();

    useEffect(() => {
        const loadDoctor = async () => {
            if(id === null){
                id = localStorage.getItem("id");
            }
            await axios.get(`http://localhost:8090/doctor/${id}`)
            .then(response => {
                setDoctor(response.data);
            })
            .catch(error => console.log(error));
        };
        loadDoctor();
    }, []);

    const onInputChange = (e) => {
        setDoctor({...doctor, [e.target.name]: e.target.value});
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        if(id === null){
            id = localStorage.getItem("id");
        }
        for (var k in doctor) {
            if (doctor.hasOwnProperty(k)) {
                doctor[k] = String(doctor[k]);
            }
        }
        await axios.put(`http://localhost:8090/doctor/${id}`, doctor)
        .then(response => {
            console.log(response.data);
            alert("Doctor information updated successfully!");
        })
        .catch(error => console.log(error));

        navigate("/viewinfo");
    };

    return (
        <div className="Container">
    
            <div className="register">
                <h1>Edit information</h1>
                <form id="register-form" onSubmit={e => onSubmit(e)}> 
                
                    <label htmlFor="doctorName">Doctor name</label><br/>
                    <input 
                        type={"text"}
                        id="doctorName" 
                        name="doctorName" 
                        placeholder="Enter your name" 
                        value={doctorName}
                        onChange={(e) => onInputChange(e)}
                        required
                    /><br/>

                    <label htmlFor="doctorPhoneNum">Phone Number</label><br/>
                    <input 
                        type="tel" 
                        id="doctorPhoneNum" 
                        name="doctorPhoneNum" 
                        placeholder="Enter your phone number" 
                        value={doctorPhoneNum}
                        onChange={(e) => onInputChange(e)}
                        required
                    /><br/>

                    <label htmlFor="doctorDob">Date of birth</label><br/>
                    <input 
                        type="date" 
                        id="doctorDob" 
                        name="doctorDob" 
                        placeholder="Enter your date of birth" 
                        value={doctorDob}
                        onChange={(e) => onInputChange(e)}
                        required
                    /><br/>

                    <label htmlFor="doctorEmail">Email</label><br/>
                    <input 
                        type="email" 
                        id="doctorEmail"
                        name="doctorEmail"
                        placeholder="Enter your email" 
                        value={doctorEmail}
                        onChange={(e) => onInputChange(e)}
                        required
                    /><br/>            

                    <label htmlFor="doctorPassword">Password</label><br/>
                    <input 
                        type="password" 
                        id="doctorPassword"
                        name="doctorPassword" 
                        placeholder="Enter your password" 
                        value={doctorPassword}
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

export default EditDoctor;