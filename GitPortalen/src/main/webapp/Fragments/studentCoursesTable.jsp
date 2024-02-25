<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table-cont">
    <table>
        <tr>
            <th>Student Id</th>
            <th>First Name</th>
            <th>Course</th>
            <th>YHP</th>
            <th>Description</th>
        </tr>
        <c:forEach items="${applicationScope.userBean.studentCourses}" var="student">
            <tr>
                <td>${student.getStudentId()}</td>
                <td>${student.getStudentFname()}</td>
                <td>${student.getCourseName()}</td>
                <td>${student.getYHP()}</td>
                <td>${student.getDescription()}</td>
            </tr>
        </c:forEach>
    </table>
</div>