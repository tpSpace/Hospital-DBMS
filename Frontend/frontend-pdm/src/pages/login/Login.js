import React from 'react';
import './Login.css';
import { useState, useRef, useEffect } from 'react';

const Login = () => {
    const userRef = useRef();
    const errRef = useRef();

    const [user, setUser] = useState('');
    const [pwd, setPwd] = useState('');
    const [errMsg, setErrMsg] = useState('');
    const [success, setSuccess] = useState(false);

    useEffect(() => {
        userRef.current.focus();
    }, []);

    useEffect(() => {
        setErrMsg('');
    },[user, pwd]);

    const handleSubmit = async (e) =>{
        e.preventDefault();
    }
    return (
        <>
            {success ? (
                <section className='body-login'>
                    <h1 className='title-login'>You are logged in!</h1>
                </section>
            ) : (
                <section className='body-login'>
                    <p ref={errRef} className={errMsg ? 'errmsg' : 'offscreen'} aria-live='assertive'>{errMsg}</p>
                    <form className='container-login' onSubmit={handleSubmit}>
                        <h1 className='title-login'>Sign In</h1>
                        <br></br>
                        <label htmlFor='username-login'>Username:</label>
                        <input
                            type='text'
                            id='username-login'
                            ref={userRef}
                            autoComplete='off'
                            onChange={(e) => setUser(e.target.value)}
                            value={user}
                            required
                        />

                        <label htmlFor='password-login'>Password:</label>
                        <input
                            type='password'
                            id='password-login'
                            onChange={(e) => setPwd(e.target.value)}
                            value={pwd}
                            required
                        />

                        <button className='submit-button-login'>Sign in</button>
                    </form>
                </section>
            )}
        </>
    );
};

export default Login;