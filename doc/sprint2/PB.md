# Product Backlog

## Numerical Series

The numerical series we'll be using to assign priorities to our user stories is a simple **1-5 series** (i.e. **{1, 2, 3, 4, 5}**) where **1** is highest priority and **5** is lowest priority.

The numerical series we'll be using to assign point estimates to our user stories is a **modified Fibonnaci series**:

**0, 1/2, 1, 2, 3, 5, 8, 13, 20, 40, 80, 100, 400**

where **0** is lowest complexity and **400** is highest complexity.

## User Stories

### Glossary

**virtual session/session**: Represents a real life lecture. Tied to a unique course ID. Used to define logical periods of time to track attendance and submit feedback.

---

### Login / Logout

As a user, I want to be able to login and logout of the app so that I can choose when to use the app and protect my personal information.

* A user is taken to the app's main screen after successfully logging in (by correctly entering their username and password).
* A user is taken back to the login screen with cleared fields and an appropriate error message after an unsuccessful login.
* A user can click a logout button when they're logged in and are taken back to the login screen.
* Priority: **(1)** / Point Estimate: **[1/2]**

---

### Teacher can create Virtual Session

As a teacher, I want to be able to create a new virtual session (corresponds to a single in-person lecture and tied to a unique course ID) **(from here on referred to as a session)** that students can join by entering a code to automatically confirm their attendance (for that in-person lecture).

* A teacher account can create a new session for a new or old unique course ID and be presented with the randomly generated code to enter the session.
* A student account can use the session code to join the session and confirm their attendance.
* Priority: **(3)** / Point Estimate: **[5]**

---

### Student can join Virtual Session

As a student, I want to be able to join a session to confirm my attendance.

* A student account can enter the session code to join the session and confirm their attendance.
* A student account's attendance is reflected in their analytics view.
* A student's account's attendance is reflected in the associated teacher account's attendance analytics view.
* Priority: **(3)** / Point Estimate: **[80]**

---

### Student Attendance Analytics

As a student, I want to be able to track and review my attendance analytics for courses whose sessions I've attended so that I can improve my future attendance and performance.

* A student account can review their attendance analytics in different formats such as a line graph, comparative graph, calendar etc.
* Priority: **(3)** / Point Estimate: **[400]**

---

### Teacher Attendance Analytics

As a teacher, I want to be able to review the attendance analytics and ratings of courses that I've created sessions for so that I can give the course's students feedback on their attendance and improve my teaching.

* A teacher account can review the ratings and students' attendance analytics of a course that they've created sessions for in different formats such as a line graph, comparative graph, pie chart, happiness meter etc.
* Priority: **(3)** / Point Estimate: **[400]**

---

### User can change password

As a user, I want to be able to change my password to keep my account safe.

* A user can access an options menu and change their password.
* If the user tries to log in again, they can only successfully login using their new password.
* Priority: **(5)** / Point Estimate: **[1]**

---

### Student can rate session

As a student, I want to be able to give the teacher's lecture a simple rating (thumbs up/thumbs down) during or after a session so that I can give my teacher feedback.

* A student account can interact with a simple (thumbs up/thumbs down) interface during or after a session they've attended to rate the lecture up until they've attended another session.
* The rating is reflected in the associated teacher account's analytics and feedback view
* Priority: **(5)** / Point Estimate: **[20]**

---

### Student can give session feedback

As a student, I want to be able to submit an optional comment about a lecture during or after a session so I can influence my learning experience.

* A student account can write an optional comment in a text box and submit it as feedback during or after a session up until they've attended another session.
* A student can select from a small list of stock comments to submit instead.
* The associated teacher account can review the comment.
* Priority: **(5)** / Point Estimate: **[20]**

---

### Teacher can review student feedback

As a teacher, I want to be able to review the student feedback tied to self-created sessions with the same course ID so that I can improve my teaching.

* A teacher account can review all the students' ratings and comments (from most to least recent) per session or for all sessions in a single view.
* Priority: **(5)** / Point Estimate: **[40]**
