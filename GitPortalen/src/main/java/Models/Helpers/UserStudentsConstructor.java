package Models.Helpers;

public class UserStudentsConstructor {
    public String getCourseName() {
        return courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    private String courseName;
    private String studentName;
    private String studentId;

    UserStudentsConstructor(String courseName, String studentName, String studentId){
        this.courseName = courseName;
        this.studentName = studentName;
        this.studentId = studentId;
    }
}
