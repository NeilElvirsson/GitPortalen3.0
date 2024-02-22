package Servlets;

import Models.PrivilegeType;
import Models.StudentsModule;
import Models.TeacherModule;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req,resp);
        //getServletContext().getAttribute("userBean");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String table = req.getParameter("teach_stud");

        String address = "/register";

        if (req.getParameter("Add") != null) {

            if (table.equals("Student")) {

                String fname = req.getParameter("fname");
                String lname = req.getParameter("lname");
                String town = req.getParameter("town");
                String email = req.getParameter("email");
                int phone = Integer.parseInt(req.getParameter("phone"));
                String username = req.getParameter("username");
                String password = req.getParameter("password");


                try {
                    StudentsModule.insertStudent(fname, lname, town, email, phone, username, password);
                    System.out.println(fname + lname + town + email + phone + username + password);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }


            } else if (table.equals("Teacher")) {
                //resp.sendRedirect(address);

                String fname = req.getParameter("fname");
                String lname = req.getParameter("lname");
                String town = req.getParameter("town");
                String email = req.getParameter("email");
                int phone = Integer.parseInt(req.getParameter("phone"));
                String username = req.getParameter("username");
                String password = req.getParameter("password");

                //PrivilegeType.PRIVILAGE_TYPE type = PrivilegeType.PRIVILAGE_TYPE.valueOf((String) req.getAttribute("privilage_type"));

                String privilegeTypeParameter = req.getParameter("privilage_type");
                PrivilegeType.PRIVILAGE_TYPE type = null;

                if (privilegeTypeParameter != null && !privilegeTypeParameter.isEmpty()) {
                    try {
                        type = PrivilegeType.PRIVILAGE_TYPE.valueOf(privilegeTypeParameter);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    }
                }



                try {
                    TeacherModule.insertTeacher(fname, lname, town, email, phone, username, password, type);
                   // System.out.println(fname + lname + town + email + phone + username + password + type);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
               //  address = "/register";
            }
        }

        resp.sendRedirect(address);

    }

}

