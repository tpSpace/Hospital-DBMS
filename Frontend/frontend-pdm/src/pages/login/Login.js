import React from 'react';
import './Login.css';

const Login = () => {
    const Login = (userName, pass) =>{
        /* code gi do de noi toi api trong cai function nay */
    }
    const submit = () => {
        const textBox = document.getElementById('User-name');
        const userName = textBox.value;

        const password = document.getElementById('password');
        const pass = password.value;
        Login(userName, pass);
    }
    return (
        <div className='body'>
            <div className='container'>
                <h1 className='title'>Login</h1>
                <input type="text" placeholder='Email or phone number' className='User-name' id='User-name'></input>
                <input type='password' placeholder='Password' className='password' id='password'></input>
                <button type='submit' onClick={submit} className='submit-button'>Log in</button>
            </div>
        </div>
    );
};

export default Login;