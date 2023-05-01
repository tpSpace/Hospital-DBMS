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
    // let navigate = useNavigate();
    // const { id } = useParams();
    // let role = localStorage.getItem('role');

    // const [doctor, setDoctor] = useState({
    //     doctorId: "1",
    //     doctorName: "",
    //     doctorPhoneNum: "",
    //     doctorDob: "",
    //     doctorEmail: "",
    //     doctorPassword: "",
    //     doctorDepartmentId: "1",
    // });
    // const [patient, setPatient] = useState({
    //     patientFirstName: "",
    //     patientLastName: "",
    //     patientDob: "",
    //     patientGender : "",
    //     patientMedicalRecord: "N/A",
    //     patientPhone: "",
    //     patientEmail: "",
    //     patientPassword: "",
    // });
    // const [nurse, setNurse] = useState({
    //     nurseName: "",
    //     nurseDob: "",
    //     nursePhone: "",
    //     nurseEmail: "",
    //     nursePassword: ""
    // });
    // const [staff, setStaff] = useState({
    //     staffName: "",
    //     staffDob: "",
    //     staffPhone: "",
    //     staffEmail: "",
    //     staffPassword: ""
    // });

    // const {doctorId, doctorName, doctorPhoneNum, doctorDob, doctorEmail, doctorPassword,doctorDepartmentId } = doctor;
    // const { patientFirstName,patientLastName,patientDob,patientGender,patientMedicalRecord,patientPhone,patientEmail,patientPassword} = patient;
    // const { nurseName, nurseDob, nursePhone, nurseEmail, nursePassword } = nurse;
    // const { staffName, staffDob, staffPhone, staffEmail, staffPassword } = staff;

    // const onInputChange = (e) => {
    //     if(role.includes('Doctor')){
    //         setDoctor({ ...doctor, [e.target.name]: e.target.value});
    //     } else if(role.includes('Patient')) {
    //         setPatient({ ...patient, [e.target.name]: e.target.value});
    //     } else if(role.includes('Nurse')) {
    //         setNurse({ ...nurse, [e.target.name]: e.target.value});
    //     } else if(role.includes('Staff')){
    //         setStaff({ ...staff, [e.target.name]: e.target.value});
    //     }
    // }

    // useEffect(() => {
    //     loadUser();
    // }, []);

    // const onSubmit = async (e) => {
    //     e.preventDefault();
    //     console.log(id);
    //     if(role.includes('Doctor')){
    //         setDoctor({ ...doctor, doctorId: String(id) });
    //         setDoctor({ ...doctor, departmentId: String(id) });

    //         await axios.put(`http://localhost:8090/doctor/${id}`, doctor);
    //     } else if(role.includes('Patient')) {
    //         await axios.put(`http://localhost:8090/patients/${id}`, patient);
    //     } else if(role.includes('Nurse')) {
    //         await axios.put(`http://localhost:8090/nurse/${id}`, nurse);
    //     } else if(role.includes('Staff')){
    //         await axios.put(`http://localhost:8090/staff/${id}`, staff);
    //     }
    //     navigate("/viewinfo");
    // }

    // const loadUser = async () =>{
    //     if(role.includes('Doctor')){
    //         const result = await axios.get(`http://localhost:8090/doctor/${id}`).catch(err => console.log(err));
    //         setDoctor(result.data);
    //     } else if(role.includes('Patient')) {
    //         const result = await axios.get(`http://localhost:8090/patients/${id}`).catch(err => console.log(err));
    //         setPatient(result.data);
    //     } else if(role.includes('Nurse')) {
    //         const result = await axios.get(`http://localhost:8090/nurse/${id}`).catch(err => console.log(err));
    //         setNurse(result.data);
    //     } else if(role.includes('Staff')){
    //         const result = await axios.get(`http://localhost:8090/staff/${id}`).catch(err => console.log(err));
    //         setStaff(result.data);
    //     }
    // }

    // 
    //    
    //     } else if(role.includes('Nurse')) {
    //         return (
    //             <div className="Container">
            
    //                 <div className="register">
    //                     <h1>Edit information</h1>
    //                     <form id="register-form" onSubmit={e => onSubmit(e)}> 
                        
    //                         <label htmlFor="nurseName">Nurse name</label><br/>
    //                         <input 
    //                             type={"text"}
    //                             id="nurseName" 
    //                             name="nurseName" 
    //                             placeholder="Enter your name" 
    //                             value={nurseName}
    //                             onChange={(e) => onInputChange(e)}
    //                             required
    //                         /><br/>

    //                         <label htmlFor="nurseDob">Date of birth</label><br/>
    //                         <input 
    //                             type="date" 
    //                             id="nurseDob" 
    //                             name="nurseDob" 
    //                             placeholder="Enter your date of birth" 
    //                             value={nurseDob}
    //                             onChange={(e) => onInputChange(e)}
    //                             required
    //                         /><br/>

    //                         <label htmlFor="nursePhone">Phone Number</label><br/>
    //                         <input 
    //                             type="tel" 
    //                             id="nursePhone" 
    //                             name="nursePhone" 
    //                             placeholder="Enter your phone number" 
    //                             value={nursePhone}
    //                             onChange={(e) => onInputChange(e)}
    //                             required
    //                         /><br/>

    //                         <label htmlFor="nurseEmail">Email</label><br/>
    //                         <input 
    //                             type="email" 
    //                             id="nurseEmail"
    //                             name="nurseEmail"
    //                             placeholder="Enter your email" 
    //                             value={nurseEmail}
    //                             onChange={(e) => onInputChange(e)}
    //                             required
    //                         /><br/>            

    //                         <label htmlFor="nursePassword">Password</label><br/>
    //                         <input 
    //                             type="password" 
    //                             id="nursePassword" 
    //                             name="nursePassword" 
    //                             placeholder="Enter your password" 
    //                             value={nursePassword}
    //                             onChange={(e) => onInputChange(e)}
    //                             required
    //                         /><br/> 
                                                                
    //                         <button type="submit" value="Submit" id="submit">Submit</button>
    //                         <Link className="btn btn-outline-danger mx-2" to="/">
    //                             Cancel
    //                         </Link>
    //                     </form>
    //                 </div>
    //             </div>
    //         )
    //     } else if(role.includes('Staff')){
    //         return (
    //             <div className="Container">
            
    //                 <div className="register">
    //                     <h1>Edit information</h1>
    //                     <form id="register-form" onSubmit={e => onSubmit(e)}> 
                        
    //                         <label htmlFor="staffName">Staff name</label><br/>
    //                         <input 
    //                             type={"text"}
    //                             id="staffName"
    //                             name="staffName"
    //                             placeholder="Enter your name" 
    //                             value={staffName}
    //                             onChange={(e) => onInputChange(e)}
    //                             required
    //                         /><br/>

    //                         <label htmlFor="staffDob">Date of birth</label><br/>
    //                         <input 
    //                             type="date" 
    //                             id="staffDob"
    //                             name="staffDob"
    //                             placeholder="Enter your date of birth" 
    //                             value={staffDob}
    //                             onChange={(e) => onInputChange(e)}
    //                             required
    //                         /><br/>

    //                         <label htmlFor="staffPhone">Phone Number</label><br/>
    //                         <input 
    //                             type="tel" 
    //                             id="staffPhone" 
    //                             name="staffPhone" 
    //                             placeholder="Enter your phone number" 
    //                             value={staffPhone}
    //                             onChange={(e) => onInputChange(e)}
    //                             required
    //                         /><br/>

    //                         <label htmlFor="staffEmail">Email</label><br/>
    //                         <input 
    //                             type="email" 
    //                             id="staffEmail"
    //                             name="staffEmail"
    //                             placeholder="Enter your email" 
    //                             value={staffEmail}
    //                             onChange={(e) => onInputChange(e)}
    //                             required
    //                         /><br/>            

    //                         <label htmlFor="staffPassword">Password</label><br/>
    //                         <input 
    //                             type="password" 
    //                             id="staffPassword" 
    //                             name="staffPassword"
    //                             placeholder="Enter your password" 
    //                             value={staffPassword}
    //                             onChange={(e) => onInputChange(e)}
    //                             required
    //                         /><br/> 
                                                                
    //                         <button type="submit" value="Submit" id="submit">Submit</button>
    //                         <Link className="btn btn-outline-danger mx-2" to="/">
    //                             Cancel
    //                         </Link>
    //                     </form>
    //                 </div>
    //             </div>
    //         )
    //     }
    // }

    // return (
    //     <div>
    //         {editForm()}
    //     </div>
    // )
}

export default EditInfo