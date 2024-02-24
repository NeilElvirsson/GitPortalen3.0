package Models.Helpers;

import Models.CoursesModule;
import Models.Database;
import Models.StudentsModule;
import Models.UsersBean;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DisplayCoursesPackage {
    public static ArrayList<UserCourseConstructor> courses = new ArrayList<>();


    public static void DisplayCourses (UsersBean usersBean){

        try {
            ResultSet rs = CoursesModule.allCourses();
            courses.clear();
            while (rs.next()){
                String courseId = rs.getString("id");
                String courseName= rs.getString("course_name");
                String YHP = rs.getString("YHP");
                String description = rs.getString("description");
                UserCourseConstructor course = new UserCourseConstructor(courseId,courseName, YHP,description);
                courses.add(course);
            }

            usersBean.setAllCourses(courses);
        }catch (SQLException e){
            Database.PrintSQLException(e);
        }
    }
}
