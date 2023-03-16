import React from 'react';
import './Login.css';

const Login = () => {
    const Login = (userName, pass) =>{
        /* code gi do de noi toi api trong cai function nay */
        // tao nghĩ thêm chức năng nấu như account tồn tại trong db thì mình lưu account đó vào local storage 
    }
    const submit = () => {
        const textBox = document.getElementById('User-name');
        const userName = textBox.value;

        const password = document.getElementById('password');
        const pass = password.value;
        Login(userName, pass);
    }
    return (
        <div className='body-login'>
            <div className='container-login'>
                <h1 className='title-login'>Login</h1>
                <input type="text" placeholder='Email or phone number' className='User-name-login' id='User-name-login'></input>
                <input type='password' placeholder='Password' className='password-login' id='password-login'></input>
                <button type='submit' onClick={submit} className='submit-button-login'>Log in</button>
            </div>
        </div>
    );
};

export default Login;