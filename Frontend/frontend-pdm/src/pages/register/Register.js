import React, {useState} from 'react'
import './Register.css'
import axios from 'axios';
import { Link,useNavigate } from 'react-router-dom';

const Register = () => {

    const [user,setUser] = useState({
        patientFirstName: "",
        patientLastName: "",
        patientDob: "",
        patientGender : "",
        patientMedicalRecord: "N/A",
        patientPhone: "",
        patientEmail: "",
        patientPassword: "",
    });

    const {patientFirstName,patientLastName,patientDob,patientGender,patientMedicalRecord,patientPhone,patientEmail,patientPassword} = user;

    const onInputChange = (e) => {
        setUser({...user,[e.target.name]:e.target.value});
    }

    return (
        <>
            <div class="Container">
            
                <div class="register">
                    <h1>Register</h1>
                    <form id="register-form"> 
                    
                        <label for="patientFirstName">First name</label><br/>
                        <input 
                            type={"text"}
                            id="patientFirstName" 
                            name="patientFirstName" 
                            placeholder="Enter your first name" 
                            
                            value={patientFirstName}
                            onChange={(e) => onInputChange(e)}
                            required
                        /><br/>

                        <label for="patientLastName">Last name</label><br/>
                        <input 
                            type="text" 
                            id="patientLastName" 
                            name="patientLastName" 
                            placeholder="Enter your last name" 
                            value={patientLastName}
                            onChange={(e) => onInputChange(e)}
                            required
                        /><br/>

                        <label for="patientDob">Date of birth</label><br/>
                        <input 
                            type="date" 
                            id="patientDob" 
                            name="patientDob" 
                            placeholder="Enter your dob" 
                            value={patientDob}
                            onChange={(e) => onInputChange(e)}
                            required
                        /><br/>

                        <label for="patientGender">Choose your gender</label><br/>
                        <input 
                            type="text" 
                            id="patientGender" 
                            name="patientGender" 
                            placeholder='Male or Female'
                            value={patientGender}
                            onChange={(e) => onInputChange(e)}
                            required
                        /><br/>
                        
                        <label for="phone">Phone</label><br/>
                        <input 
                            type="tel" 
                            id="patientPhone" 
                            name="patientPhone" 
                            placeholder="Enter your phone" 
                            value={patientPhone}
                            onChange={(e) => onInputChange(e)}
                            required
                        /><br/>

                        <label for="patientEmail">Email</label><br/>
                        <input 
                            type="email" 
                            id="patientEmail" 
                            name="patientEmail" 
                            placeholder="Enter your email" 
                            value={patientEmail}
                            onChange={(e) => onInputChange(e)}
                            required
                        /><br/>            

                        <label for="patientPassword">Password</label><br/>
                        <input 
                            type="password" 
                            id="patientPassword" 
                            name="patientPassword" 
                            placeholder="Enter your password" 
                            value={patientPassword}
                            onChange={(e) => onInputChange(e)}
                            required
                        /><br/> 

                        <label for="patientMedicalRecord">Medical record</label><br/>
                        <textarea  
                            type="text" 
                            id="patientMedicalRecord"
                            name="patientMedicalRecord"
                            placeholder="Enter your password" 
                            value={patientMedicalRecord}
                            onChange={(e) => onInputChange(e)}
                            maxlength="200"
                        /><br/> 

                        
                                                            
                        <button type="submit" value="Submit" id="submit">Submit</button>
                    </form>
                </div>
            </div>
        </>
    );
};

export default Register;