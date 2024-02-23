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
      <div class="text">
                         <h1>Courses</h1>
      </div>
     <%@ include file="Fragments/coursesTable.jsp" %>

    </div>
<%@ include file="Fragments/footer.jsp" %>
</body>
</html>