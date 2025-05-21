-- Create the database
CREATE DATABASE od_management;

-- Use the database
USE od_management;

-- Create a table for OD requests
CREATE TABLE od_requests (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    student_name VARCHAR(100),
    reason VARCHAR(255),
    status ENUM('Pending', 'Approved', 'Rejected') DEFAULT 'Pending'
);

-- Query to view all records
SELECT * FROM od_requests;
