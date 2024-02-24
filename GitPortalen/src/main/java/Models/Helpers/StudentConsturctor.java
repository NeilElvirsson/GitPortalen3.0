package Models.Helpers;

public class StudentConsturctor {
    public String getStudentFirstName() {
        return studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    private String studentFirstName;
    private String studentLastName;
    private String studentId;
    private String email;
    private String phone;
    private String username;
    StudentConsturctor(String studentName,String studentLastName, String studentId,String email,String phone,String username){
        this.studentFirstName = studentName;
        this.studentLastName = studentLastName;
        this.studentId = studentId;
        this.email = email;
        this.phone = phone;
        this.username = username;
    }
}
