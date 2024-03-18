
package dbConnector;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class dbConnector {
    // Database Url
    private final String DB_URL = "jdbc:mysql://localhost";
    // Database Username
    private final String USER = "root";
    //Database Password
    private final String PASSWORD = "Tuesday06062023";
    // XML path for all reports
    private final String[] txtPath = {"CourseReport.txt","StudentReport.txt","LecturerReport.txt"};
    // CSV path for all reports
    private final String[] csvPath = {"CourseReport.csv","StudentReport.csv","LecturerReport.csv"};
    
    //Database Creation Method if needed
    public void createDB(){
        try {
            // Establish connection within database
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE DATABASE IF NOT EXISTS cms;");
            System.out.println("Database sucessfully created;");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    public void getCourseReport(String outputType){
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            stmt.execute("USE cms;");
            ResultSet resultSet = stmt.executeQuery("SELECT c.course_name AS Module,c.course_program AS Program,COUNT(e.student_id) AS Students,CONCAT(l.lecturer_name, ' ', l.lecturer_surname) AS Lecturer, c.course_room AS Room FROM courses c INNER JOIN enrollments e ON c.course_id = e.course_id INNER JOIN lecturers l ON c.lecturer_id = l.lecturer_id GROUP BY c.course_name, c.course_program, l.lecturer_name, l.lecturer_surname, c.course_room;");
            ArrayList<String> data = new ArrayList<>();
            while (resultSet.next()) {
                    // Creating variables for every column in the table
                    String courseName = resultSet.getString("Module");
                    String program = resultSet.getString("Program");
                    int students = resultSet.getInt("Students");
                    String lecturer = resultSet.getString("Lecturer");
                    String room = resultSet.getString("Room");
                    data.add("Module: " + courseName + ", Program: " + program + ", Students enrolled: "+ students + ", Lecturer: " + lecturer + ", Room: " + room);
            }
            switch(outputType){
                case "txt":
                    try{
                        BufferedWriter bw = new BufferedWriter(new FileWriter(txtPath[0]));
                        for(String dataLine : data){
                            bw.write(dataLine);
                            bw.newLine();
                        }
                        bw.close();
                        break;
                    }catch(Exception e){
                        System.out.println(e);
                    }
                case "csv":
                    try{
                        BufferedWriter bw = new BufferedWriter(new FileWriter(csvPath[0]));
                        for(String dataLine : data){
                            bw.write(dataLine);
                            bw.newLine();
                        }
                        bw.close();
                        break;
                    }catch(Exception e){
                        System.out.println(e);
                    }
                case "console":
                    //Displaying all data in console
                    for(String dataLine : data){
                        System.out.println(dataLine);
                    }
                    break;
                default:
                    break;
            }
            System.out.println("Report sucessfully created");
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void getStudentReport(String outputType){
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            stmt.execute("USE cms;");
            ResultSet resultSet = stmt.executeQuery("SELECT CONCAT(s.student_name, ' ', s.student_surname) AS Student,s.student_id AS StudentNumber,c.course_program AS Program,GROUP_CONCAT(DISTINCT c.course_name) AS CurrentModule,GROUP_CONCAT(DISTINCT CONCAT(c.course_name, ': ', g.grade) ORDER BY c.course_name) AS ModuleCompleted,GROUP_CONCAT(DISTINCT CASE WHEN g.grade < 40 THEN c.course_name END) AS ModuleToRepeat FROM students s LEFT JOIN enrollments e ON s.student_id = e.student_id LEFT JOIN courses c ON e.course_id = c.course_id LEFT JOIN grades g ON e.enrollment_id = g.enrollment_id GROUP BY s.student_id, s.student_name, s.student_surname, c.course_program;");
            ArrayList<String> data = new ArrayList<>();
            while (resultSet.next()) {
                    // Creating variables for every column in the table
                    String student = resultSet.getString("Student");
                    int studentsNumber = resultSet.getInt("StudentNumber");
                    String program = resultSet.getString("Program");
                    String currentModule = resultSet.getString("CurrentModule");
                    String moduleCompleted = resultSet.getString("ModuleCompleted");
                    String moduleToRepeat = resultSet.getString("ModuleToRepeat");
                    data.add("Student: " + student + ", Student Number: " + studentsNumber + ", Program: " + program + ", Current Module: "+ currentModule + ", Module Completed: " + moduleCompleted + ", Module to Repeat: " + moduleToRepeat);
            }
            switch(outputType){
                case "txt":
                    try{
                        BufferedWriter bw = new BufferedWriter(new FileWriter(txtPath[1]));
                        for(String dataLine : data){
                            bw.write(dataLine);
                            bw.newLine();
                        }
                        bw.close();
                        break;
                    }catch(Exception e){
                        System.out.println(e);
                    }
                case "csv":
                    try{
                        BufferedWriter bw = new BufferedWriter(new FileWriter(csvPath[1]));
                        for(String dataLine : data){
                            bw.write(dataLine);
                            bw.newLine();
                        }
                        bw.close();
                        break;
                    }catch(Exception e){
                        System.out.println(e);
                    }
                case "console":
                    //Displaying all data in console
                    for(String dataLine : data){
                        System.out.println(dataLine);
                    }
                    break;
                default:
                    break;
            }
            System.out.println("Report sucessfully created");
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void getLecturerReport(String outputType){
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            stmt.execute("USE cms;");
            ResultSet resultSet = stmt.executeQuery("SELECT CONCAT(l.lecturer_name, ' ', l.lecturer_surname) AS Lecturer,l.lecturer_role AS LecturerRole,GROUP_CONCAT(DISTINCT c.course_name) AS Modules,COUNT(DISTINCT e.student_id) AS StudentsQuantity,l.lecture_typeOfClasses AS TypeOfClasses FROM lecturers l INNER JOIN courses co ON l.lecturer_id = co.lecturer_id INNER JOIN enrollments e ON co.course_id = e.course_id LEFT JOIN students s ON e.student_id = s.student_id LEFT JOIN grades g ON e.enrollment_id = g.enrollment_id LEFT JOIN courses c ON e.course_id = c.course_id GROUP BY l.lecturer_id, l.lecturer_name, l.lecturer_surname, l.lecturer_role, l.lecture_typeOfClasses;");
            ArrayList<String> data = new ArrayList<>();
            while (resultSet.next()) {
                    // Creating variables for every column in the table
                    String lecturer = resultSet.getString("Lecturer");
                    String lecturerRole = resultSet.getString("LecturerRole");
                    String module = resultSet.getString("Modules");
                    int studentsQuantity = resultSet.getInt("StudentsQuantity");
                    String typeOfClasses = resultSet.getString("TypeOfClasses");
                    data.add("Lecturer Name: " + lecturer + ", Lecturer Role: " + lecturerRole + ", Modules: " + module + ", Student enrolled: "+ studentsQuantity + ", Type of Classes " + typeOfClasses);
            }
            switch(outputType){
                case "txt":
                    try{
                        BufferedWriter bw = new BufferedWriter(new FileWriter(txtPath[2]));
                        for(String dataLine : data){
                            bw.write(dataLine);
                            bw.newLine();
                        }
                        bw.close();
                        break;
                    }catch(Exception e){
                        System.out.println(e);
                    }
                case "csv":
                    try{
                        BufferedWriter bw = new BufferedWriter(new FileWriter(csvPath[2]));
                        for(String dataLine : data){
                            bw.write(dataLine);
                            bw.newLine();
                        }
                        bw.close();
                        break;
                    }catch(Exception e){
                        System.out.println(e);
                    }
                case "console":
                    //Displaying all data in console
                    for(String dataLine : data){
                        System.out.println(dataLine);
                    }
                    break;
                default:
                    break;
            }
            System.out.println("Report sucessfully created");
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
