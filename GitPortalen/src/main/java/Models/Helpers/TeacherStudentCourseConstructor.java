package Models.Helpers;

public class TeacherStudentCourseConstructor {
    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    private String courseId;
    private String courseName;
    private String studentId;
    private String studentName;
    private String teacherId;
    private String teacherName;

    TeacherStudentCourseConstructor(String courseId,String courseName,String studentId,String studentName,String teacherId,String teacherName){
        this.courseId = courseId;
        this.courseName = courseName;
        this.studentId = studentId;
        this.studentName = studentName;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
    }
}
