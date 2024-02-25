package Models.Helpers;

import Models.CoursesModule;
import Models.Database;
import Models.TeacherModule;
import Models.UsersBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DisplayTeacherStudentCourse {

    public static ArrayList<TeacherStudentCourseConstructor> teachersStudents = new ArrayList<>();
    public static void displaySudentCourses(UsersBean userbean, String courseId) {
        ResultSet rs = TeacherModule.teacherStudentCourse(courseId);
        teachersStudents.clear();
        try{
            while (rs.next()){
                String cId = rs.getString("courseId");
                String courseName = rs.getString("course_name");
                String studentId = rs.getString("studentId");
                String studentFname = rs.getString("studentName");
                String teacherId = rs.getString("teacherId");
                String teacherName = rs.getString("teacherName");
                TeacherStudentCourseConstructor studentTeacher = new TeacherStudentCourseConstructor(cId,courseName,studentId,studentFname,teacherId,teacherName);
                teachersStudents.add(studentTeacher);
            }
            userbean.setTeachersStudents(teachersStudents);
        }catch (SQLException e){
            Database.PrintSQLException(e);
        }
    }
}
