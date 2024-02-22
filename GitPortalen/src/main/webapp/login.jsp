<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="Fragments/header.jsp" %>
</head>
<body>
    <div class="container">
        <c:if test="${applicationScope.userBean.privilegeType == ('user')}">
        <%@ include file="Fragments/nav.jsp" %>
        </c:if>

        <c:if test="${applicationScope.userBean.privilegeType == 'admin'}">
            <%@ include file="Fragments/adminNav.jsp" %>
        </c:if>
        <c:if test="${!applicationScope.userBean.confirmed}">
            <div class="text">
                <h1>Login</h1>
            </div>
        </c:if>
        <c:if test="${applicationScope.userBean.confirmed}">
            <div class="text">
                <h1>Logged In!</h1>
            </div>
        </c:if>
        <c:if test="${!applicationScope.userBean.confirmed}">
        <div class="form-cont">
            <form action="${pageContext.request.contextPath}/login" method="POST">
                <%--@declare id="teachstud"--%><label for="teachStud">Teacher or Student:</label><br>
                  <select name="teach_stud" id="teach_stud"><br>
                    <option value="Teacher">teacher</option>
                    <option value="Student">student</option>
                   </select><br>
                <label for="username">Username:</label><br>
                <input type="text" id="username" name="username" required><br>
                <label for="password">Password:</label><br>
                <input type="text" id="password" name="password" required><br>
                <input type="submit" name="login" value="login">
            </form>
        </div>
        </c:if>
        <c:if test="${applicationScope.userBean.confirmed}">
            <div class="form-cont">
                <form action="${pageContext.request.contextPath}/login" method="POST">
                    <button id="logoutBT" value="logout" name="logout" >Logout</button>
                </form>
            </div>
        </c:if>
    </div>
    <%@ include file="Fragments/footer.jsp" %>
</body>
</html>