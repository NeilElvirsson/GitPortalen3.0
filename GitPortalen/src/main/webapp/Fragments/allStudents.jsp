<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table-cont">
    <table>
        <tr>
            <th>Student Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Username</th>
            <th>Email</th>
            <th>Phone</th>
        </tr>
        <c:forEach items="${applicationScope.userBean.allStudents}" var="student">
            <tr>
                <td>${student.getStudentId()}</td>
                <td>${student.getStudentFirstName()}</td>
                <td>${student.getStudentLastName()}</td>
                <td>${student.getUsername()}</td>
                <td>${student.getEmail()}</td>
                <td>${student.getPhone()}</td>
            </tr>
        </c:forEach>

    </table>
</div>