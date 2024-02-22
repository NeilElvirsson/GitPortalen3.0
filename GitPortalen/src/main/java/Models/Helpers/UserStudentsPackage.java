package Models.Helpers;

import Models.Database;
import Models.StudentsModule;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class UserStudentsPackage {
  private static  ArrayList<UserStudentsConstructor> students = new ArrayList<>();
    public static void userPageInformation(HttpServletRequest req){
        String courseId = req.getParameter("courseId");
        System.out.println(courseId);
       ResultSet rs =  StudentsModule.fellowStudentsData(courseId);
       students.clear();
       try{
           while (rs.next()){
               String courseName = rs.getString("course_name");
               String studentName = rs.getString("fname");
               String studentId = rs.getString("id");
               UserStudentsConstructor student = new UserStudentsConstructor(courseName,studentName,studentId);
               students.add(student);
           }
           req.setAttribute("students",students);
       }catch (SQLException ex){
           Database.PrintSQLException(ex);
       }
    }
}
