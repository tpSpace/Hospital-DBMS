[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]


A project for principle of database management at HCMIU.
- This is a simple web allows patients to view their personal profolio and make an appoiment with doctors. 
- Beisde patients we also have pages for doctors, staffs and nurses. 
# Team members

| Order |         Name          |                      Task                      | Contribution |
|:-----:|:---------------------:|:------------------------------------------------------------------------:|:------------:|
|   1   | Nguyen Manh Viet Khoi | Fullstack, UI Designer, Project scheduling, Login Authorization, git     |      30      |
|   2   |     Hồ Gia Khang      | Fullstack, UI Designer, Login Authentication                             |      30      |
|   3   |    Phạm Gia Khang     | Backend, Data Standardization, Debugger,Database designer, Write reports |      20      |
|   4   |   Nguyễn Tiến Hưng    | Backend                                                                  |      20      |
|   5   |     Ngô Đức Huy       | N/A                                                                      |      0       |

# Tech Stack
- **Back-end**: Spring Boot, Spring Data JPA, RESTful API 
- **Front-end**: Reactjs, Bootstrap
- **Database Management System**: PostgreSQL

# Features
### Basic feature
* **Sign in**: User can sign in with their username and password if they have an existing account.
* **Register**: User registers for a new username and password, add basic information like phone number, address.
* **Edit user information**: User can edit their username and other information on their profile.
### Patients 
* **Make an appointment**: Patients cant make and appointment with doctos.
### Doctors
* **View appoinment**: Doctors can view appointments in the future.
### Staffs 
* **View rooms**: Staffs can view status of rooms.
* **Add rooms**: Staffs can add new rooms.
### Nurses
* **View rooms**: Nurces can view which rooms to serve.

# Diagrams
### ER Diagram
<figure>
<img width="769" alt="erd" src="https://user-images.githubusercontent.com/96167875/235837513-e0f8229f-8589-40b2-8eef-4397d192f611.png"/>
<figcaption><i>Figure 1: ERD diagram for the Department, Doctor, Nurse, Staff, Room, Patient relationship.</i></figcaption>
</figure>

### Relational model
<figure>
<img widht="769" alt="Relational model" src="https://user-images.githubusercontent.com/96167875/235837755-07132b26-2b15-45df-af90-bc169f40d756.png"/>
<figcaption><i>Figure 2: Relational model of the Department, Doctor, Nurse, Staff, Room, Patient relationship.</i></figcaption>
</figure>
</figure>

# How to run the project

**1. Clone the project**
```bash
git clone https://github.com/tpSpace/Hospital-DBMS
```

**2. Setup your PostgresSQL database**
+ Download PostgresSQL `https://www.postgresql.org/download/`
+ Create `/backend/src/main/resources/.env` file for username and password to connect to DB.
+ Login to psql and create the databse before we run the backend. 
```sql 
CREATE DATABASE hospital;
```
**3. Run backend**
+ Install openJDK 17
+ Recommend to use Intelij to run the project.

**4. Run frontend**
+ Install nodejs 16
+ Install `npm` and run `npm i` to install necessary dependencies.
+ Type `npm` to run the project.


[contributors-shield]: https://img.shields.io/github/contributors/tnphucccc/Bomberman.svg?style=for-the-badge
[contributors-url]: https://github.com/tnphucccc/Bomberman-Adventure/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/tnphucccc/Bomberman.svg?style=for-the-badge
[forks-url]: https://github.com/tnphucccc/Bomberman-Adventure/network/members
[stars-shield]: https://img.shields.io/github/stars/tnphucccc/Bomberman.svg?style=for-the-badge
[stars-url]: https://github.com/tnphucccc/Bomberman-Adventure/stargazers
[issues-shield]: https://img.shields.io/github/issues/tnphucccc/Bomberman.svg?style=for-the-badge
[issues-url]: https://github.com/tnphucccc/Bomberman-Adventure/issues
