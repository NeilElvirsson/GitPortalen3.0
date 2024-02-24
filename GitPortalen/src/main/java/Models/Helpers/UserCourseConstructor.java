package Models.Helpers;

public class UserCourseConstructor {
    public String getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }
    public String getYHP() {
        return YHP;
    }
    public String getDescription() {
        return description;
    }
    private String id;
    private String courseName;
    private String YHP;
    private String description;
    private String teacherName;
    UserCourseConstructor(String id, String courseName, String teacherName,String YHP,String description){
        this.id = id;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.YHP = YHP;
        this.description = description;
    }
    UserCourseConstructor(String id,String courseName, String YHP, String description){
        this.id = id;
        this.courseName = courseName;
        this.YHP = YHP;
        this.description = description;
    }
}
