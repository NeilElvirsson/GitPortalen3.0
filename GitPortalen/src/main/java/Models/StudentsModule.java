package Models;

import Models.Database;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;

public class StudentsModule {
    public static ResultSet checkStudent (String username){
        String sql = "SELECT username,password,id FROM students WHERE username = ?";
        try {
            PreparedStatement ps = Database.connect().prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            Database.PrintSQLException(e);
            return null;
        }
    }
    public static ResultSet students (){
        String sql = "SELECT id,username,fname,lname,email,phone FROM students;";
        try {
            PreparedStatement ps = Database.connect().prepareStatement(sql);
            return  ps.executeQuery();
        }catch (SQLException ex){
            Database.PrintSQLException(ex);
            return null;
        }
    }

    public static ResultSet getStudent(){
        String sql = "";
        try {
            PreparedStatement ps = Database.connect().prepareStatement(sql);
            return ps.executeQuery();
        }catch (SQLException e){
            Database.PrintSQLException(e);
            return null;
        }
    }

    public static ResultSet studentCourseData(String studentId){
        String sql = "SELECT s.fname,c.YHP,c.description,c.id,c.course_name, IFNULL(GROUP_CONCAT(t.fname SEPARATOR ', '), '') as teacher \n" +
                "FROM students s  \n" +
                "LEFT JOIN student_courses sc \n" +
                "ON s.id = sc.student_id\n" +
                "LEFT JOIN courses c \n" +
                "ON c.id = sc.course_id \n" +
                "LEFT JOIN teacher_courses tc \n" +
                "ON c.id = tc.course_id\n" +
                "LEFT JOIN teachers t \n" +
                "ON t.id = tc.teacher_id \n" +
                "WHERE s.id = ?  \n" +
                "GROUP by c.id;";
        try {
            PreparedStatement ps = Database.connect().prepareStatement(sql);
            ps.setString(1,studentId);
            return ps.executeQuery();
        }catch (SQLException e){
            Database.PrintSQLException(e);
            return null;
        }
    }

    public static ResultSet fellowStudentsData(String courseId){
        String sql = "SELECT c.course_name,s.fname,s.id\n" +
                "FROM student_courses sc \n" +
                "LEFT JOIN students s ON s.id = sc.student_id\n" +
                "LEFT JOIN courses c ON c.id = sc.course_id\n" +
                "WHERE c.id = ?;";
        try {
            PreparedStatement ps = Database.connect().prepareStatement(sql);
            ps.setString(1,courseId);
            return ps.executeQuery();
        }catch (SQLException e){
            Database.PrintSQLException(e);
            return null;
        }
    }
    public static ResultSet studentsID (){
        String sql = "SELECT students.id \n" +
                "FROM students\n" +
                "Order BY students.id";
        try {
            PreparedStatement ps = Database.connect().prepareStatement(sql);
            return  ps.executeQuery();
        }catch (SQLException ex){
            Database.PrintSQLException(ex);
            return null;
        }
    }

    public static String insertStudent(String fname, String lname, String town, String email, int phone, String username, String password) {
        System.out.println(fname + lname);
        String insertSuccessfull;
        try {
            /*
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:13306/gritacademyportal", "root", "");
*/
            String query = "Insert INTO students (fname, lname, town, email, phone, username, password) VALUES (?, ?, ?, ?, ?, ?, ?)";



            Connection con = Database.adminConnect();
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, fname);
                pstmt.setString(2, lname);
                pstmt.setString(3, town);
                pstmt.setString(4, email);
                pstmt.setInt(5, phone);
                pstmt.setString(6, username);
                pstmt.setString(7, password);

                insertSuccessfull = "Insert successful";

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Insert successful");
                } else {
                    System.out.println("Insert failed");
                }
            }

            con.close();
        } catch (SQLException e) {
           Database.PrintSQLException(e);
            return null;
        }
        return insertSuccessfull;
    }
}