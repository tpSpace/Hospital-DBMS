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

    patientEmail VARCHAR(100) NOT NULL,
    patientPassword VARCHAR(100) NOT NULL,
    PRIMARY KEY (patientId)
);

CREATE TABLE Doctor (
    doctorId SERIAL NOT NULL,
    doctorName VARCHAR(50) NOT NULL,
    doctorDob DATE NOT NULL,
    doctorDepartmentId int NOT NULL REFERENCES Department(departmentId),
    doctorPhone smallint,

    doctorEmail VARCHAR(100) NOT NULL,
    doctorPassword VARCHAR(100) NOT NULL,
    PRIMARY KEY (doctorId)
);


CREATE TABLE Staff (
    staffId SERIAL NOT NULL,
    staffName VARCHAR(50) NOT NULL,
    staffDob  DATE NOT NULL,
    staffDepartmentId int NOT NULL REFERENCES Department(departmentId),
    staffPhone VARCHAR(15),

    staffEmail VARCHAR(100) NOT NULL,
    staffPassword VARCHAR(100) NOT NULL,
    PRIMARY KEY (staffId)
);
CREATE TABLE Nurse (
    nurseId SERIAL NOT NULL,
    nurseName VARCHAR(50) NOT NULL,
    nurseDob  DATE NOT NULL,
    nurseDepartmentId INT NOT NULL REFERENCES Department(departmentId),
    nursePhone VARCHAR(15),

    nurseEmail VARCHAR(100) NOT NULL,
    nursePassword VARCHAR(100) NOT NULL,
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
-- 1st Example
INSERT INTO Patient (patientFirstName, patientLastName, patientMiddleName, patientDob, patientGender, patientMedicalRecord, patientAddress, patientPhone, patientEmail, patientPassword) VALUES
('Sarah', 'Lee', 'Kim', '1993-06-20', 'Female', 'N/A', '789 Oak St', '555-6789', 'sarahlee@example.com', 'password123'),
('David', 'Lee', 'Choi', '1989-03-15', 'Male', 'N/A', '246 Maple Ave', '555-5678', 'david.lee@example.com', 'password456');

INSERT INTO Department (departmentName) VALUES
('Orthopedics'),
('Neurology'),
('Oncology');

INSERT INTO Doctor (doctorName, doctorDob, doctorDepartmentId, doctorPhone, doctorEmail, doctorPassword) VALUES
('Dr. Elizabeth Kim', '1985-08-08', 1, '555-4321', 'elizabeth.kim@example.com', 'password789'),
('Dr. David Lee', '1978-02-28', 2, '555-2468', 'david.lee@example.com', 'password012');

INSERT INTO Staff (staffName, staffDob, staffDepartmentId, staffPhone, staffEmail, staffPassword) VALUES
('James Kim', '1991-12-10', 3, '555-6789', 'james.kim@example.com', 'password345'),
('Karen Lee', '1987-06-05', 1, '555-1234', 'karen.lee@example.com', 'password678');

INSERT INTO Nurse (nurseName, nurseDob, nurseDepartmentId, nursePhone, nurseEmail, nursePassword) VALUES
('John Smith', '1997-01-01', 2, '555-1357', 'john.smith@example.com', 'password901'),
('Emily Davis', '1994-08-25', 3, '555-9876', 'emily.davis@example.com', 'password234');

INSERT INTO Room (roomType, roomStatus, roomDepartmentId) VALUES
('Private', 'Occupied', 1),
('Semi-Private', 'Available', 2),
('General', 'Available', 3);

INSERT INTO Appointment (appointmentDate, appointmentTime, appointmentPatientId, appointmentDoctorId, appointmentRoomId) VALUES
('2023-04-19', '10:00:00', 1, 1, 1),
('2023-04-20', '12:00:00', 2, 2, 2);

INSERT INTO Prescription (prescriptionDate, prescriptionTime, prescriptionDoctorId, prescriptionPatientId, prescriptionMedicine, prescriptionDuration) VALUES
('2023-04-19', '11:00:00', 1, 1, 'Ibuprofen', '2 days'),
('2023-04-20', '13:00:00', 2, 2, 'Acetaminophen', '4 days');