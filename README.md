# student-skill-exchange-platform
java swing project for student skill exchange
🎓 Student Skill Exchange Platform

A Java Swing-Based Desktop Application for Collaborative Learning and Skill Sharing

<p align="center">
  **Share Skills • Discover Talent • Learn Together**
</p>---

📌 Project Overview

The Student Skill Exchange Platform is a Java-based desktop application designed to encourage collaborative learning among college students.

The platform allows students to register their details, list the skills they can teach, mention the skills they want to learn, discover other students and create skill-exchange requests.

For example, a student who knows Java can exchange knowledge with another student who knows SQL.

The application uses Java Swing and AWT for its graphical user interface and File Handling for permanent data storage.

---

🎯 Project Objectives

- Develop a platform for students to exchange knowledge.
- Allow students to register their academic and skill details.
- Provide an easy way to discover students based on skills.
- Enable students to create and view exchange requests.
- Maintain student and request records using file handling.
- Encourage peer-to-peer learning and collaboration.

---

🛠️ Technology Stack

Technology| Purpose
Java| Core programming language
Java Swing| Graphical User Interface
Java AWT| Layout management and GUI components
Java I/O| File handling and data storage
BufferedReader| Reading stored records
FileWriter| Writing student and request records
PrintWriter| Writing formatted data
JTable| Displaying student records
JOptionPane| Dialog boxes and user interaction

---

✨ Key Features

S.No| Feature| Description
1| Student Registration| Register students with academic and skill details
2| View Skills| Display all registered students and their skills
3| Student Search| Search by name, department or skill
4| Create Exchange Request| Send a request to exchange skills
5| View Requests| Display all saved exchange requests
6| Input Validation| Prevent empty fields and invalid entries
7| Data Persistence| Store information permanently in text files
8| Status Tracking| Maintain request status as Pending

---

🧩 System Modules

1. Student Registration

Allows students to register by entering:

- Student Name
- Email Address
- Department
- Year of Study
- Skills to Teach
- Skills to Learn

Output: A confirmation message appears after successful registration.

2. View Skills

Displays all registered students in a structured table.

Name| Department| Skills to Teach| Skills to Learn
Ananya| AIDS-2| SQL| Java
Student B| AIDS-2| Python| SQL

3. Find Students

Allows users to search for students using:

- Student name
- Department
- Skill name

Example:

Search Input| Expected Result
JAVA| Students matching Java
SQL| Students matching SQL
AIDS-2| Students in AIDS-2

4. Exchange Requests

Students can create requests by providing:

- Sender Name
- Receiver Name
- Skill Offered
- Skill Wanted

Sample Exchange Request:

From| To| Offered| Wanted| Status
Ananya| Student B| SQL| Java| Pending



📂 Project Structure

Student-Skill-Exchange-Platform/
│
├── StudentSkillExchange.java
│
├── data/
│   ├── students.txt
│   └── requests.txt
│
├── Project_Report.pdf
│
└── README.md

File / Folder| Description
StudentSkillExchange.java| Main Java source code
data/| Stores application records
students.txt| Stores registered student information
requests.txt| Stores skill-exchange requests
Project_Report.pdf| Project documentation
README.md| Project overview and instructions

Note: The data folder and text files are created automatically when the application saves its first records.

---

💾 Data Storage Design

The application uses text files instead of a database.

Student Records – students.txt

Each student record contains six fields separated by the pipe ("|") symbol.

Name|Email|Department|Year|Teach|Learn

Sample Record:

Ananya|ananya@example.com|AIDS-2|2026|SQL|JAVA

Exchange Requests – requests.txt

Each request contains five fields.

From|To|Offered|Wanted|Status

Sample Record:

Ananya|StudentB|SQL|JAVA|Pending

---

🖥️ Application Outputs

The following are the main application screens and their expected results.

1. Home Screen

Displays four main options:

- Register Student
- View Skills
- Find Students
- Exchange Requests

2. Student Registration Output

After entering valid student details, the application displays:

Student registered successfully!

3. View Skills Output

Name| Department| Teach| Learn
Ananya| AIDS-2| SQL| Java
Student B| AIDS-2| Python| SQL

4. Search Results

When the user enters "JAVA", the application displays matching student records.

5. Exchange Request Output

After creating a valid request:

Exchange request saved successfully!

The request is stored with the status:

Pending

6. Validation Output

Test Condition| Expected Message
Empty registration fields| Please fill all fields
Invalid email without @| Enter a valid email address
Empty search input| Enter a search term
Request to yourself| You cannot request an exchange with yourself
No matching records| No records found



🧪 Testing and Results

The following test cases represent the expected application behaviour.

Test ID| Test Scenario| Expected Result| Status
TC01| Register a student| Student record saved| Pass
TC02| View registered students| Student table displayed| Pass
TC03| Search using a skill| Matching students displayed| Pass
TC04| Create exchange request| Request saved successfully| Pass
TC05| View exchange requests| Request table displayed| Pass
TC06| Submit empty fields| Validation message displayed| Pass
TC07| Enter invalid email| Error message displayed| Pass
TC08| Restart application| Previously saved records remain available| Pass



⚙️ Installation and Execution

Prerequisites

- Java Development Kit (JDK 8 or above)
- Windows / Linux operating system
- Notepad or any Java IDE

Step 1: Clone the Repository

git clone https://github.com/YOUR-USERNAME/student-skill-exchange-platform.git

Step 2: Open the Project Folder

cd student-skill-exchange-platform

Step 3: Compile the Java Program

javac StudentSkillExchange.java

Step 4: Run the Application

java StudentSkillExchange

The Student Skill Exchange Platform home screen will open.



🔮 Future Enhancements

The project can be extended with the following features:

1. Student login and authentication.
2. MySQL database integration.
3. Accept and reject exchange requests.
4. Email notifications for new requests.
5. Automatic matching of students based on complementary skills.
6. Improved user interface and dashboard.
7. Student profile management.



🎓 Learning Outcomes

Through this project, the following Java concepts are demonstrated:

- Object-Oriented Programming
- Classes and Objects
- Inheritance through JFrame
- Exception Handling
- Java Swing Components
- Event Handling
- File Handling
- Collections and Table Models
- Input Validation



👩‍💻 Project Information

Detail| Information
Project Name| Student Skill Exchange Platform
Programming Language| Java
Application Type| Desktop Application
GUI Framework| Java Swing
Storage| Text File Handling
Domain| Education and Collaborative Learning



🏁 Conclusion

The Student Skill Exchange Platform provides a simple environment for students to share knowledge and learn new skills from one another.

By combining Java Swing, event handling and file handling, the project demonstrates the development of a functional desktop application.

The platform promotes collaborative learning and encourages students to develop their technical skills through peer interaction.

---

<p align="center">
  

</p>
