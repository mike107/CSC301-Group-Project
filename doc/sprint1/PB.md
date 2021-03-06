# Product Backlog

## Numerical Series

The numerical series we'll be using to assign priorities to our user stories is a simple **1-5 series** (i.e. **{1, 2, 3, 4, 5}**) where **1** is highest priority and **5** is lowest priority.

The numerical series we'll be using to assign point estimates to our user stories is a **modified Fibonnaci series**:

**0, 1/2, 1, 2, 3, 5, 8, 13, 20, 40, 80, 100, 400**

where **0** is lowest complexity and **400** is highest complexity.

## User Stories

### Glossary

**virtual classroom/classroom** Represents a real life class. Used to logically organize that class' students, their feedback, and attendance analytics.

**virtual session/session**: Represents a real life lecture. Tied to a virtual classroom. Used to define logical periods of time to track attendance and submit feedback.

---

**(User Story)**

### Signup

As a user, I want to be able to create a new teacher or student account.

**(Criteria of Satisfaction)**
* After a user correctly completes and submits a sign up form on the signup screen, they are taken to the app's main screen already logged in as their new account.

**(Priority and Point Estimate)**
* Priority: **(1)** / Point Estimate: **[3]**

---
<h3 align="center">NEW USER STORY</h3>

### Registration Confirmation

As a user, I want to be able to recieve an email confirming my registration.
* **A user receives a registration confirmation email.**
* Priority: **(1)** / Point Estimate: **[1]**

---

### Login / Logout

As a user, I want to be able to login and logout of the app so that I can choose when to use the app and protect my personal information.

* A user is taken to the app's main screen after successfully logging in (by correctly entering their username and password).
* A user is taken back to the login screen with cleared fields and an appropriate error message after an unsuccessful login.
* A user can click a logout button when they're logged in and are taken back to the login screen.
* Priority: **(1)** / Point Estimate: **[1/2]**

---

### Teacher can create Virtual Classroom

As a teacher, I want to be able to create a virtual classroom **(from here on referred to as a classroom)** that my students can join so I can logically organize and track my students' attendance in a single place.

* A teacher account has the option to create a new classroom with any additional info (classroom name, description, etc.) and is presented with a randomly generated code that they can give to their students to join the classroom.
* When the classroom appears in the list of classrooms that a teacher account manages.
* When a student account is able to join the classroom.
* Priority: **(2)** / Point Estimate: **[13]**

---

### Student can join Virtual Classroom

As a student, I want to be able to join a teacher's classroom so that I can start tracking and confirming my attendance for the class associated with that classroom.

* A student account can join a classroom using the associated code.
* The classroom shows up in the list of classrooms that the student account is a member of.
* The student account can join sessions associated to that classroom.
* Priority: **(2)** / Point Estimate: **[40]**

---

### Teacher can create Virtual Session

As a teacher, I want to be able to create a new virtual session (corresponds to a single in-person lecture and tied to a classroom) **(from here on referred to as a session)** that the students (who are members of the classroom) can join by entering a code to automatically confirm their attendance (for that in-person lecture).

* A teacher account can create a new session with any additional info (lecture name, description, etc.) and be presented with the randomly generated code to enter the session.
* A student account can use the session code to join the session and confirm their attendance.
* Priority: **(3)** / Point Estimate: **[5]**

---

### Student can join Virtual Session

As a student, I want to be able to join a session of a classroom that I'm a member of to confirm my attendance.

* A student account who is a member of the associated classroom can enter the session code to join the session and confirm their attendance.
* A student account's attendance is reflected in their analytics view.
* A student's account's attendance is reflected in the associated teacher account's attendance analytics view.
* Priority: **(3)** / Point Estimate: **[80]**

<h3 align="center">Note: This is a spike user story for the above user story. This is explained in sprint1.md.</h3>

### Student Confirms Attendance

As a student, I want to be able to confirm my attendance of a session by logging into the application to confirm that I've attended the lecture in person.

* A student account confirms their attendance for session by logging in
* A student account is alerted upon first login that they've confirmed their attendance for the session
* A student account sees a message on the main student screen saying they've confirmed their attendance for the session
* Priority: **(1)** / Point Estimate: **[8]**

---
<h3 align="center">SPIKE USER STORY (NEW)</h3>

### Teacher's Dynamic Attendance View

As a teacher, I want to be able to see a real-time list of students who have already confirmed their attendance for the current session, so I can visually note which students and the total number who've attended.

* A teacher account can see a dynamic list of students as well as the total number of students who've confirmed their attendance for the current session which act as basic visual indicators for attendance.
* Priority: **(1)** / Point Estimate: **[40]**

---
<h3 align="center">SPIKE USER STORY (NEW)</h3>

### Clear a Session

As a teacher, I want to be able to create a new session to take attendance which also clear's the previous session's attendance table (list of students who've confirmed their attendance).

* A teacher account can press a clear button in their view that clears the attendance table and signifies the start of a new session.
* Priority: **(1)** / Point Estimate: **[13]**

---

### Student Attendance Analytics

As a student, I want to be able to track and review my attendance analytics for a classroom that I'm a member of so that I can improve my future attendance and performance.

* A student account can review their attendance analytics in different formats such as a line graph, comparative graph etc.
* Priority: **(3)** / Point Estimate: **[400]**

---

### Teacher Attendance Analytics

As a teacher, I want to be able to review the attendance analytics and ratings of a classroom that I manage so that I can give the classroom's students feedback on their attendance and improve my teaching.

* A teacher account can review the ratings and students' attendance analytics of a classroom that they manage in different formats such as a line graph, comparative graph, pie chart, happiness meter etc.
* Priority: **(3)** / Point Estimate: **[400]**

---

### Teacher can delete their Virtual Classroom

As a teacher, I want to be able to delete a classroom in case it's no longer needed such as when the corresponding course is completed.

* A teacher account can delete a classroom from their managed classrooms list.
* The teacher account no longer has access to the classroom.
* The associated student accounts no longer have access to the classroom.
* Priority: **(4)** / Point Estimate: **[8]**

---

### Teacher can delete Student from Virtual Classroom

As a teacher, I want to be able to delete a student from a classroom that I manage in the case that they aren't enrolled in my class.

* A teacher account can click on a student's entry in their classroom's student listing and delete them from the classroom.
* The student's entry no longer appears in the classroom's student listing.
* The corresponding student account no longer has access to the classroom.
* Priority: **(5)** / Point Estimate: **[13]**

---

### Student can drop out from Virtual Classroom

As a student, I want to be able to drop a classroom in case I drop the class in real life or accidentally join.

* A student account can click on a classroom entry in their classrooms list and drop the classroom.
* The student account no longer has access to the classroom.
* The student account no longer appears in the classroom's student listing in the associated teacher's account.
* Priority: **(5)** / Point Estimate: **[40]**

---

### User can change password

As a user, I want to be able to change my password to keep my account safe.

* A user can access an options menu and change their password.
* If the user tries to log in again, they can only successfully login using their new password.
* Priority: **(5)** / Point Estimate: **[1]**

---

### Student can rate session

As a student, I want to be able to give the teacher's lecture a simple rating (thumbs up/thumbs down) during or after a session so that I can give my teacher feedback.

* A student account can interact with a simple (thumbs up/thumbs down) interface during or after a session they've attended to rate the lecture.
* The rating is reflected in the associated teacher account's analytics and feedback view
* Priority: **(5)** / Point Estimate: **[20]**

---

### Student can give session feedback

As a student, I want to be able to submit an optional comment about a lecture during or at the end of a session so I can influence my learning experience.

* A student account can write an optional comment in a text box and submit it as feedback during or at the end of a session.
* The associated teacher account can review the comment.
* Priority: **(5)** / Point Estimate: **[20]**

---

### Teacher can review student feedback

As a teacher, I want to be able to review the student feedback for a classroom that I manage so that I can improve my teaching.

* A teacher account can review all the students' ratings and comments (most to least recent) for classroom they manage in a single view.
* Priority: **(5)** / Point Estimate: **[40]**

---
As a user, I want to validate my account.

* A confrimation email is sent to the user so they can validate their account.
* Priority: **(5)** / Point Estimate: **[1]**
