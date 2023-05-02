import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";

const EditStaff = () => {

    let navigate = useNavigate();

    const [staff, setStaff] = useState({
        staffName: "",
        staffDoB: "",
        staffPhone: "",
        staffEmail: "",
        staffPassword: ""
    });

    const { staffDoB, staffEmail,staffName, staffPassword,staffPhone  } = staff;

    useEffect(() => {
        const loadStaff = async () => {
            const id = localStorage.getItem("id");
            await axios.get(`http://localhost:8090/staff/${id}`)
            .then(response => {
                setStaff(response.data);
                console.log(response.data);
            })
            .catch(error => console.log(error));
        };
        loadStaff();
    }, []);

    const onInputChange = (e) => {
        setStaff({ ...staff, [e.target.name]: e.target.value });
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        for (var k in staff) {
            if (staff.hasOwnProperty(k)) {
                staff[k] = String(staff[k]);
            }
        }
        const id = localStorage.getItem("id");
        await axios.put(`http://localhost:8090/staff/${id}`, staff)
        .then(response => {
            console.log(response.data);
            alert("Your information updated successfully!");
        })
        .catch(error => console.log(error));

        navigate("/viewinfo");
    };
    
    return (
        <div className="Container">

            <div className="register">
                <h1>Edit information</h1>
                <form id="register-form" onSubmit={e => onSubmit(e)}> 
                
                    <label htmlFor="staffName">Staff name</label><br/>
                    <input 
                        type={"text"}
                        id="staffName"
                        name="staffName"
                        placeholder="Enter your name" 
                        value={staffName}
                        onChange={(e) => onInputChange(e)}
                        required
                    /><br/>

                    <label htmlFor="staffDob">Date of birth</label><br/>
                    <input 
                        type="date" 
                        id="staffDob"
                        name="staffDob"
                        placeholder="Enter your date of birth" 
                        value={staffDoB}
                        onChange={(e) => onInputChange(e)}
                        required
                    /><br/>
                    
                    <label htmlFor="staffPhone">Phone Number</label><br/>
                    <input 
                        type="tel" 
                        id="staffPhone" 
                        name="staffPhone" 
                        placeholder="Enter your phone number" 
                        value={staffPhone}
                        onChange={(e) => onInputChange(e)}
                        required
                    /><br/>

                    <label htmlFor="staffEmail">Email</label><br/>
                    <input 
                        type="email" 
                        id="staffEmail"
                        name="staffEmail"
                        placeholder="Enter your email" 
                        value={staffEmail}
                        onChange={(e) => onInputChange(e)}
                        required
                    /><br/>            

                    <label htmlFor="staffPassword">Password</label><br/>
                    <input 
                        type="password" 
                        id="staffPassword" 
                        name="staffPassword"
                        placeholder="Enter your password" 
                        value={staffPassword}
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

export default EditStaff;