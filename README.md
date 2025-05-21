# On-Duty-Management-System
A Java and MySQL-based console application to manage student On-Duty (OD) requests with submission, review, and approval functionalities.
Got 

---
# On-Duty Management System

A Java-based command-line application for managing student on-duty requests in educational institutions.

## Overview

The On-Duty (OD) Management System is designed to automate and streamline the process of managing student on-duty requests in educational institutions. Traditional methods of handling on-duty requests often involve paperwork that is time-consuming, prone to errors, and difficult to track. This project provides a digital solution using Java and MySQL to address these issues.

## Features

- **Submit OD Request**: Students can submit on-duty requests by providing their ID, name, and reason
- **View OD Requests**: Staff can view all submitted requests along with their details
- **Approve/Reject Requests**: Staff can update the status of requests to either Approved or Rejected
- **Database Management**: All requests are stored in a MySQL database for efficient retrieval and management

## System Architecture

The OD Management System follows a simple client-server architecture:
1. **User Interface Layer**: Command-line interface that interacts with users (students and staff)
2. **Application Logic Layer**: Java classes that implement the business logic
3. **Data Access Layer**: JDBC code that connects to and interacts with the MySQL database

## Database Schema

The system uses a MySQL database with the following structure:

```sql
CREATE TABLE od_requests (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    student_name VARCHAR(100),
    reason VARCHAR(255),
    status ENUM('Pending', 'Approved', 'Rejected') DEFAULT 'Pending'
);
```

## Requirements

- Java Development Kit (JDK) 8 or higher
- MySQL Server 5.7 or higher
- JDBC MySQL Connector
- Command-line interface for running the application

## Installation

### 1. Set Up Database

```bash
# Log in to MySQL
mysql -u your_username -p

# Create the database
CREATE DATABASE od_management;

# Use the database
USE od_management;

# Create the table
CREATE TABLE od_requests (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    student_name VARCHAR(100),
    reason VARCHAR(255),
    status ENUM('Pending', 'Approved', 'Rejected') DEFAULT 'Pending'
);

# Exit MySQL
exit;
```

### 2. Configure Database Connection

Edit the database connection parameters in the `Main.java` file:

```java
private static final String DB_URL = "jdbc:mysql://localhost:3306/od_management";
private static final String DB_USER = "your_username";
private static final String DB_PASSWORD = "your_password";
```

### 3. Compile and Run

```bash
# Compile
javac Main.java

# Run
java Main
```

## Usage

1. **Submit OD Request**:
   - Select option 1 from the main menu
   - Enter student ID (1-60), name, and reason for the OD request
   - System confirms successful submission

2. **View OD Requests**:
   - Select option 2 from the main menu
   - System displays all requests with their details

3. **Approve/Reject Request**:
   - Select option 3 from the main menu
   - Enter request ID and new status (Approved/Rejected)
   - System confirms successful update

## Future Enhancements

- Graphical user interface for improved user experience
- Email notifications to students when their request status changes
- Role-based access control for different types of users
- Reporting features for administrative purposes
- Integration with other institutional systems

## Troubleshooting

### Database Connection Issues
- Verify MySQL server is running
- Check username and password in the connection string
- Ensure the database exists

### Input Validation Errors
- Student ID must be within range 1-60
- Status must be either "Approved" or "Rejected"


## Acknowledgements

- Thanks to the Department of Computer Science and Engineering at Sathyabama Institute of Science and Technology
- Special thanks to Ms. K. Punitha for guidance and support during the project development
