package dbConnector;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class dbConnector {

    // Database Url
    private final String DB_URL = "jdbc:mysql://localhost";
    // Database Username
    private final String USER = "pooa2024";
    //Database Password
    private final String PASSWORD = "pooa2024";
    // XML path for all reports
    private final String[] txtPath = {"CourseReport.txt", "StudentReport.txt", "LecturerReport.txt"};
    // CSV path for all reports
    private final String[] csvPath = {"CourseReport.csv", "StudentReport.csv", "LecturerReport.csv"};

    public void getCourseReport(String outputType) throws SQLException {
        try {
            // Establish connection within database
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            // Use the specific database schema
            stmt.execute("USE cms;");
            // Execute SQL query to retrieve course report data
            ResultSet resultSet = stmt.executeQuery("SELECT c.course_name AS Module,c.course_program AS Program,COUNT(e.student_id) AS Students,CONCAT(l.lecturer_name, ' ', l.lecturer_surname) AS Lecturer, c.course_room AS Room FROM courses c INNER JOIN enrollments e ON c.course_id = e.course_id INNER JOIN lecturers l ON c.lecturer_id = l.lecturer_id GROUP BY c.course_name, c.course_program, l.lecturer_name, l.lecturer_surname, c.course_room;");
            // ArrayList to store retrieved data
            ArrayList<String> data = new ArrayList<>();
            // Iterate through the result set and retrieve data
            while (resultSet.next()) {
                // Retrieve data from each column
                String courseName = resultSet.getString("Module");
                String program = resultSet.getString("Program");
                int students = resultSet.getInt("Students");
                String lecturer = resultSet.getString("Lecturer");
                String room = resultSet.getString("Room");
                // Format and add retrieved data to the ArrayList
                data.add("Module: " + courseName + ", Program: " + program + ", Students enrolled: " + students + ", Lecturer: " + lecturer + ", Room: " + room);
            }
            // Based on the outputType, perform appropriate action
            switch (outputType) {
                case "txt":
                    // Write report to a text file
                    writeReportToTxt(data, 0);
                    break;
                case "csv":
                    // Write report to a CSV file
                    writeReportToCsv(data, 0);
                    break;
                case "console":
                    // Display report in the console
                    displayReportInConsole(data);
                    break;
                default:
                    // Handle invalid output type
                    System.out.println("Invalid output type");
                    break;
            }
            System.out.println("Report sucessfully created");
            // Close the database connection
            conn.close();
        } catch (SQLException e) {
            // Print stack trace in case of an exception
            e.printStackTrace();
        }
    }

    public void getStudentReport(String outputType) throws SQLException {
        try {
            // Establish connection with the database
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            // Use the specific database schema
            stmt.execute("USE cms;");
            // Execute SQL query to retrieve course report data
            ResultSet resultSet = stmt.executeQuery("SELECT CONCAT(s.student_name, ' ', s.student_surname) AS Student,s.student_id AS StudentNumber,c.course_program AS Program,GROUP_CONCAT(DISTINCT c.course_name) AS CurrentModule,GROUP_CONCAT(DISTINCT CONCAT(c.course_name, ': ', g.grade) ORDER BY c.course_name) AS ModuleCompleted,GROUP_CONCAT(DISTINCT CASE WHEN g.grade < 40 THEN c.course_name END) AS ModuleToRepeat FROM students s LEFT JOIN enrollments e ON s.student_id = e.student_id LEFT JOIN courses c ON e.course_id = c.course_id LEFT JOIN grades g ON e.enrollment_id = g.enrollment_id GROUP BY s.student_id, s.student_name, s.student_surname, c.course_program;");
            // ArrayList to store retrieved data
            ArrayList<String> data = new ArrayList<>();
            // Iterate through the result set and retrieve data
            while (resultSet.next()) {
                // Retrieve data from each column
                String student = resultSet.getString("Student");
                int studentsNumber = resultSet.getInt("StudentNumber");
                String program = resultSet.getString("Program");
                String currentModule = resultSet.getString("CurrentModule");
                String moduleCompleted = resultSet.getString("ModuleCompleted");
                String moduleToRepeat = resultSet.getString("ModuleToRepeat");
                // Format and add retrieved data to the ArrayList
                data.add("Student: " + student + ", Student Number: " + studentsNumber + ", Program: " + program + ", Current Module: " + currentModule + ", Module Completed: " + moduleCompleted + ", Module to Repeat: " + moduleToRepeat);
            }
            // Based on the outputType, perform appropriate action
            switch (outputType) {
                case "txt":
                    // Write report to a text file
                    writeReportToTxt(data, 1);
                    break;
                case "csv":
                    // Write report to a CSV file
                    writeReportToCsv(data, 1);
                    break;
                case "console":
                    // Display report in the console
                    displayReportInConsole(data);
                    break;
                default:
                    // Handle invalid output type
                    System.out.println("Invalid output type");
                    break;
            }
            System.out.println("Report sucessfully created");
            // Close the database connection
            conn.close();
        } catch (SQLException e) {
            // Print stack trace in case of an exception
            e.printStackTrace();
        }
    }

    public void getLecturerReport(String outputType) throws SQLException {
        try {
            // Establish connection with the database
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            // Use the specific database schema
            stmt.execute("USE cms;");
            // Execute SQL query to retrieve course report data
            ResultSet resultSet = stmt.executeQuery("SELECT CONCAT(l.lecturer_name, ' ', l.lecturer_surname) AS Lecturer,l.lecturer_role AS LecturerRole,GROUP_CONCAT(DISTINCT c.course_name) AS Modules,COUNT(DISTINCT e.student_id) AS StudentsQuantity,l.lecture_typeOfClasses AS TypeOfClasses FROM lecturers l INNER JOIN courses co ON l.lecturer_id = co.lecturer_id INNER JOIN enrollments e ON co.course_id = e.course_id LEFT JOIN students s ON e.student_id = s.student_id LEFT JOIN grades g ON e.enrollment_id = g.enrollment_id LEFT JOIN courses c ON e.course_id = c.course_id GROUP BY l.lecturer_id, l.lecturer_name, l.lecturer_surname, l.lecturer_role, l.lecture_typeOfClasses;");
            // ArrayList to store retrieved data
            ArrayList<String> data = new ArrayList<>();
            // Iterate through the result set and retrieve data
            while (resultSet.next()) {
                // Retrieve data from each column
                String lecturer = resultSet.getString("Lecturer");
                String lecturerRole = resultSet.getString("LecturerRole");
                String module = resultSet.getString("Modules");
                int studentsQuantity = resultSet.getInt("StudentsQuantity");
                String typeOfClasses = resultSet.getString("TypeOfClasses");
                // Format and add retrieved data to the ArrayList
                data.add("Lecturer Name: " + lecturer + ", Lecturer Role: " + lecturerRole + ", Modules: " + module + ", Student enrolled: " + studentsQuantity + ", Type of Classes " + typeOfClasses);
            }
            // Based on the outputType, perform appropriate action
            switch (outputType) {
                case "txt":
                    // Write report to a text file
                    writeReportToTxt(data, 2);
                    break;
                case "csv":
                    // Write report to a csv file
                    writeReportToCsv(data, 2);
                    break;
                case "console":
                    // Display report in the console
                    displayReportInConsole(data);
                    break;
                default:
                    // Handle invalid output type
                    System.out.println("Invalid output type");
                    break;
            }
            System.out.println("Report sucessfully created");
            // Close the database connection
            conn.close();
        } catch (SQLException e) {
            // Print stack trace in case of an exception
            e.printStackTrace();
        }
    }

    // Method to write report data to a text file
    // Param ArrayList and integer of path
    private void writeReportToTxt(List<String> data, int path) {
        // Delegates writing to a file with specific path
        writeReportToFile(data, txtPath[path]);
    }
// Method to write report data to a csv file
    // Param ArrayList and integer of path

    private void writeReportToCsv(List<String> data, int path) {
        // Delegates writing to a file with specific path
        writeReportToFile(data, csvPath[path]);
    }

    private void writeReportToFile(List<String> data, String filePath) {
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            // Writes each data line to the file
            for (String dataLine : data) {
                bw.write(dataLine);
                bw.newLine();
            }
        } catch (IOException e) {
            //Prints the stack trace if an error occurs
            e.printStackTrace();
        }
    }

    // Displays the report data in the console
// Parameter: data - ArrayList of report data
    private void displayReportInConsole(List<String> data) {
        // Prints each data line to the console
        for (String dataLine : data) {
            System.out.println(dataLine);
        }
    }
}
