# On-Duty-Management-System
A Java and MySQL-based console application to manage student On-Duty (OD) requests with submission, review, and approval functionalities.
Got it! Here's your clean README.md file without any links:


---

# OD Management System

A Java and MySQL-based console application to manage student On-Duty (OD) requests with submission, review, and approval functionalities.


## Features

- Submit OD requests (Student)
- View OD requests (Staff)
- Approve or Reject requests (Staff)
- MySQL integration via JDBC
- Secure prepared statements to prevent SQL injection
- Simple, intuitive CLI interface

## Tech Stack

- Language: Java
- Database: MySQL
- Connector: JDBC
- Interface: Command Line Interface (CLI)

## Getting Started

### Prerequisites

- Java JDK 8 or higher
- MySQL Server 5.7 or higher
- MySQL JDBC Connector

### Setup Instructions

1. Clone the repository and navigate into it.
2. Create the database using the following SQL:

sql
CREATE DATABASE od_management;

USE od_management;

CREATE TABLE od_requests (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    student_name VARCHAR(100),
    reason VARCHAR(255),
    status ENUM('Pending', 'Approved', 'Rejected') DEFAULT 'Pending'
);

3. Compile the Java program

4. Run the application:


java Main

Sample Usage

Option 1: Submit OD request by entering student ID, name, and reason.

Option 2: View all submitted requests with current status.

Option 3: Staff can approve or reject requests using the request ID.


Future Enhancements

GUI or web-based interface

Notifications for status updates

Admin panel and analytics

User authentication and roles

Integration with campus systems

