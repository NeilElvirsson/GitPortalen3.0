package Servlets;

import Models.Helpers.*;
import Models.UsersBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/userpage")
public class UserPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersBean userBean = ((UsersBean) getServletConfig().getServletContext().getAttribute("userBean"));
        if (userBean.getId()!=null){
            String studentId = userBean.getId();
            UserCoursePackage.UserPageInformation(userBean,req,studentId);
        }
        req.getRequestDispatcher("userpage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String showMyCourses = req.getParameter("showcourses");
        String showFellowStudents = req.getParameter("showstudents");
        String showStudentCourses = req.getParameter("showStudentCourses");
        String showAllCourses = req.getParameter("allcourses");
        String showAllStudents = req.getParameter("allstudents");
        String showTeachersStudents = req.getParameter("showStudentsTeachers");

        UsersBean userBean = ((UsersBean) getServletConfig().getServletContext().getAttribute("userBean"));
        String studentId;
        if (showMyCourses!=null){
            studentId = userBean.getId();
            studentCourses(userBean,req,studentId);
            req.setAttribute("fellowStudentsBTClick", false);
            req.setAttribute("showMyCoursesBTClick", true);
            req.setAttribute("showStudentCourses",false);
            req.setAttribute("showStudentsTeachers",false);
            req.setAttribute("showAllCourses",false);
            req.setAttribute("showAllStudents",false);
            req.getRequestDispatcher("userpage.jsp").forward(req, resp);
        } else if (showFellowStudents!=null){
            UserStudentsPackage.userPageInformation(req);
            req.setAttribute("fellowStudentsBTClick", true);
            req.setAttribute("showMyCoursesBTClick", false);
            req.setAttribute("showStudentCourses",false);
            req.setAttribute("showStudentsTeachers",false);
            req.setAttribute("showAllCourses",false);
            req.setAttribute("showAllStudents",false);
            req.getRequestDispatcher("userpage.jsp").forward(req, resp);
        } else if (showStudentCourses!=null) {
            studentId = req.getParameter("studentId");
            DisplayStudentCourses.displaySudentCourses(userBean,studentId);
            req.setAttribute("showStudentCourses",true);
            req.setAttribute("showStudentsTeachers",false);
            req.setAttribute("showAllCourses",false);
            req.setAttribute("showAllStudents",false);
            req.getRequestDispatcher("userpage.jsp").forward(req, resp);
        } else if (showAllCourses!=null) {
            DisplayCoursesPackage.DisplayCourses(userBean);
            req.setAttribute("showAllCourses",true);
            req.setAttribute("showStudentsTeachers",false);
            req.setAttribute("showAllStudents",false);
            req.setAttribute("showStudentCourses",false);
            req.getRequestDispatcher("userpage.jsp").forward(req, resp);
        } else if (showAllStudents!=null) {
            DisplayStudentsPacker.displaySudents(userBean);
            req.setAttribute("showAllStudents",true);
            req.setAttribute("showStudentsTeachers",false);
            req.setAttribute("showAllCourses",false);
            req.setAttribute("showStudentCourses",false);
            req.getRequestDispatcher("userpage.jsp").forward(req, resp);
        } else if (showTeachersStudents!=null) {
            String courseId = req.getParameter("courseId");
            DisplayTeacherStudentCourse.displaySudentCourses(userBean,courseId);
            req.setAttribute("showStudentsTeachers",true);
            req.setAttribute("showAllStudents",false);
            req.setAttribute("showAllCourses",false);
            req.setAttribute("showStudentCourses",false);
            req.getRequestDispatcher("userpage.jsp").forward(req, resp);
        }

    }

    public static void studentCourses (UsersBean userBean,HttpServletRequest req, String studentId){
        UserCoursePackage.UserPageInformation(userBean,req,studentId);
    }

}
