import React from 'react';
import './Login.css';
import { useState, useRef, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const LoginDoctor = () => {
    let navigate = useNavigate();
    const userRef = useRef();
    const errRef = useRef();

    const [email, setEmail] = useState('');
    const [pwd, setPwd] = useState('');
    const [errMsg, setErrMsg] = useState('');
    const [role, setRole] = useState('');

    const [user,setUser] = useState({
        email: "",
        password: "",
    });

    // if(localStorage.getItem('myRole')){
    //     localStorage.removeItem('myRole');
    // }

    useEffect(() => {
        localStorage.setItem('myRole', role);
        console.log(localStorage.getItem('myRole'));
    }, [role]);

    useEffect(() => {
        userRef.current.focus();
    }, []);

    useEffect(() => {
        setErrMsg('');
    },[email, pwd]);;

    const handleSubmit = async (e) =>{
        e.preventDefault();
        setUser({
            email: email,
            password: pwd,
        });

        await axios.post("http://localhost:8090/login",user)
        .then(response => {
            console.log(response);
            if(response.status === 200){
                setEmail('');
                setPwd('');
                setRole(JSON.stringify(response.data));
                localStorage.setItem('myRole', role);
                localStorage.setItem('status', 'true');
                console.log('login successful');
                navigate('/');
            }
        })
        .catch(err => {
            console.log(err);
            if(err.response.status === 400){
                setErrMsg('Wrong email or password');
            }
            console.log('login failed');
        });
    }

    return (
        <section className='body-login'>
            <p ref={errRef} className={errMsg ? 'errmsg' : 'offscreen'} aria-live='assertive'>{errMsg}</p>
            <form className='container-login' onSubmit={handleSubmit}>
                <h1 className='title-login'>Sign In</h1>
                <br></br>
                <label htmlFor='username-login'>Username</label>
                <input
                    type='text'
                    id='username-login'
                    placeholder='Enter your username'
                    ref={userRef}
                    autoComplete='off'
                    onChange={(e) => setEmail(e.target.value)}
                    value={email}
                    required
                />

                <label htmlFor='password-login'>Password</label>
                <input
                    type='password'
                    id='password-login'
                    placeholder='Enter your password'
                    onChange={(e) => setPwd(e.target.value)}
                    value={pwd}
                    required
                />

                <button type='submit' value='submit' className='submit-button-login'>Sign in</button>
            </form>
        </section>
    )}

export default LoginDoctor;
