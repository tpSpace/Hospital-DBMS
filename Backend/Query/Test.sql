CREATE DATABASE Hospital;
USE Hospital;
CREATE TABLE Patient (
    patientId SERIAL NOT NULL,
    patientFirstName VARCHAR(50) NOT NULL,
    patientLastName VARCHAR(50) NOT NULL,
    patientMiddleName VARCHAR(50),
    patientDob  DATE NOT NULL,
    patientGender VARCHAR(10) NOT NULL,
    patientMedicalRecord VARCHAR(200) NOT NULL,
    patientAddress VARCHAR(100),
    patientPhone VARCHAR(15),
    patientEmail VARCHAR(50) NOT NULL,
    patientPassword VARCHAR(50) NOT NULL,
    PRIMARY KEY (patientId)
);
CREATE TABLE Doctor (
    doctorId SERIAL NOT NULL,
    doctorName VARCHAR(50) NOT NULL,
    doctorDob  DATE NOT NULL,
    -- doctorSpeciality VARCHAR(50) NOT NULL,
    doctorDepartmentId INT NOT NULL REFERENCES Department(departmentId),
    doctorPhone VARCHAR(15),
    doctorEmail VARCHAR(50) NOT NULL,
    doctorPassword VARCHAR(50) NOT NULL,
    PRIMARY KEY (doctorId)
);
CREATE TABLE Department (
    departmentId SERIAL NOT NULL,
    departmentName VARCHAR(50) NOT NULL,
    PRIMARY KEY (departmentId)
);
CREATE TABLE Staff (
    staffId SERIAL NOT NULL,
    staffName VARCHAR(50) NOT NULL,
    staffDob  DATE NOT NULL,
    staffDepartmentId INT NOT NULL REFERENCES Department(departmentId),
    staffPhone VARCHAR(15),
    staffEmail VARCHAR(50) NOT NULL,
    staffPassword VARCHAR(50) NOT NULL,
    PRIMARY KEY (staffId)
);
CREATE TABLE Nurse (
    nurseId SERIAL NOT NULL,
    nurseName VARCHAR(50) NOT NULL,
    nurseDob  DATE NOT NULL,
    nurseDepartmentId INT NOT NULL REFERENCES Department(departmentId),
    nursePhone VARCHAR(15),
    nurseEmail VARCHAR(50) NOT NULL,
    nursePassword VARCHAR(50) NOT NULL,
    PRIMARY KEY (nurseId)
);
CREATE TABLE Room (
    roomId SERIAL NOT NULL,
    roomType VARCHAR(50) NOT NULL,
    roomStatus VARCHAR(50) NOT NULL,
    roomDepartmentId INT NOT NULL REFERENCES Department(departmentId),
    PRIMARY KEY (roomId)
);
CREATE TABLE Appointment (
    appointmentId SERIAL NOT NULL,
    appointmentDate DATE NOT NULL,
    appointmentTime TIME NOT NULL,
    appointmentPatientId INT NOT NULL REFERENCES Patient(patientId),
    appointmentDoctorId INT NOT NULL REFERENCES Doctor(doctorId),
    appointmentRoomId INT NOT NULL REFERENCES Room(roomId),
    PRIMARY KEY (appointmentId)
);
CREATE TABLE Prescription (
    prescriptionId SERIAL NOT NULL,
    prescriptionDate DATE NOT NULL,
    prescriptionTime TIME NOT NULL,
    prescriptionDoctorId INT NOT NULL REFERENCES Doctor(doctorId),
    prescriptionPatientId INT NOT NULL REFERENCES Patient(patientId),
    prescriptionMedicine VARCHAR(3000) NOT NULL,
    prescriptionDuration VARCHAR(50) NOT NULL,
    PRIMARY KEY (prescriptionId)
);

