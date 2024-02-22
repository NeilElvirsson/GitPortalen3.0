<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="form-cont">
    <form action="${pageContext.request.contextPath}/userpage" method="POST">
        <%--@declare id="selectstudent"--%><%--@declare id="selectcourse"--%><label for="selectStudent">Select student Id:</label><br>
            <select name="courseId" id="courseId"><br>
                <c:forEach items="${applicationScope.userBean.allStudentsId}" var="studentId">
                    <option value="${studentId}" >${studentId}</option>
                </c:forEach>
            </select><br>
            <label for="selectCourse">Select course Id:</label><br>
            <select name="courseId" id="courseId"><br>
                <c:forEach items="${applicationScope.userBean.allCoursesId}" var="courseId">
                    <option value="${courseId}" >${courseId}</option>
                </c:forEach>
            </select><br>
            <input type="submit" name="allstudents" value="Show All Students">
            <input type="submit" name="allcourses" value="Show All Courses">
            <input type="submit" name="showStudentCourses" value="Show All Courses For a Student">
            <input type="submit" name="showcourses" value="Show All Students and Teachers for a Course">
    </form>
</div>
