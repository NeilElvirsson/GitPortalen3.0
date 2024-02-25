package Models.Helpers;

public class StudentCoursesConstructor {
    public String getStudentId() {
        return studentId;
    }

    public String getStudentFname() {
        return studentFname;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getYHP() {
        return YHP;
    }

    public String getDescription() {
        return description;
    }

    private String studentId;
    private String studentFname;
    private String courseName;
    private String YHP;
    private String description;
    StudentCoursesConstructor(String studentId, String studentFname, String courseName, String YHP, String description){
        this.studentId = studentId;
        this.studentFname = studentFname;
        this.courseName = courseName;
        this.YHP = YHP;
        this.description = description;
    }
}
