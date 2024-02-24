package Servlets;

import Models.Helpers.DisplayCoursesPackage;
import Models.Helpers.DisplayStudentsPacker;
import Models.Helpers.UserCoursePackage;
import Models.Helpers.UserStudentsPackage;
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
        UsersBean userBean = ((UsersBean) getServletConfig().getServletContext().getAttribute("userBean"));
        String studentId;
        if (showMyCourses!=null){
            studentId = userBean.getId();
            studentCourses(userBean,req,studentId);
            req.setAttribute("fellowStudentsBTClick", false);
            req.setAttribute("showMyCoursesBTClick", true);
            req.getRequestDispatcher("userpage.jsp").forward(req, resp);
        } else if (showFellowStudents!=null){
            UserStudentsPackage.userPageInformation(req);

            req.setAttribute("fellowStudentsBTClick", true);
            req.setAttribute("showMyCoursesBTClick", false);
            req.getRequestDispatcher("userpage.jsp").forward(req, resp);
        } else if (showStudentCourses!=null) {

        } else if (showAllCourses!=null) {
            DisplayCoursesPackage.DisplayCourses(userBean);
            req.setAttribute("showAllCourses",true);
            req.setAttribute("showAllStudents",false);
            req.getRequestDispatcher("userpage.jsp").forward(req, resp);
        } else if (showAllStudents!=null) {
            DisplayStudentsPacker.displaySudents(userBean);
            req.setAttribute("showAllStudents",true);
            req.setAttribute("showAllCourses",false);
            req.getRequestDispatcher("userpage.jsp").forward(req, resp);
        }

    }

    public static void studentCourses (UsersBean userBean,HttpServletRequest req, String studentId){
        UserCoursePackage.UserPageInformation(userBean,req,studentId);
    }

}
