import React from 'react';
import DoctorInfo from './DoctorInfo';
import PatientInfo from './PatientInfo';
import NurseInfo from './NurseInfo';
import StaffInfo from './StaffInfo';
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

  

    // const loadStaff = async (id) => {
    //     const result = await axios.get(`http://localhost:8090/staff/${id}`).catch((err) => {console.log(err)});
    //     setStaff(result.data);
    // }

    // const display = () => {
    //     if(role.includes('Doctor')) {
    //         loadDoctor(getDoctorId(localStorage.getItem('email')));
    //         
    //     } else if (role.includes('Patient')) {
    //         loadPatient(getPatientId(localStorage.getItem('email')));
    //         
    //     } else if(role.includes('Nurse')) {
    //         loadNurse(getNurseId(localStorage.getItem('email')));
    //         
    //     } else if (role.includes('Staff')) {
    //         loadStaff(getStaffId(localStorage.getItem('email')));
    //         
    //     } else {
    //         return (
    //             <h2>View hey</h2>
    //         )
    //     }
    // }
}

export default ViewInfo;