import React from 'react';
import DoctorInfo from './DoctorInfo';
import PatientInfo from './PatientInfo';
import NurseInfo from './NurseInfo';
import StaffInfo from './StaffInfo';
import './ViewInfo.css';

const ViewInfo = () => {
    const role = localStorage.getItem('role');

    return (
        <>
            {role.includes('Doctor') && <DoctorInfo/>}
            {role.includes('Patient') && <PatientInfo/>}
            {role.includes('Nurse') && <NurseInfo/>}
            {role.includes('Staff') && <StaffInfo/>}
        </>
    )

}

export default ViewInfo;