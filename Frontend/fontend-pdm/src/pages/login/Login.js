import React from 'react';
import './Login.css';

const Login = () => {
    return (
        <div className='container'>
            <h1>Login</h1>
            <input type="text" placeholder='User name' className='User-name'></input>
            <input type='password' placeholder='password' className='password'></input>
        </div>
    );
};

export default Login;