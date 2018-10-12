# Release Planning Meeting

## Meeting Minutes [Feb 1, 2017 | 1-2 PM]

### Agenda
* **<a href="#q1">What are our release goals?</a>**
* **<a href="#q2">What sets of user stories do we map to Sprint 1/2/3?</a>**
* **<a href="#q3">Arrange different time for Sprint 1 Demo due to schedule conflicts</a>**

### Main Decisions

<b id="q1">What are our release goals?</b>

See **Release Goals**.

<b id="q2">What sets of user stories do we map to Sprint 1/2/3?</b>

See **Release Timeline**.

<b id="q3">Arrange different time for Sprint 1 Demo due to schedule conflicts</b>

Due to schedule conflicts, we can't attend the regular Sprint 1 Demo times on Thursday. Therefore, we decided to discuss and arrange for a different time with the TA. We've agreed to be available on Thursday after 1 PM or Friday after 12 PM.

[back to top](#release-planning-meeting)

### Future Decisions / Next Steps?
* **Should we use Backendless or Firebase as our database backend?**
* **Should we use Eclipse's WindowBuilder plugin for building the GUI?**
* **How should we breakdown and assign the work for the sprint 1 deliverables?**
* **What user stories are we working on for Sprint 1?**
* **How are we going to breakdown those user stories into tasks and assign them?**
* **What will our workflow be like using Git and Pivotal Tracker?**
* **What, if any, coding conventions will we use?**
* **What design will we use for switching between views?**
	* Do we create a new view and dispose the old view on the fly? 
	* Do we follow the iOS methodology of collecting views in a stack
	* Something else?
* **We need to plan and practice our demo**

[back to top](#release-planning-meeting)

### Important Dates

**[Feb 5, 2017 | 3-6 PM]**
* Sprint 1 Planning Meeting

**[Feb 9, 2017 | 12-8 PM]**
* In-person meeting to start coding for Sprint 1

[back to top](#release-planning-meeting)

## Release Goals

**Note:** **Teacher** and **student** refer to teacher and student accounts respectively.

**Attendance Tracking**
* A teacher can create a virtual classroom (represent real-life classes) that students can join. 
* Teachers can hold virtual sessions (represent real-life lectures) tied to a virtual classroom that students who are a part of that classroom can join to confirm their attendance

**Attendance Analytics**
* Teachers can view their students' attendance analytics in different formats
* Students can view their attendance analytics in different formats (e.g. a line graph or calendar)

**Student Feedback**
* Students can give teachers feedback after each virtual session that they've attended in the form of ratings or comments
* Teachers can review their student's ratings and comments

[back to top](#release-planning-meeting)

## Release Timeline

### Sprint 1
* A new user can sign up for a teacher or student account **(<a href="#1">1</a>)**
* A user can login and logout **(<a href="#2">2</a>)**
* A teacher can create a virtual session that students can attend to confirm their attendance **(<a href="#5">5</a>)**
* A student can confirm their attendance **(<a href="#6">6</a>)**

### Sprint 2
* A teacher can create and delete virtual classroom **(<a href="#3">3</a>)** **(<a href="#9">9</a>)**
* A teacher can manage the students in their virtual classroom **(<a href="#10">10</a>)**
* A student can join or drop out from a virtual classroom **(<a href="#4">4</a>)** **(<a href="#11">11</a>)**
* A user can change their password **(<a href="#12">12</a>)**

### Sprint 3
* A user can see relevant analytics in a dedicated view (teacher or student analytics) **(<a href="#7">7</a>)** **(<a href="#8">8</a>)**
* A student can give optional feedback about a virtual session they've attended in the form of a simple rating or comment. **(<a href="#13">13</a>)** **(<a href="#14">14</a>)**
* A teacher can review student feedback for each virtual classroom that they manage **(<a href="#15">15</a>)**

[back to top](#release-planning-meeting)

### Referenced User Stories (from Product Backlog)

<ol>
<li id="1">As a user, I want to be able to create a new teacher or student account.</li>
<li id="2">As a user, I want to be able to login and logout of the app so that I can choose when to use the app and protect my personal information.</li>
<li id="3">As a teacher, I want to be able to create a virtual classroom (from here on referred to as a classroom) that my students can join so I can logically organize and track my students' attendance in a single place.</li>
<li id="4">As a student, I want to be able to join a teacher's classroom so that I can start tracking and confirming my attendance for the class associated with that classroom.</li>
<li id="5">As a teacher, I want to be able to create a new virtual session (corresponds to a single in-person lecture and tied to a classroom) (from here on referred to as a session) that the students (who are members of the classroom) can join by entering a code to automatically confirm their attendance (for that in-person lecture).</li>
<li id="6">As a student, I want to be able to join a session of a classroom that I'm a member of to confirm my attendance.</li>
<li id="7">As a student, I want to be able to track and review my attendance analytics for a classroom that I'm a member of so that I can improve my future attendance and performance.</li>
<li id="8">As a teacher, I want to be able to review the attendance analytics and ratings of a classroom that I manage so that I can give the classroom's students feedback on their attendance and improve my teaching.</li>
<li id="9">As a teacher, I want to be able to delete a classroom in case it's no longer needed such as when the corresponding course is completed.</li>
<li id="10">As a teacher, I want to be able to delete a student from a classroom that I manage in the case that they aren't enrolled in my class.</li>
<li id="11">As a student, I want to be able to drop a classroom in case I drop the class in real life or accidentally join.</li>
<li id="12">As a user, I want to be able to change my password to keep my account safe.</li>
<li id="13">As a student, I want to be able to give the teacher's lecture a simple rating (thumbs up/thumbs down) during or after a session so that I can give my teacher feedback.</li>
<li id="14">As a student, I want to be able to submit an optional comment about a lecture during or at the end of a session so I can influence my learning experience.</li>
<li id="15">As a teacher, I want to be able to review the student feedback for a classroom that I manage so that I can improve my teaching.</li>
</ol>

[back to Release Timeline](#release-timeline)
