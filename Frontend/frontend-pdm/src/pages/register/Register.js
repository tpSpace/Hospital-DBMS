import React from 'react';
import './register.css';

const Register = () => {
    return (
        <>
            <div class="Container">
            
                <div class="register">
                    <h1>Register</h1>
                    <form id="register-form"> 
                    
                        <label for="first-name">First name</label><br/>
                        <input type="text" id="first-name" name="first-name" placeholder="Enter your first name" required/><br/>

                        <label for="last-name">Last name</label><br/>
                        <input type="text" id="last-name" name="last-name" placeholder="Enter your last name" required/><br/>

                        <label for="phone">Phone</label><br/>
                        <input type="tel" id="phone" name="phone" placeholder="Enter your phone" required/><br/>

                        <label for="email">Email</label><br/>
                        <input type="email" id="email" name="email" placeholder="Enter your email" required/><br/>            

                        <label for="password">Password</label><br/>
                        <input type="password" id="password" name="password" placeholder="Enter your password" required/><br/> 

                        <label for="password2">Confirm Password</label><br/>
                        <input type="password" id="password2" name="password2" placeholder="Confirm your password" required/><br/>

                        <p>Sex</p><br/>
                        
                        <label for="male" class="sex">
                            <input id="male" type="radio" value="male" name="sex"/>
                            Male
                        </label><br/>
                        
                        <label for="female" class="sex">
                            <input id="female" type="radio" value="female" name="sex"/>
                            Female
                        </label><br/>
                                          
                        <button type="submit" value="Submit" id="submit">Submit</button>
                    </form>
                </div>
            </div>
        </>
    );
};

export default Register;