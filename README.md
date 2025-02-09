**<h1>University Result Management System</h1>**


A web-based application that allows students to check their university results by entering their roll number. This project is built using **HTML, CSS, JDBC, and Servlets**.

---

**Features**

📌 Student can enter their roll number to fetch results

📌 Displays subject-wise internal, external, and total marks

📌 Indicates pass/fail status

📌 Styled using HTML and CSS for a clean UI

📌 Backend implemented using Java Servlets and JDBC to fetch results from a database

---

**Technologies Used**

**Frontend:** HTML, CSS

**Backend:** Java Servlets

**Database Connection:** JDBC

**Database:** MySQL (or any other SQL-based database)

**Installation & Setup**

---

**Prerequisites**

Java Development Kit (JDK) installed

Apache Tomcat server

MySQL database

JDBC Driver (MySQL Connector or relevant)

---

**Steps to Run**

Clone the repository

git clone https://github.com/yourusername/university-result-management.git
cd university-result-management

Set up the MySQL database:

Create a database (university_results)

Import the provided SQL file (if available)

Update database connection details in the project

Modify DBConnection.java (or equivalent file) with:

String url = "jdbc:mysql://localhost:3306/university_results";
String user = "your_db_username";
String password = "your_db_password";

Deploy the project on Apache Tomcat

Place the .war file in the webapps directory

Start Tomcat and access the application at http://localhost:8080/university-result

---

**Screenshots**

**Home Page**

![Screenshot 2025-02-09 134059](https://github.com/user-attachments/assets/8e907449-b28e-4f1f-ae7f-4c569dcf2fcb)

---

**Result Page**
![image](https://github.com/user-attachments/assets/8f3d3b6f-d6a2-48fd-ba62-e81abddeb352)

---

**Future Enhancements**

📌 Add Admin Panel for result management

📌 Improve UI with better styling and animations

📌 Secure database connection with better authentication
