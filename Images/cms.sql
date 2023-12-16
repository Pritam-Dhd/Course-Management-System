-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 08, 2023 at 12:09 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cms`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `course_id` varchar(200) NOT NULL,
  `course_name` varchar(200) NOT NULL,
  `Years` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`course_id`, `course_name`, `Years`) VALUES
('CS0010', 'BSC Hons Computer Science', 3),
('CS0060', 'BSC CSIT', 3);

-- --------------------------------------------------------

--
-- Table structure for table `instructor`
--

CREATE TABLE `instructor` (
  `Instructor_Id` varchar(200) NOT NULL,
  `Instructor_Name` varchar(200) NOT NULL,
  `Email` varchar(200) NOT NULL,
  `module1` varchar(200) NOT NULL,
  `module2` varchar(200) NOT NULL,
  `module3` varchar(200) NOT NULL,
  `module4` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `instructor`
--

INSERT INTO `instructor` (`Instructor_Id`, `Instructor_Name`, `Email`, `module1`, `module2`, `module3`, `module4`) VALUES
('210542', 'Aagya Sharma', 'npAagya.Sharma@heraldcollege.edu.np', 'Introductory Programming And Problem Solving', 'Internet Software Architecture', 'Object-Oriented Design and Programming', 'Operating System'),
('2067162', 'Simon Giri', 'npSimon.Giri@heraldcollege.edu.np', 'Academic Skills and Team-Based Learning', 'Concepts and Technologies of AI', 'Big Data', 'Artificial Intelligence and Machine Learning'),
('2073156', 'Ashish Acharya', 'npAshish.Acharya@heraldcollege.edu.np', 'Introductory Programming And Problem Solving', 'Computational Mathematics', 'Numerical Methods and Concurrency', 'Distributed and Cloud System Programming'),
('2105712', 'Rukesh Shrestha', 'npRukesh.Shrestha@heraldcollege.edu.np', 'Fundamentals of Computing', 'Embedded System Programming', 'Object-Oriented Design and Programming', 'Human - Computer Interaction'),
('2301472', 'Anmol Adhikari', 'npAnmol.Adhikari@heraldcollege.edu.np', 'Concepts and Technologies of AI', 'Big Data', 'Complex Systems', 'Human - Computer Interaction'),
('2056934', 'Deepson Shrestha', 'npDeepson.Shrestha@heraldcollege.edu.np', 'Internet Software Architecture', 'Data Structure and Algorithm', 'Distributed and Cloud System Programming', 'Web Technologies');

-- --------------------------------------------------------

--
-- Table structure for table `marks`
--

CREATE TABLE `marks` (
  `Student_Id` varchar(200) NOT NULL,
  `Student_Name` varchar(200) NOT NULL,
  `Module_Name` varchar(200) NOT NULL,
  `Marks` int(11) NOT NULL,
  `Grade` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `marks`
--

INSERT INTO `marks` (`Student_Id`, `Student_Name`, `Module_Name`, `Marks`, `Grade`) VALUES
('2226153', 'Pritam Dhaugoda', 'Object-Oriented Design and Programming', 84, 'A'),
('2226153', 'Pritam Dhaugoda', 'Numerical Methods and Concurrency', 81, 'A'),
('2226153', 'Pritam Dhaugoda', 'Concepts and Technologies of AI', 80, 'A'),
('2226153', 'Pritam Dhaugoda', 'Data Structure and Algorithm', 83, 'A');

-- --------------------------------------------------------

--
-- Table structure for table `module`
--

CREATE TABLE `module` (
  `Module_Id` varchar(200) NOT NULL,
  `Course_Name` varchar(200) NOT NULL,
  `Module_Name` varchar(200) NOT NULL,
  `Semester` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `module`
--

INSERT INTO `module` (`Module_Id`, `Course_Name`, `Module_Name`, `Semester`) VALUES
('4CS001', 'BSC Hons Computer Science', 'Introductory Programming And Problem Solving', 1),
('4C1018', 'BSC Hons Computer Science', 'Academic Skills and Team-Based Learning', 1),
('4CS015', 'BSC Hons Computer Science', 'Fundamentals of Computing', 1),
('4CS111', 'BSC Hons Computer Science', 'Digital Logic', 1),
('4MM013', 'BSC Hons Computer Science', 'Computational Mathematics', 2),
('4CS017', 'BSC Hons Computer Science', 'Internet Software Architecture', 2),
('4CS016', 'BSC Hons Computer Science', 'Embedded System Programming', 2),
('4CS160', 'BSC Hons Computer Science', 'Discrete Structure', 2),
('5CS019', 'BSC Hons Computer Science', 'Object-Oriented Design and Programming', 3),
('5CS037', 'BSC Hons Computer Science', 'Concepts and Technologies of AI', 3),
('5CS021', 'BSC Hons Computer Science', 'Numerical Methods and Concurrency', 3),
('5CS206', 'BSC Hons Computer Science', 'Data Structure and Algorithm', 3),
('5CS024', 'BSC Hons Computer Science', 'Collaborative Development', 4),
('5CS020', 'BSC Hons Computer Science', 'Human - Computer Interaction', 4),
('5CS022', 'BSC Hons Computer Science', 'Distributed and Cloud System Programming', 4),
('5CS259', 'BSC Hons Computer Science', 'Operating System', 4),
('6CS030', 'BSC Hons Computer Science', 'Big Data', 5),
('6CS005', 'BSC Hons Computer Science', 'High Performance Computing', 5),
('6CS319', 'BSC Hons Computer Science', 'Multimedia Computing', 5),
('6CS318', 'BSC Hons Computer Science', 'Web Technologies', 5),
('6CS315', 'BSC Hons Computer Science', 'System Analysis and Design', 5),
('6CS007', 'BSC Hons Computer Science', 'Project and Professionalism', 6),
('6CS012', 'BSC Hons Computer Science', 'Artificial Intelligence and Machine Learning', 6),
('6CS014', 'BSC Hons Computer Science', 'Complex Systems', 6),
('6CS367', 'BSC Hons Computer Science', 'NET Centric Computing', 6),
('6CS365', 'BSC Hons Computer Science', 'Compiler Design and Construction', 6),
('CSC101', 'BSC CSIT', 'Introduction to Information Technology', 1),
('CSC110', 'BSC CSIT', 'C Programming', 1),
('CSC111', 'BSC CSIT', 'Digital Logic', 1),
('MTH112', 'BSC CSIT', 'Mathematics', 1),
('CSC160', 'BSC CSIT', 'Discrete Structures', 2),
('CSC161', 'BSC CSIT', 'Object-Oriented Programming', 2),
('CSC153', 'BSC CSIT', 'Microprocessor', 2),
('MTH163', 'BSC CSIT', 'Mathematics II', 2),
('CSC207', 'BSC CSIT', 'Numerical Method', 3),
('CSC208', 'BSC CSIT', 'Computer Architecture', 3),
('CSC209', 'BSC CSIT', 'Computer Graphics', 3),
('STA210', 'BSC CSIT', 'Statistics', 3),
('CSC258', 'BSC CSIT', 'Computer Networks', 4),
('CSC257', 'BSC CSIT', 'Theory of Computation', 4),
('CSC260', 'BSC CSIT', 'DBMS', 4),
('CSC261', 'BSC CSIT', 'Artificial Intelligence', 4),
('CSC315', 'BSC CSIT', 'System Analysis and Design', 5),
('CSC317', 'BSC CSIT', 'Simulation and Modeling', 5),
('CSC320', 'BSC CSIT', 'Wireless Networking', 5),
('CSC364', 'BSC CSIT', 'Software Engineering', 5),
('CSC371', 'BSC CSIT', 'Automation and Robotics', 5),
('CSC404', 'BSC CSIT', 'Project Work', 6),
('CSC402', 'BSC CSIT', 'Internet Technologies', 6),
('CSC403', 'BSC CSIT', 'Advanced Java Programming', 6),
('CSC458', 'BSC CSIT', 'Cloud Computing', 6),
('CSC455', 'BSC CSIT', 'Network Security', 6);

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE `report` (
  `Student_Id` varchar(200) NOT NULL,
  `Student_Name` varchar(200) NOT NULL,
  `Semester` int(11) NOT NULL,
  `Result` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `report`
--

INSERT INTO `report` (`Student_Id`, `Student_Name`, `Semester`, `Result`) VALUES
('2226153', 'Pritam Dhaugoda', 3, 'You have Passed');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `Student_Id` varchar(200) NOT NULL,
  `Student_Name` varchar(200) NOT NULL,
  `Email` varchar(200) NOT NULL,
  `Course_Name` varchar(200) NOT NULL,
  `module1_name` varchar(200) NOT NULL,
  `module2_name` varchar(200) NOT NULL,
  `module3_name` varchar(200) NOT NULL,
  `module4_name` varchar(200) NOT NULL,
  `semester` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`Student_Id`, `Student_Name`, `Email`, `Course_Name`, `module1_name`, `module2_name`, `module3_name`, `module4_name`, `semester`) VALUES
('2226153', 'Pritam Dhaugoda', 'np03cs4s220160@heraldcollege.edu.np', 'BSC Hons Computer Science', 'Object-Oriented Design and Programming', 'Concepts and Technologies of AI', 'Numerical Methods and Concurrency', 'Data Structure and Algorithm', 3),
('2226144', 'Mohan Khadka', 'np03cs4s215160@heraldcollege.edu.np', 'BSC Hons Computer Science', 'Introductory Programming And Problem Solving', 'Academic Skills and Team-Based Learning', 'Fundamentals of Computing', 'Digital Logic', 1),
('2226189', 'Satyam Redmi', 'np03cs4s220142@heraldcollege.edu.np', 'BSC Hons Computer Science', 'Object-Oriented Design and Programming', 'Concepts and Technologies of AI', 'Numerical Methods and Concurrency', 'Data Structure and Algorithm', 3),
('2220953', 'Ram Shah', 'np03cs4s201630@heraldcollege.edu.np', 'BSC Hons Computer Science', 'Computational Mathematics', 'Internet Software Architecture', 'Embedded System Programming', 'Discrete Structure', 2),
('2228563', 'Rohit Sharma', 'np03cs4s216180@heraldcollege.edu.np', 'BSC Hons Computer Science', 'Project and Professionalism', 'Artificial Intelligence and Machine Learning', 'Complex Systems', 'Compiler Design and Construction', 6),
('2220965', 'Roshan Poudal', 'np03cs4s204264@heraldcollege.edu.np', 'BSC Hons Computer Science', 'Big Data', 'High Performance Computing', 'Multimedia Computing', 'Web Technologies', 5);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Id` varchar(200) NOT NULL,
  `Name` varchar(200) NOT NULL,
  `Address` varchar(200) NOT NULL,
  `Email` varchar(200) NOT NULL,
  `Password` varchar(200) NOT NULL,
  `user` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Id`, `Name`, `Address`, `Email`, `Password`, `user`) VALUES
('2226153', 'Pritam Dhaugoda', 'Chuchepati', 'np03cs4s220160@heraldcollege.edu.np', 'Pritam', 'Student'),
('2000000', 'Admin', 'Naxal', 'npAdmin@heraldcollege.edu.np', 'Admin', 'Admin'),
('210542', 'Aagya Sharma', 'Xaxal', 'npAagya.Sharma@heraldcollege.edu.np', 'Aagya', 'Teacher'),
('2105712', 'Rukesh Shrestha', 'Boudha', 'npRukesh.Shrestha@heraldcollege.edu.np', 'Rukesh', 'Teacher'),
('2067162', 'Simon Giri', 'Kamalpokhari', 'npSimon.Giri@heraldcollege.edu.np', 'Simon', 'Teacher'),
('2073156', 'Ashish Acharya', 'Naxal', 'npAshish.Acharya@heraldcollege.edu.np', 'Ashish', 'Teacher'),
('2201784', 'Raj Pradhan', 'Naxal', 'npRaj.Pradhan@heraldcollege.edu.np', 'Raj', 'Teacher'),
('2301472', 'Anmol Adhikari', 'Kapan', 'npAnmol.Adhikari@heraldcollege.edu.np', 'Anmol', 'Teacher'),
('2226144', 'Mohan Khadka', 'Naxal', 'np03cs4s215160@heraldcollege.edu.np', 'Mohan', 'Student'),
('2220965', 'Roshan Poudal', 'Naxal', 'np03cs4s204264@heraldcollege.edu.np', 'Roshan', 'Student'),
('2226189', 'Satyam Redmi', 'Maitidhevi', 'np03cs4s220142@heraldcollege.edu.np', 'Satyam', 'Student'),
('2220953', 'Ram Shah', 'Kapan', 'np03cs4s201630@heraldcollege.edu.np', 'Ra,', 'Student'),
('2228563', 'Rohit Sharma', 'Mahankal', 'np03cs4s216180@heraldcollege.edu.np', 'Rohit', 'Student'),
('2056934', 'Deepson Shrestha', 'Naxal', 'npDeepson.Shrestha@heraldcollege.edu.np', 'Deepson', 'Teacher');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
