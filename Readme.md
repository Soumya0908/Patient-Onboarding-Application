# Patient-Onboarding-Application

## Project Description:

Patient On-boarding is a microservice application where the patients get registered and then login to get booked their appointments with the doctors, based on the availability of the doctor to get treated. As a doctor after logging into the account i can provide my availability schedule and view the details of patient-appointments.
And admin can register the doctor where the login credentials will be sent to the doctor's registered mailId, can view all the doctor's details, doctor's-availability details, registered patient's details and also patient's booking details.  

## Technologies Used

Java-1.8

Hibernate-5.0.1

Spring

PostgreSQL-42.2.3

Angular

Bootstrap
  
## Features

### Admin Module
- As a admin i can register the doctor and where the login credentials of a doctor are sent to registered mailid.
- Can view the list of doctors and doctors-availabilities.
- And also can view the list of patients and patient-appointments.

### Patient Module
- As a patient i can get registered for booking doctor appointment.
- After getting logged in with the credentials, patient can view the availability of the doctors by choosing a specific domain.
- And book appointments to get consulted with the doctor.

### Doctor Module
- Doctor can login by using the credentials sent to the email by admin.
- After loggin doctor can update the availability,so that patients can book appointments based on the availability.
- Can view the list of patients booked.
- And also can view personal profile of theirs if any changes required they can change except id and salary. 
  
## Technical Aspect

- Worked on Spring Tool Suite 4 for development.
- Used postgreSQL for the data accessing.
- Created a model class using hibernate annotations and lombok to reduce the boilerplate code.
- Utilized design-patterns such as MVC(Model-View-Controller)
- Used Spring Mail to send the mail.
- Tested all the functions using JUnit4.
- Designed attractive and responsive webpages using Angularjs and Bootstrap.

## Usage of the Patient-OnboardingApplication

 - To work on this project firstly download this project by clicking on downloadzip.
 - After downloading the spring-project extract the project and import it in EclipseIDE.
 - Then click on existing maven project, choose the spring-project from the folder then next and finish.
 - Make sure that you have a PostgreSQL database or if you want to work with any other data-base then change the dependency in pom.xml and also change the properties in the application.properties file  resources.
 - If you want to know the dependencies added to the project open pom.xml file. 
 - And run the spring application by rightclicking on project then select --> run-as-->Spring-Boot-App.
 - And also download the angular project.
 - Then extract the project, after extracting it, open VisualStudioCode select the folder of the project and open terminal run npm install and to start server run npm start.  
 - To open it on web browser and perform the actions use  http://localhost:4200.

  
## Contributing

- This is a group project, our team-size is of 6-members.
- Each member of our team has been worked on 2-3 story-points.

### My role
- I have worked on both backend and front-end.
- I have implemented Doctor-registration, login, view the patient appointments of the doctor and also view my-profile of the doctor and update the details if any changes has to be done except salary and doctorId.
- Tested each and every method using postman before implementing in the angular.  
