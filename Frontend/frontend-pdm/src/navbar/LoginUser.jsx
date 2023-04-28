import React from 'react';
import LoginDoctor from './LoginDoctor.js';
import LoginPatient from './LoginPatient.js';
import LoginStaff from './LoginStaff.js';
import LoginNurse from './LoginNurse.js';

const LoginUser = () => {

    const role = localStorage.getItem('role');

    return (
      <>
          {role.includes('Doctor') && <LoginDoctor/>}
          {role.includes('Patient') && <LoginPatient/>}
          {role.includes('Staff') && <LoginStaff/>}
          {role.includes('Nurse') && <LoginNurse/>}
      </>
        
    )
}

export default LoginUser;