<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table-cont">
    <table>
        <tr>
            <th>Course</th>
            <th>Students</th>
            <th>Student Id</th>
        </tr>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.getCourseName()}</td>
                <td>${student.getStudentName()}</td>
                <td>${student.getStudentId()}</td>
            </tr>
        </c:forEach>

    </table>
</div>
