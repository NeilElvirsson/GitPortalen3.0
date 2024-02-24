package Models.Helpers;

import Models.Database;
import Models.StudentsModule;
import Models.UsersBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DisplayStudentsPacker {
    public static ArrayList<StudentConsturctor> students = new ArrayList<>();
    public static void displaySudents(UsersBean userbean) {
        students.clear();
        ResultSet rs = StudentsModule.students();
        try{
            while (rs.next()){
                String studentFirstName = rs.getString("fname");
                String studentLastName = rs.getString("lname");
                String studentId = rs.getString("id");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String username = rs.getString("username");
                StudentConsturctor student = new StudentConsturctor(studentFirstName,studentLastName,studentId,email,phone,username);
                students.add(student);
            }
            userbean.setAllStudents(students);
        }catch (SQLException e){
            Database.PrintSQLException(e);
        }
    }
}
