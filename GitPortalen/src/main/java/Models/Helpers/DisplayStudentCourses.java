package Models.Helpers;

import Models.CoursesModule;
import Models.Database;
import Models.StudentsModule;
import Models.UsersBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DisplayStudentCourses {

    public static ArrayList<StudentCoursesConstructor> studentCourses = new ArrayList<>();
    public static void displaySudentCourses(UsersBean userbean,String studentId) {
        ResultSet rs = CoursesModule.allCoursesForStudent(studentId);
        studentCourses.clear();
        try{
            while (rs.next()){
                String id = rs.getString("id");
                String fname = rs.getString("fname");
                String courseName = rs.getString("course_name");
                String YHP = rs.getString("YHP");
                String description = rs.getString("description");
                StudentCoursesConstructor course = new StudentCoursesConstructor(id,fname,courseName,YHP,description);
                studentCourses.add(course);
                System.out.println(course.getStudentId() + " " + course.getStudentFname());
            }
            userbean.setStudentCourses(studentCourses);
        }catch (SQLException e){
            Database.PrintSQLException(e);
        }
    }

}
