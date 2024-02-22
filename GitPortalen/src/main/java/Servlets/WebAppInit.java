package Servlets;

import Models.PrivilegeType;
import Models.UsersBean;
import com.google.protobuf.StringValue;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebAppInit implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        //event.getServletContext().getServletContextName();
        UsersBean usersBean = new UsersBean();
        usersBean.setPrivilegeType(String.valueOf(PrivilegeType.PRIVILAGE_TYPE.user));
        event.getServletContext().setAttribute("userBean", usersBean);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
