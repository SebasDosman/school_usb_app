# School Employee Management Application
This repository contains a Java Swing application that provides a user-friendly interface for managing employee information in schools. The application includes features for managing personal information, salaries, and other options. It applies SOLID principles to ensure a clean and maintainable codebase.

## Features
- Login: This is the first interface of the system, from here we can enter the program if we already have a registered user. If we do not have it we must enter the registration option. 
- User registration: If we do not have a user we must register, the required data are: First name, last name, email, user and password. Once these data are entered it will be notified instantly that the user has been successfully created. Once created we can enter the program.
- System functionalities: Once the user was registered and logged in he/she will exit the interface with the multiple functionalities of the system.
- Register students: In this functionality we can perform the registration of a student, requiring the following data: ID number, name, age, gender, school grade and uniform. 
- Register employees: In this functionality we can perform the registration of an employee, requiring the following data: ID number, role, name, age, sex and salary. 
- Registration of subjects: In this functionality we can perform the registration of a subject, requiring the following data: subject ID number, name, teacher ID number, grade and schedule. 
- Register events corresponding to subjects: In this functionality we can register events to be performed in different subjects the to data required are: Event identification number and subject identification number.
- Registration of activities: This functionality corresponds to the registration of academic activities of a specific subject, the required data are: Identification number of the activity, the specific activity, date and id of the subject.
- Event registration: This event registration refers to events of a cultural nature, the required data are: Identification number of the event, location of the event, reason for the event and its duration.
- Registration of students in subjects: With this functionality we can register a student in a specific subject, the required data are: Subject ID number and student ID number. 
- Operators: They are the different orders that can be assigned to the system.
- Operator create: This is the message that is displayed when a student was successfully created.
- Display operator: The information of each student is displayed.

## SOLID Principles
The application is designed following the SOLID principles to ensure a clean and maintainable codebase.

## Getting Started
To get started with this project, clone the repository and install the necessary dependencies. Instructions for running the project are included in each directory.

## Contributing
Contributions are welcome! Please read the CONTRIBUTING.md for details on our code of conduct, and the process for submitting pull requests.

## License
This project is licensed under the MIT License - see the LICENSE.md file for details.
