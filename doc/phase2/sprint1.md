<h1 align="center">Sprint 1 Planning Meeting</h1>

## Meeting Minutes [Feb 5, 2017 | 3-5 PM]

### Participants
* **Shriram Anpalakan** (anpalaka)
* **Karan Bhagat** (bhagatka)
* **Hamza Ali** (alihamz2)
* **Brandon Villamor** (villamo3)
* **Mike Byun** (byundong)
* **Prashant Rawal** (rawalpr1)

### Agenda
* **<a href="#q1">Should we use Backendless or Firebase as our database backend?</a>**
* **<a href="#q2">Should we use Eclipse's WindowBuilder plugin for building the GUI?</a>**
* **<a href="#q3">How should we breakdown and assign the work for the sprint 1 deliverables?</a>**
* **<a href="#q4">What user stories are we working on for Sprint 1?</a>**
* **<a href="#q5">How are we going to breakdown those user stories into tasks and assign them?</a>**
* **<a href="#q6">What will our workflow be like using Git and Pivotal Tracker?</a>**
* **<a href="#q7">What, if any, coding conventions will we use?</a>**

### Main Decisions

<b id="q1">Should we use Backendless or Firebase as our database backend?</b>

At first we were planning to use Firebase. Upon further research, Firebase's Java API proved to be insufficient for our needs (lack of certain features and out-of-date and confusing documentation). Therefore, we chose to use Backendless which offers the same services we would need from Firebase but with a more up-to-date Java API and documentation.

[back to Agenda](#agenda)

<b id="q2">Should we use Eclipse's WindowBuilder plugin for building the GUI?</b>

Karan recommended we use the WindowBuilder plugin to facilitate and expedite building the GUI. After Karan demoed the plugin, the group unanimously agreed.

[back to Agenda](#agenda)

<b id="q3">How should we breakdown and assign the work for the sprint 1 deliverables?</b>

Brandon offered to draft and submit RPM.md, sprint1.md and PB.md. We also decided the entire team would discuss and draft SystemDesign.pdf together during our next meeting.

The team also decided to plan and practice the Sprint 1 Demo on Feb 15 from 1 to 3 PM which is our usual weekly meeting time. Due to scheduling conflicts, we've arranged to hold our demo on Feb 16 from 1 to 2 PM.

Lastly, we decided to hold our Sprint 1 Retrospective Meeting right after our demo on Feb 16 from 2 to 3 PM and.

[back to Agenda](#agenda)

<b id="q4">What user stories are we working on for Sprint 1?</b>

To simplify our Sprint 1 workload, we decided to only track attendance for a single course ("CSC301") with a single corresponding teacher account. Any student accounts confirm their attendance for that course by logging in.

Furthermore, the teacher account's view will consist of a dynamic attendance table and the ability to clear the table representing the creation of a new session to take attendance for. 

The user stories that fully correspond to this functionality include the **Login/Logout** and **Signup** user stories.

Since we don't have user stories that fully correspond to confirming attendance by logging in or a dynamic attendance table in the teacher view,
we decided to create spikes associated with the **Data Analytics** and **Confirming Attendance** user stories.

[back to Agenda](#agenda)

<b id="q5">How are we going to breakdown those user stories into tasks and assign them?</b>

We decided that each View class would have its own corresponding Controller class. Using this framework, we decided we would break down each user story into two sets of tasks, one for the View and one for the Controller (GUI vs. Backend).

We decided to create the views for Login, Signup, Main Teacher Screen and Main Student Screen.

[back to Agenda](#agenda)

<b id="q6">What will our workflow be like using Git?</b>

For Git, we decided to use a basic stability branching workflow. We'll create a develop branch off master and branch off develop for any features or bug fixes. We'll name each branch off develop feature/[Feature] or fix/[Bug Fix] depending on whether it's for a feature or a fix. Once work on a feature or fix branch is completed, we'll merge the branch into develop and run tests. Once we've deemed the application to be stable on the develop branch, we'll merge develop into master.

[back to Agenda](#agenda)

<b id="q7">What, if any, coding conventions will we use?</b>

We decided to use a **simple class naming convention** that involves appending View, Controller, or Model to the name of a class depending on the class' role in the MVC framework (e.g. LoginView, SignupController).

As for any common coding conventions, we decided each person should code in their own personal style (within reason) to facilitate coding progress.

[back to Agenda](#agenda)

### Future Decisions / Next Steps?
* **What design will we use for switching between views?**
	* Do we create a new view and dispose the old view on the fly? 
	* Do we follow the iOS methodology of collecting views in a stack
	* Something else?
* **We need to plan and practice our demo**

[back to top](#sprint-1-planning-meeting)

### Important Dates

**[Feb 9, 2017 | 12-8 PM]**
* In-person Meeting (Plan to finish most of Sprint 1's code)

**[Feb 13, 2017]**
* RPM.md, sprint1.md, PB.md and SystemDesign.pdf due

**[Feb 15, 2017 | 1-3 PM]**
* Demo Practice

**[Feb 16, 2017 | 1-2 PM]**
* Sprint 1 Demo (arranged with TA to accommodate schedule conflicts)

[back to top](#sprint-1-planning-meeting)

<h1 align="center">Sprint 1 Backlog</h1>

## Sprint Goals
<ol>
  <li id="1">Users can login (Note: We decided to leave Logout for Sprint 2. Therefore we're only completing half of the Login/Logout user story)</li>
  <li id="2">New users can sign up as a teacher or a student</li>
  <ol>
    <li id="2.1">Sign up involves entering their email which acts as their username and a password</li>
    <li id="2.2">It involves choosing one option between Student and Teacher which represents which type of account they want to sign up as</li>
	  <li id="2.3">User recieves confirmation email upon signup</li>
  </ol>
  <li id="3">Single teacher account managing a single course "CSC301"</li>
  <ol>
    <li id="3.1">If a student account logs in, it confirms their attendance</li>
    <li id="3.2">The teacher account can see the list of students that have confirmed their attendance in real time</li>
    <li id="3.3">The teacher account has the ability to clear the list which represents them tracking attendance for a new session</li>
  </ol>
</ol>

[back to top](#sprint-1-planning-meeting)

## Referenced User Stories

**<a href="#2">( see Sprint Goal (2) )</a>**

### Signup
As a user, I want to be able to create a new teacher or student account.

* After a user correctly completes and submits a sign up form on the signup screen, they are taken to the app's main screen already logged in as their new account.
* Priority: **(1)** / Point Estimate: **[3]**

----------
**<a href="#2.3">( see Sprint Goal (2.3) )</a>**

### Registration Confirmation
As a user, I want to be able to receive an email confirming my registration.

* A user receives a registration confirmation email.
* Priority: **(1)** / Point Estimate: **[1]**

----------
**<a href="#1">( see Sprint Goal (1) )</a>**

**Note:** As noted above in Sprint Goal (1), we've decided to only complete the Login functionality this sprint and leave the Logout functionality for next sprint. Therefore, we're only completing roughly half of the user story. The aspects of the CoS that will be completed this sprint are bolded.

### Login / Logout
As a user, I want to be able to login and logout of the app so that I can choose when to use the app and protect my personal information.

* **A user is taken to the app's main screen after successfully logging in (by correctly entering their username and password).**
* **A user is taken back to the login screen with cleared fields and an appropriate error message after an unsuccessful login.**
* A user can click a logout button when they're logged in and are taken back to the login screen.
* Priority: **(1)** / Point Estimate: **[1/2]** / Pivotal Tracker Estimate: **{1}** (since Pivotal Tracker doesn't allow fractional values)

[back to top](#sprint-1-planning-meeting)

----------

**This is a spike for confirming a student's attendance of a session upon logging into the application.**

**<a href="#3.1">( see Sprint Goal (3.1) )</a>**

### Student Confirms Attendance

As a student, I want to be able to confirm my attendance of a session by logging into the application to confirm that I've attended the lecture in person.

* A student account confirms their attendance for session by logging in.
* A student account is alerted upon first login that they've confirmed their attendance for the session.
* A student account sees a message on the main student screen saying they've confirmed their attendance for the session.
* Priority: **(1)** / Point Estimate: **[8]**

----------
**This is a spike for the dynamic listing of students that have "attended" a session by logging into the application.**

**<a href="#3.2">( see Sprint Goal (3.2) )</a>**

### Teacher's Dynamic Attendance View

As a teacher, I want to be able to see a real-time list of students who have already confirmed their attendance for the current session, so I can visually note which students and the total number who've attended.

* A teacher account can see a dynamic list of students as well as the total number of students who've confirmed their attendance for the current session which act as basic visual indicators for attendance.
* Priority: **(1)** / Point Estimate: **[40]**

----------
**This is a spike for clearing a new session for a particular class session.**

**<a href="#3.3">( see Sprint Goal (3.3) )</a>**

### Clear a Session

As a teacher, I want to be able to create a new session to take attendance which also clear's the previous session's attendance table (list of students who've confirmed their attendance)

* A teacher account can press a clear button in their view that clears the attendance table and signifies the start of a new session.
* Priority: **(1)** / Point Estimate: **[13]**

[back to top](#sprint-1-planning-meeting)

<h1 align="center">Task Breakdown</h1>

### Signup
* Create SignupView class < **(Prashant + Karan)**
* Create SignupController class < **(Prashant + Karan)**
* A user can select what type of account they'd like to register < **(Prashant + Karan)**
* A user must enter their email and password to register < **(Prashant + Karan)**
* Validate user input < **(Prashant + Karan)**
* Clicking the register button should switch to the main screen upon success or refresh with an appropriate error message upon failure. < **(Prashant + Karan)**
* A user should be able to click a button to go back to the login screen < **(Prashant + Karan)**

[back to top](#sprint-1-planning-meeting)

----------

### Registration Confirmation
* Send an email to the user upon successful registration < **(Karan)**
* Change email into a registration confirmation email < **(Karan)**

[back to top](#sprint-1-planning-meeting)

----------

### Login
* Create LoginView class < **(Hamza + Brandon)**
* Create LoginController class < **(Hamza + Brandon)**
* Create attendance class that represents attendance table tuple in DB < **(Hamza)**
* Log user in using Backendless' User Service API < **(Hamza + Brandon)**
* Clicking the register button switches to the Signup screen < **(Hamza + Brandon)**

[back to top](#sprint-1-planning-meeting)

----------

### Student Confirms Attendance
* Confirm attendance on first login of new session < **(Hamza + Brandon)**
* Check if student has already confirmed their attendance on subsequent logins < **(Hamza)**
* Create StudentView class < **(Hamza)**
* Display message on student's main screen saying they've confirmed their attendance < **(Hamza)**

[back to top](#sprint-1-planning-meeting)

----------

### Teacher's Dynamic Attendance View
* Create TeacherView class < **(Shriram + Mike)**
* Create TeacherController class < **(Shriram + Mike)**
* The teacher's main screen contains a dynamic list of students who've confirmed their attendance for the current session < **(Shriram)**


[back to top](#sprint-1-planning-meeting)

----------

### Clear a Session
* Add "clear session" button in TeacherView class
* Clicking the "clear session" button should clear the list and represent the start of a new session < **Mike**

[back to top](#sprint-1-planning-meeting)
