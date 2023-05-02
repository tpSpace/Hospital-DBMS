import React from 'react'
import EditDoctor from './EditDoctor';
import EditPatient from './EditPatient';
import EditStaff from './EditStaff';
import EditNurse from './EditNurse';
const EditInfo = () => {
    let role = localStorage.getItem('role');

    return (
        <>
            {role.includes('Doctor') && <EditDoctor />}
            {role.includes('Patient') && <EditPatient />}
            {role.includes('Nurse') && <EditNurse />}
            {role.includes('Staff') && <EditStaff />}
        </>
    )
}

export default EditInfo