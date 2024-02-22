package Models;

import Models.Helpers.UserCourseConstructor;

import java.io.Serializable;
import java.util.ArrayList;

public class UsersBean implements Serializable {

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPrivilegeType() {
        return privilegeType;
    }
    public void setPrivilegeType(String privilegeType) {
        this.privilegeType = privilegeType;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public boolean isConfirmed() {
        return confirmed;
    }
    public boolean getConfirmed() {
        return confirmed;
    }
    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }



    public ArrayList<String> getAllCoursesId() {
        return allCoursesId;
    }

    public void setAllCoursesId(ArrayList<String> allCoursesId) {
        this.allCoursesId = allCoursesId;
    }

    public ArrayList<String> getAllStudentsId() {
        return allStudentsId;
    }

    public void setAllStudentsId(ArrayList<String> allStudentsId) {
        this.allStudentsId = allStudentsId;
    }

    public ArrayList<UserCourseConstructor> getUserCourses() {
        return userCourses;
    }

    public void setUserCourses(ArrayList<UserCourseConstructor> userCourses) {
        this.userCourses = userCourses;
    }

    private ArrayList<UserCourseConstructor> userCourses;
    private ArrayList<String> allCoursesId;
    private ArrayList<String> allStudentsId;


    public ArrayList<UserCourseConstructor> getAllCourses() {
        return allCourses;
    }

    public void setAllCourses(ArrayList<UserCourseConstructor> allCourses) {
        this.allCourses = allCourses;
    }

    private ArrayList<UserCourseConstructor> allCourses;
    private String id;
    private String privilegeType;
    private String userType;
    boolean confirmed = false;
    public UsersBean(){
    }
}
