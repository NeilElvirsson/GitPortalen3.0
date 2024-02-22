<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table-cont">
    <table>
        <tr>
            <th>Course</th>
            <th>YHP</th>
            <th>Description</th>
        </tr>
        <c:forEach items="${applicationScope.userBean.allCourses}" var="course">
            <tr>
                <td>${course.getCourseName()}</td>
                <td>${course.getYHP()}</td>
                <td>${course.getDescription()}</td>
            </tr>
        </c:forEach>

    </table>
</div>