import React, {useState} from 'react'
import './Register.css'
import axios from 'axios';
import { Link,useNavigate } from 'react-router-dom';

const Register = () => {
    let navigate=useNavigate();
    const [patient,setPatient] = useState({
        patientFirstName: "",
        patientLastName: "",
        patientDob: "",
        patientGender : "",
        patientMedicalRecord: "N/A",
        patientPhone: "",
        patientEmail: "",
        patientPassword: "",
    });

    const {patientFirstName,patientLastName,patientDob,patientGender,patientMedicalRecord,patientPhone,patientEmail,patientPassword} = patient;

    const onInputChange = (e) => {
        setPatient({...patient,[e.target.name]:e.target.value});
    }
    const onSubmit = async (e) => {
        e.preventDefault();
        await axios.post("http://localhost:8080/createPatients", patient);
        navigate("/");
      }
    return (
        <>
            <div className="Container">
            
                <div className="register">
                    <h1>Register</h1>
                    <form id="register-form" onSubmit={e => onSubmit(e)}> 
                    
                        <label htmlFor="patientFirstName">First name</label><br/>
                        <input 
                            type={"text"}
                            id="patientFirstName" 
                            name="patientFirstName" 
                            placeholder="Enter your first name" 
                            
                            value={patientFirstName}
                            onChange={(e) => onInputChange(e)}
                            required
                        /><br/>

                        <label htmlFor="patientLastName">Last name</label><br/>
                        <input 
                            type="text" 
                            id="patientLastName" 
                            name="patientLastName" 
                            placeholder="Enter your last name" 
                            value={patientLastName}
                            onChange={(e) => onInputChange(e)}
                            required
                        /><br/>

                        <label htmlFor="patientDob">Date of birth</label><br/>
                        <input 
                            type="date" 
                            id="patientDob" 
                            name="patientDob" 
                            placeholder="Enter your dob" 
                            value={patientDob}
                            onChange={(e) => onInputChange(e)}
                            required
                        /><br/>

                        <label htmlFor="patientGender">Choose your gender</label><br/>
                        <input 
                            type="text" 
                            id="patientGender" 
                            name="patientGender" 
                            placeholder='Male or Female'
                            value={patientGender}
                            onChange={(e) => onInputChange(e)}
                            required
                        /><br/>
                        
                        <label htmlFor="phone">Phone</label><br/>
                        <input 
                            type="tel" 
                            id="patientPhone" 
                            name="patientPhone" 
                            placeholder="Enter your phone" 
                            value={patientPhone}
                            onChange={(e) => onInputChange(e)}
                            required
                        /><br/>

                        <label htmlFor="patientEmail">Email</label><br/>
                        <input 
                            type="email" 
                            id="patientEmail" 
                            name="patientEmail" 
                            placeholder="Enter your email" 
                            value={patientEmail}
                            onChange={(e) => onInputChange(e)}
                            required
                        /><br/>            

                        <label htmlFor="patientPassword">Password</label><br/>
                        <input 
                            type="password" 
                            id="patientPassword" 
                            name="patientPassword" 
                            placeholder="Enter your password" 
                            value={patientPassword}
                            onChange={(e) => onInputChange(e)}
                            required
                        /><br/> 

                        <label htmlFor="patientMedicalRecord">Medical record</label><br/>
                        <textarea  
                            type="text" 
                            id="patientMedicalRecord"
                            name="patientMedicalRecord"
                            placeholder="Enter your password" 
                            value={patientMedicalRecord}
                            onChange={(e) => onInputChange(e)}
                            maxLength="200"
                        /><br/> 

                        
                                                            
                        <button type="submit" value="Submit" id="submit">Submit</button>
                    </form>
                </div>
            </div>
        </>
    );
};

export default Register;