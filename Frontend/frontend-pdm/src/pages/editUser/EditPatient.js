import React, {useState, useEffect} from "react";
import {Link} from "react-router-dom";
import axios from "axios";

const EditPatient = () => {

    const [patient, setPatient] = useState({
        patientFirstName: "",
        patientLastName: "",
        patientDob: "",
        patientGender: "",
        patientMedicalRecord: "",
        patientPhone: "",
        patientEmail: "",
        patientPassword: ""
    });

    const {patientFirstName , patientLastName, patientDob, patientGender, patientMedicalRecord, patientPhone, patientEmail, patientPassword} = patient;

    useEffect(() => {
        const loadPatient = async () => {
            const id = localStorage.getItem("id");
            await axios.get(`http://localhost:8090/patients/${id}`)
            .then(response => {
                setPatient(response.data);
                console.log(response.data);
            })
            .catch(error => console.log(error));
        };
        loadPatient();
    }, []);

    const onInputChange = (e) => {
        setPatient({...patient, [e.target.name]: e.target.value});
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        const id = localStorage.getItem("id");
        for (var k in patient) {
            if (patient.hasOwnProperty(k)) {
                patient[k] = String(patient[k]);
            }
        }
        await axios.put(`http://localhost:8090/patients/${id}`, patient)
        .then(response => {
            console.log(response.data);
            alert("Your information updated successfully!");
        })
        .catch(error => console.log(error));
    };

    return (
        <div className="Container">

            <div className="register">
                <h1>Edit information</h1>
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
                    <Link className="btn btn-outline-danger mx-2" to="/">
                        Cancel
                    </Link>
                </form>
            </div>
        </div>
    )
};

export default EditPatient;