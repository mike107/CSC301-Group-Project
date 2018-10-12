<h1 align="center">Sprint 2 Planning Meeting</h1>

## Meeting Minutes [Feb 16, 2017 | 2-3 PM]

### Participants
* **Shriram Anpalakan** (anpalaka)
* **Karan Bhagat** (bhagatka)
* **Hamza Ali** (alihamz2)
* **Brandon Villamor** (villamo3)
* **Mike Byun** (byundong)
* **Prashant Rawal** (rawalpr1)

### Agenda
* **<a href="#q1">How should we breakdown and assign the work for the Sprint 2 deliverables (e.g. sprint2.md)?</a>**
* **<a href="#q2">What user stories are we working on for Sprint 2?</a>**
* **<a href="#q3">Are we going to simplify the project to reduce our workload?</a>**
* **<a href="#q4">Are we introducing any new user stories for Sprint 2?</a>**

### Main Decisions

<b id="q1">How should we breakdown and assign the work for the Sprint 2 deliverables?</b>

Since Brandon was the one to draft and submit the original Sprint 1 deliverables, it made the most sense for him to do the same for the Sprint 2 deliverables since he understands what each document requires.

We also decided to plan and practice the Sprint 2 Demo on Mar 8 from 1 to 3 PM which is our usual weekly meeting time. Due to scheduling conflicts, we've arranged to hold our demo on Mar 9.

Lastly, we decided to hold our Sprint 2 Retrospective Meeting right after our demo on Mar 9.

[back to Agenda](#agenda)

<b id="q2">What user stories are we working on for Sprint 2?</b>

See [**Sprint Goals**](#sprint-goals)

[back to Agenda](#agenda)

<b id="q3">Are we going to simplify the project to reduce our workload?</b>

After a fair amount of discussion, we decided to simplify the project by cutting and simplifying certain user stories to create a more manageable workload. Taking into account all of our schedules, we decided this was the best course of action in order to deliver a polished and functional final product.

In particular we decided to remove all functionality related to virtual classrooms and focus on virtual sessions instead. Instead of virtual classrooms that teachers can manage and students can join, virtual sessions will be categorized by a unique course ID.

In this way, our app will function more like Kahoot where students can join any virtual session they have the code for as opposed to Piazza where students must first join an online classroom.

Therefore we've removed the following user stories from our Product Backlog:

* Teacher can create Virtual Classroom
* Student can create Virtual Classroom
* Teacher can delete their Virtual Classroom
* Student can drop out from Virtual Classroom

And updated the following user stories:

* Teacher can create Virtual Session
* Student can join Virtual Session

[back to Agenda](#agenda)

<b id="q4">Are we introducing any new user stories for Sprint 2?</b>

We decided not to introduce any new user stories for Sprint 2 so as not to increase our workload. However, upon further testing of our Sprint 1 code, Karan and Prashant brought to our attention the following concerns:

* Our application should check for the user's internet connection since our application communicates with the Backendless server
* Need to make sure a user can only send one piece of feedback per session.

[back to Agenda](#agenda)

### Future Decisions / Next Steps?
* **What design will we use for switching between views?**
	* Do we create a new view and dispose the old view on the fly? 
	* Do we follow the iOS methodology of collecting views in a stack
	* Something else?
* **We need to plan and practice our demo**

[back to top](#sprint-2-planning-meeting)

### Important Dates

**[Feb 22, 2017 | 7-9 PM]**
* Online Meeting during Reading Week

**[Mar 2, 2017 | 11-3 PM]**
* In-person Meeting

**[Mar 7, 2017]**
* sprint2.md, updated PB.md and updated SystemDesign.pdf due

**[Mar 8, 2017 | 1-3 PM]**
* Demo Practice

**[Mar 9, 2017]**
* Sprint 2 Demo (arranged with TA to accommodate schedule conflicts)

[back to top](#sprint-1-planning-meeting)

<h1 align="center">Sprint 2 Backlog</h1>

## Sprint Goals

1. Complete the following user stories (as recorded in Pivotal Tracker):

### Virtual Sessions
* Teacher can create Virtual Session
* Student can join Virtual Session

### Attendance Analytics
* Teacher Attendance Analytics
* Student Attendance Analytics

### Student Feedback
* Student can rate session
* Student can give session feedback
* Teacher can review student feedback

2. Take care of the concerns noted [here](#q4).

[back to top](#sprint-1-planning-meeting)

<h1 align="center">Task Breakdown</h1>

* **Shriram Anpalakan** = (SH)
* **Karan Bhagat** = (KA)
* **Hamza Ali** = (HA)
* **Brandon Villamor** = (BR)
* **Mike Byun** = (MI)
* **Prashant Rawal** = (PR)

**Teacher can create Virtual Session**
* Create Teacher GUI (MI)
	* Create "Create a Session" View (MI)
		* "Generate a unique random code" functionality (SH)
		* Compute teacher's geolocation (KA)
	* **Teacher can review student feedback**
	* Create Teacher Feedback View (MI)
		* Generate list of teacher's created sessions (BR)
		* Generate list of student feedback per session and for all sessions (BR)
	* Dynamic Attendance View
		* Update attendance table to work per session (SH)
		* Keep a count of how many students have attended (SH)
	
**Student can join Virtual Session**
* Create Student GUI (KA, PR)
	* Create "Join a Session" View (KA, PR)
	* Create Student Feedback View (KA, PR)
		* **Student can rate a session**
		* A student can rate a session out of 5 stars (KA, PR)
		* **Student can give session feedback**
		* A student can enter a message about the session they've attended and submit it anonymously to the teacher (KA, PR)
		* A student can choose from a small list of stock messages to submit. (KA, PR)
		* If a student logs out of the application before giving session feedback, they have the option of going directly to the session feedback screen when they log back in. This option is available until they join a new session. (KA, PR)
	
**Student Attendance Analytics**
* Create Student Analytics View (KA, PR)
	* Visualize basic statistics such as number of sessions attended, percentage of sessions attended for a class, etc. (KA, PR)

**Teacher Attendance Analytics**
* Create Teacher Analytics View (HA)
	* Visualize basic statistics such as number of sessions created, average session rating, etc. (HA, PR)
