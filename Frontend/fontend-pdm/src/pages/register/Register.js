import React from 'react';
import './register.css';
const Register = () => {
    return (
        <>
            <div class="container">
                <div class="register">
                    <h1>Register</h1>
                    <form action="">
                        <label>
                            Email
                            <br/>
                            <input type="email" placeholder="Email"></input>
                            <br/>
                        </label>
                        
                        <label>
                            <span>Password</span>
                            <br/>   
                            <input type="text" placeholder="Password"></input>
                            <br/>
                        </label>

                        <label>
                            <span>Re-type password</span>
                            <br/>
                            <input type="text" placeholder="Re-type password"></input>
                            <br/>
                        </label>
                        
                        <button type="submit">SUBMIT</button>
                    </form>
                </div>
            </div>
        </>
    );
};

export default Register;