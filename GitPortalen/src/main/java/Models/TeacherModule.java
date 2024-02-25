package Models;

import java.sql.*;

public class TeacherModule {

    public static ResultSet checkTeacher (String username){
        String sql = "SELECT username, password, id, privilage_type FROM teachers WHERE username = ?";
        try {
            PreparedStatement ps = Database.connect().prepareStatement(sql);
            ps.setString(1,username);
            return ps.executeQuery();
        } catch (SQLException e) {
            Database.PrintSQLException(e);
            return null;
        }
    }

    public static ResultSet teacherStudentCourse(String courseId){
        String sql = "SELECT c.id as courseId,c.course_name,s.id as studentId,s.fname as studentName,t.id as teacherId,t.fname as teacherName\n" +
                "FROM students s  \n" +
                "LEFT JOIN student_courses sc \n" +
                "ON s.id = sc.student_id\n" +
                "LEFT JOIN courses c \n" +
                "ON c.id = sc.course_id \n" +
                "LEFT JOIN teacher_courses tc \n" +
                "ON c.id = tc.course_id\n" +
                "LEFT JOIN teachers t \n" +
                "ON t.id = tc.teacher_id \n" +
                "WHERE c.id = ? \n" +
                "GROUP by s.id";
        try {
            PreparedStatement ps = Database.connect().prepareStatement(sql);
            ps.setString(1,courseId);
            return ps.executeQuery();
        } catch (SQLException e) {
            Database.PrintSQLException(e);
            return null;
        }
    }

    public static String insertTeacher(String fname, String lname, String town, String email, int phone, String username, String password, PrivilegeType.PRIVILAGE_TYPE type) {
        System.out.println(fname + lname);
        String insertSuccessfull;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:13306/gritacademyportal", "root", "");

            String query = "Insert INTO teachers (fname, lname, town, email, phone, username, password, privilage_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, fname);
                pstmt.setString(2, lname);
                pstmt.setString(3, town);
                pstmt.setString(4, email);
                pstmt.setInt(5, phone);
                pstmt.setString(6, username);
                pstmt.setString(7, password);
                pstmt.setObject(8, type.name());



                insertSuccessfull = "Insert successful";

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Insert successful");
                } else {
                    System.out.println("Insert failed");
                }
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            throw new RuntimeException("Error inserting teacher: " + e.getMessage(), e);

        }
        return insertSuccessfull;
    }
}
