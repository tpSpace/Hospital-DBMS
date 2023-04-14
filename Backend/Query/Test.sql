CREATE TABLE Department (
    departmentId SERIAL NOT NULL,
    departmentName VARCHAR(100) NOT NULL,

    PRIMARY KEY (departmentId)
);
CREATE TABLE Patient (
    patientId SERIAL NOT NULL,
    patientName VARCHAR(100) NOT NULL,
    patientDob DATE NOT NULL,
    patientGender VARCHAR(10) NOT NULL,
    patientMedicalRecord VARCHAR(400) NOT NULL,
    patientPhone VARCHAR(15) NOT NULL,

    PRIMARY KEY (patientId)
);

CREATE TABLE Doctor (
    doctorId SERIAL NOT NULL,
    doctorName VARCHAR(50) NOT NULL,
    doctorDob DATE NOT NULL,
    doctorDepartmentId int NOT NULL REFERENCES Department(departmentId),
    doctorPhone smallint,
    PRIMARY KEY (doctorId)
);


CREATE TABLE Staff (
    staffId SERIAL NOT NULL,
    staffName VARCHAR(50) NOT NULL,
    staffDob  DATE NOT NULL,
    staffDepartmentId int NOT NULL REFERENCES Department(departmentId),
    staffPhone VARCHAR(15),

    PRIMARY KEY (staffId)
);
CREATE TABLE Nurse (
    nurseId SERIAL NOT NULL,
    nurseName VARCHAR(50) NOT NULL,
    nurseDob  DATE NOT NULL,
    nurseDepartmentId INT NOT NULL REFERENCES Department(departmentId),
    nursePhone VARCHAR(15),

    PRIMARY KEY (nurseId)
);

CREATE TABLE Room (
    roomId SERIAL NOT NULL,
    roomName VARCHAR(50) NOT NULL,
    PatientId int REFERENCES Patient(patientId),

    PRIMARY KEY (roomId)
);
CREATE TABLE Appointment (
    appointmentDate DATE NOT NULL,
    appointmentTime TIME NOT NULL,
    PatientID INT NOT NULL REFERENCES Patient(patientId),
    DoctorID INT NOT NULL REFERENCES Doctor(doctorId),

    PRIMARY KEY (PatientID,DoctorID)
);

CREATE TABLE TakeCare(
    PatientID INT NOT NULL REFERENCES Patient(patientId),
    NurseID INT NOT NULL REFERENCES Nurse(NurseID),
    Date DATE NOT NULL,

    PRIMARY KEY (PatientID,NurseID)
);

CREATE TABLE InCharge(
    Date DATE NOT NULL,
    Shift VARCHAR(50),
    RoomID INT NOT NULL REFERENCES Room(roomId),
    NurseID INT NOT NUll REFERENCES Nurse(nurseId), 
    PRIMARY KEY (RoomID,NurseID) 
);