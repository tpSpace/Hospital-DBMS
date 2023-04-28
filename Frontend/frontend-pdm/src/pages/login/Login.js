import React from 'react';
import './Login.css';
import { useState} from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const LoginDoctor = () => {

    let navigate = useNavigate();

    const [user,setUser] = useState({
        email: "",
        password: "",
    });

    const onInputChange = (e) => {
        setUser({...user, [e.target.id]: e.target.value});
    }

    const handleSubmit = async (e) =>{
        e.preventDefault();
        // eslint-disable-next-line
        const {email, password} = user;

        await axios.post("http://localhost:8090/login",user)
        .then(response => {
            console.log(response);
            if(response.status === 200){
                localStorage.setItem('email', email);
                localStorage.setItem('role', response.data.role);
                localStorage.setItem('id', response.data.id);
                localStorage.setItem('status', 'true');
                console.log('login successful');
                console.log(response.data.id)
                navigate('/viewinfo');
                window.location.reload();
            }
        })
        .catch(err => {
            console.log(err);
            if(err.response.status === 400){
                alert('Invalid username or password');
            }
            console.log('login failed');
        });
    }

    return (
        <section className='body-login'>
            <form className='container-login' onSubmit={handleSubmit}>
                <h1 className='title-login'>Sign In</h1>
                <br></br>
                <label htmlFor='username-login'>Username</label>
                <input
                    type='text'
                    id='email'
                    placeholder='Enter your username'
                    autoComplete='off'
                    onChange={(e) => onInputChange(e)}
                    required
                />

                <label htmlFor='password-login'>Password</label>
                <input
                    type='password'
                    id='password'
                    placeholder='Enter your password'
                    onChange={(e) => onInputChange(e)}
                    required
                />

                <button type='submit' value='submit' className='submit-button-login'>Sign in</button>
            </form>
        </section>
    )}

export default LoginDoctor;
