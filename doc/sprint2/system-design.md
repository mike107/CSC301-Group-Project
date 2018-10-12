<h1 align="center">
Student Attendance Tracker </br> System Design
</h1>

## Project Development Team
* Shriram Anpalakan (anpalaka)
* Karan Bhagat (bhagatka)
* Hamza Ali (alihamz2)
* Brandon Villamor (villamo3)
* Mike Byun (byundong)
* Prashant Rawal (rawalpr1)

<h1 align="center">Table of Contents</h1>

[**Report**](#report)

1. [System's Operating Environment](#operating-environment-dependencies)
2. [Error-Handling Strategy](#error-handling-strategy)

[**CRC Cards**](#crc-cards)

#### Signup

3. [SignUpView](#signupview)
4. [SignUpController](#signupcontroller)

#### Login

5. [LoginView](#loginview)
6. [LoginController](#logincontroller)

#### Teacher Account

7. [TeacherView](#teacherview)
8. [TeacherViewMain](#teacherviewmain)
9. [TeacherViewController](#teacherviewcontroller)
11. [FeedbackCellRenderer](#feedbackcellrenderer)
12. [FeedbackTableModel](#feedbacktablemodel)
13. [CreateNewWindow](#createnewwindow)

#### Student Account

14. [StudentEnterSessionView](#studententersessionview)
15. [StudentEnterSessionViewController](#studententersessionviewcontroller)
16. [StudentFeedbackView](#studentfeedbackview)
17. [StudentFeedbackViewController](#studentfeedbackviewcontroller)
18. [JButtonTag](#jbuttontag)

#### Database Objects

19. [Teachers](#teachers)
20. [Students](#students)
21. [Attendance](#attendance)
10. [Feedback](#feedback)

[**System Architecture**](#system-architecture)

22. [UML Class Diagram](#uml-class-diagram)

<h1 align="center">Report</h1>

## Operating Environment Dependencies

* Our application can run on Windows, Mac and Linux OSes with minor GUI differences
* We assume the operating environment has JRE 9+ installed
* We assume the operating environment is connected to the internet to allow for server communication between Backendless and the application

[back to top](#table-of-contents)

## Error-Handling Strategy

For invalid user input, we'll whitelist the input and display an appropriate error message to the user. For example, this is our strategy for handling invalid login and signup inputs.

In the event of a network failure, we'll display an appropriate error message to the user and leave it to the them to either fix the connection failure or close the application.

In the event of multithreading program issues, a server API call overload may occur. In this case, we'll display an appropriate error message to the user to close the application to prevent memory leak since our application can't gracefully recover from these issues.

In the event of an external system failure, we'll leave it to the user to close the application since our application has no way of detecting the external system failure.

[back to top](#table-of-contents)

<h1 align="center">CRC Cards</h1>

## SignUpView 

**Class name:** SignUpView\
**Parent class:** N/A\
**Subclasses:** N/A\
**Responsibilities:**
* Initializes GUI for "Sign Up" page
* Has an email field
* Has a password field
* Has a name field
* Has radio buttons to choose between a teacher or student account
* Has a "Back

**Collaborators:**

[back to top](#table-of-contents)

## SignUpController

**Class name:** SignUpController\
**Parent class:** N/A\
**Subclasses:** N/A\
**Responsibilities:**
* Creates the user account
* Updates the SignUpView
* Updates the database
* Shows appropriate error message when an exception occurs

**Collaborators:**
* SignUpView
* LoginView
* LoginController
* Students
* Teachers

[back to top](#table-of-contents)

## LoginView

**Class name:** LoginView\
**Parent class:** N/A\
**Subclasses:** N/A\
**Responsibilities:**
* Initializes GUI for Login page
* Has a username field
* Has a password field
* Has a "Login" Button
* Has a "Register" button

**Collaborators:**

[back to top](#table-of-contents)

## LoginController

**Class name:** LoginController\
**Parent class:** N/A\
**Subclasses:** N/A\
**Responsibilities:**
* Has a LoginView
* Interprets user input from LoginView
* Validates user input and shows appropriate error messages
* Updates student attendance upon student login

**Collaborators:**
* LoginView
* Attendance
* SignUpView
* SignUpController
* TeacherView
* TeacherViewController
* StudentEnterSessionView
* StudentEnterSessionViewController

[back to top](#table-of-contents)

## TeacherView

**Class name:** TeacherView\
**Parent class:** N/A\
**Subclasses:** N/A\
**Responsibilities:**
* Initialize GUI for Teacher’s home page
* Has an attendance list
* Has a clear session button

**Collaborators:**

[back to top](#table-of-contents)

## TeacherViewMain

**Class name:** TeacherViewMain\
**Parent class:** N/A\
**Subclasses:** N/A\
**Responsibilities:**
* Initialize the GUI for Teachers’s home page after login in
* Displays the graph for the course chosen by the teacher 
* Displays the average rating for the course selected 
* Displays the attendance for the course selected 
* Displays the sessions created for each course by the teacher 
* Displays the feedback given by the students
* Saves the graph 

**Collaborators:**
* Teachers
* TeacherView
* TeacherViewController

[back to top](#table-of-contents)

## TeacherViewController

**Class name:** TeacherViewController\
**Parent class:** N/A\
**Subclasses:** N/A\
**Responsibilities:**
* Has a TeacherView
* Dynamically updates TeacherView's attendance list
* When clear session button is pressed, clears the attendance list
* Sends message to TeacherView as feedback while waiting for a session to clear

**Collaborators:**
* TeacherView
* Attendance

[back to top](#table-of-contents)

## FeedbackCellRenderer

**Class name:** Feedback\
**Parent class:** JTextArea\
**Interface(s):** TableCellRenderer\
**Subclasses:** N/A\
**Responsibilities:**
* Renders cells in teacher feedback table
* Formats Feedback

**Collaborators:**
* Feedback

[back to top](#table-of-contents)

## FeedbackTableModel

**Class name:** Feedback\
**Parent class:** DefaultTableModel\
**Subclasses:** N/A\
**Responsibilities:**
* Knows its column count
* knows its column name
* Knows its row count
* Knows its values at each row
* Knows its cell class
* Defines model of teacher feedback table

**Collaborators:**
* Feedback

[back to top](#table-of-contents)

## CreateNewWindow

**Class name:** CreateNewWindow\
**Parent class:** N/A\
**Subclasses:** N/A\
**Responsibilities:**
* Allow teachers to add new courses 

**Collaborators:**

[back to top](#table-of-contents)

## StudentEnterSessionView

**Class name:** StudentEnterSessionView\
**Parent class:** N/A\
**Subclasses:** N/A\
**Responsibilities:**
* Initialize GUI for Student to enter session

**Collaborators:**

[back to top](#table-of-contents)

## StudentEnterSessionViewController

**Class name:** StudentEnterSessionViewController\
**Parent class:** N/A\
**Subclasses:** N/A\
**Responsibilities:**
* Controller for StudentEnterSessionView
* Submits data to backendless

**Collaborators:**
* StudentEnterSessionView
* StudentFeedbackView
* StudentFeedbackViewController

[back to top](#table-of-contents)

## StudentFeedbackView

**Class name:** StudentFeedbackView\
**Parent class:** N/A\
**Subclasses:** N/A\
**Responsibilities:**
* Initialize GUI for Student to enter feedback and rating

**Collaborators:**

[back to top](#table-of-contents)

## StudentFeedbackViewController

**Class name:** StudentFeedbackViewController\
**Parent class:** N/A\
**Subclasses:** N/A\
**Responsibilities:**
* Controller for StudentFeedbackView
* Submits data to backendless

**Collaborators:**
* StudentFeedbackView

[back to top](#table-of-contents)

## JButtonTag

**Class name:** JButtonTag\
**Parent class:** N/A\
**Subclasses:** N/A\
**Responsibilities:**
* Provides a tag for each button used for rating 

**Collaborators:**

[back to top](#table-of-contents)

## Teachers

**Class name:** Teachers\
**Parent class:** N/A\
**Subclasses:** N/A\
**Responsibilities:**
* Knows its course ID
* Knows its teacher email

**Collaborators:**

[back to top](#table-of-contents)

## Attendance

**Class name:** Attendance\
**Parent class:** N/A\
**Subclasses:** N/A\
**Responsibilities:**
* Represents a student's attendance confirmation entry
* Knows its course ID
* Knows its student email

**Collaborators:**

[back to top](#table-of-contents)

## Students

**Class name:** Students\
**Parent class:** N/A\
**Subclasses:** N/A\
**Responsibilities:**
* Knows its course ID
* Knows its student email

**Collaborators:**

[back to top](#table-of-contents)

## Feedback

**Class name:** Feedback\
**Parent class:** N/A\
**Subclasses:** N/A\
**Responsibilities:**
* Knows its feedback message
* Knows its feedback rating
* Knows its course ID
* Knows its session ID
* Knows its recipient
* Knows its writer

**Collaborators:**

[back to top](#table-of-contents)



<h1 align="center">System Architecture</h1>

## UML Class Diagram
![UML Class Diagram](uml-class-diagram.png)

[back to top](#table-of-contents)
