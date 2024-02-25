package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoursesModule {
    public static ResultSet coursesId(){
        String sql = "SELECT id\n" +
                "FROM courses\n" +
                "Order BY id";
        try {
            PreparedStatement ps = Database.connect().prepareStatement(sql);
            return  ps.executeQuery();
        }catch (SQLException ex){
            Database.PrintSQLException(ex);
            return null;
        }
    }

    public static ResultSet allCoursesForStudent(String studentId){
        String sql = "SELECT s.id,s.fname,c.course_name,c.YHP,c.description\n" +
                "FROM student_courses sc \n" +
                "JOIN students s ON s.id = sc.student_id\n" +
                "JOIN courses c ON c.id = sc.course_id \n" +
                "WHERE s.id = ?";
        try {
            PreparedStatement ps = Database.connect().prepareStatement(sql);
            ps.setString(1,studentId);
            return ps.executeQuery();
        } catch (SQLException e) {
            Database.PrintSQLException(e);
            return null;
        }
    }

    public static ResultSet allCourses() {
        String sql = "SELECT id ,course_name, YHP, description FROM courses";
        try {
            PreparedStatement ps = Database.connect().prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException e) {
            Database.PrintSQLException(e);
            return null;
        }
    }
}
