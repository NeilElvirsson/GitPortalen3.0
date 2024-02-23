package Servlets;

import Models.*;
import Models.Helpers.DisplayCoursesPackage;
import Models.Helpers.UserCoursePackage;
import Models.Helpers.UserStudentsPackage;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.RescaleOp;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "login", urlPatterns = "/login")
public class LogInServlet extends HttpServlet {
/*
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        cleanBean();
    }


 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //saves what table to use in sql question
        String table = req.getParameter("teach_stud");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //Querie for information on student/teacher
        //if the user is a student then send username to student module, student module returns a resultset with
        if (req.getParameter("login")!=null) {
            if (table.equals("Student")) {
                ResultSet rs = StudentsModule.checkStudent(username);
                checkLogin(rs, username, password, resp, req, table);
            } else {
                ResultSet rs = TeacherModule.checkTeacher(username);
                checkLogin(rs, username, password, resp, req, table);
            }
        } else if (req.getParameter("logout")!=null) {
            cleanBean();
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    public void checkLogin(ResultSet rs, String username, String password, HttpServletResponse resp, HttpServletRequest req,String table)throws ServletException, IOException {
        try {
            rs.next();
            String foundUsername = rs.getString("username");
            String foundPassword = rs.getString("password");
            if (foundUsername.equals(username) && foundPassword.equals(password)) {
                UsersBean userBean = ((UsersBean) getServletConfig().getServletContext().getAttribute("userBean"));
                userBean.setConfirmed(true);
                userBean.setId(rs.getString("id"));
                if (table.equals("Student")){
                    userBean.setUserType(String.valueOf(UserType.USER_TYPE.student));
                    userBean.setPrivilegeType(String.valueOf(PrivilegeType.PRIVILAGE_TYPE.user));
                }else{
                    userBean.setUserType(String.valueOf(UserType.USER_TYPE.teacher));
                    if (rs.getString("privilage_type").equals("admin")){
                        userBean.setPrivilegeType(String.valueOf(PrivilegeType.PRIVILAGE_TYPE.admin));
                    }else {
                        userBean.setPrivilegeType(String.valueOf(PrivilegeType.PRIVILAGE_TYPE.user));
                    }
                }
                getServletContext().setAttribute("userBean", userBean);
                DisplayCoursesPackage.DisplayCourses(userBean);
                UserCoursePackage.userBeanIDsInfo(userBean);
                req.getRequestDispatcher("userpage.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } catch (SQLException ex) {
            Database.PrintSQLException(ex);
        }
    }
    public void cleanBean(){
        UsersBean userBean = new UsersBean();
        userBean.setPrivilegeType(String.valueOf(PrivilegeType.PRIVILAGE_TYPE.user));
        getServletConfig().getServletContext().setAttribute("userBean",userBean);
    }
}
