<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table-cont">
    <table>
        <tr>
            <th>Course Id</th>
            <th>Course</th>
            <th>Student Id</th>
            <th>Student Name</th>
            <th>Teacher Id</th>
            <th>Teacher</th>
        </tr>
        <c:forEach items="${applicationScope.userBean.teachersStudents}" var="student">
            <tr>
                <td>${student.getCourseId()}</td>
                <td>${student.getCourseName()}</td>
                <td>${student.getStudentId()}</td>
                <td>${student.getStudentName()}</td>
                <td>${student.getTeacherId()}</td>
                <td>${student.getTeacherName()}</td>
            </tr>
        </c:forEach>
    </table>
</div>