package Models.Helpers;

import Models.CoursesModule;
import Models.Database;
import Models.StudentsModule;
import Models.UsersBean;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserCoursePackage {

    public static ArrayList<UserCourseConstructor> courses = new ArrayList<>();
    public static ArrayList<String> coursesID = new ArrayList<>();
    public static ArrayList<String> studentsID = new ArrayList<>();
    public static void UserPageInformation(UsersBean usersBean, HttpServletRequest req,String studentId){
        try {
            ResultSet rs = StudentsModule.studentCourseData(studentId);
            courses.clear();
            while (rs.next()){
                String id = rs.getString("id");
                String courseName= rs.getString("course_name");
                String teacherName = rs.getString("teacher");
                String YHP = rs.getString("YHP");
                String description = rs.getString("description");
                UserCourseConstructor course = new UserCourseConstructor(id,courseName,teacherName,YHP,description);
                courses.add(course);
            }
            usersBean.setUserCourses(courses);
            req.setAttribute("courses",courses);
        }catch (SQLException e){
            Database.PrintSQLException(e);
        }
    }
    public static void userBeanIDsInfo (UsersBean userBean){
        coursesID.clear();
        studentsID.clear();
        ResultSet students = StudentsModule.studentsID();
        ResultSet courses = CoursesModule.coursesId();
        try {
            while (students.next()){
                studentsID.add(students.getString("id"));
            }
            while (courses.next()){
                coursesID.add(courses.getString("id"));
            }
            System.out.println(studentsID + " STUD ID");
            System.out.println(coursesID + " COURSE ID");
            userBean.setAllCoursesId(coursesID);
            userBean.setAllStudentsId(studentsID);
        }catch (SQLException ex){

        }

    }
}
