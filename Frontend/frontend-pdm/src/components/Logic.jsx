import React from 'react';
import LoginUser from './LoginUser.jsx';
import LogoutUser from './LogoutUser.jsx';

const Logic = () => {
    // localStorage.setItem('status', 'false');
    const status = localStorage.getItem('status');
    console.log(status);
    return (
        <>
            {status==='true' ? <LoginUser /> : <LogoutUser />}
        </>
    )
};

export default Logic;