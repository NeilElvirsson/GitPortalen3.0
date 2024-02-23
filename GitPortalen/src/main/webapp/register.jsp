<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/CSS/style.css">

    <script>
            function togglePrivilegeFields() {
                var teachStudSelect = document.getElementById("teach_stud");
                var privilegeFields = document.getElementById("privilegeFields");

                if (teachStudSelect.value === "Teacher") {
                    privilegeFields.style.display = "block";
                } else {
                    privilegeFields.style.display = "none";
                }
            }
        </script>

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
            <h1>Register</h1>
        </div>
      <div class="form-cont">
                  <form action="/register" method="POST">
                      <label for="teacher">Choose teacher or student:</label><br>
                        <select name="teach_stud" id="teach_stud" onchange="togglePrivilegeFields()"><br>
                          <option value="Teacher">teacher</option>
                          <option value="Student">student</option>
                         </select><br>

                         <div id="privilegeFields" style="display:student;">
                            <label for="privilage_type">Privilege Type:</label><br>
                            <select name="privilage_type" id="privilegeType">
                                <option value="admin">Admin</option>
                                <option value="user">User</option>
                               </select><br>
                         </div>

                         <label for="fname">First name:</label><br>
                         <input type="text" id="fname" name="fname" required><br>
                         <label for="lname">Last name:</label><br>
                         <input type="text" id="lname" name="lname" required><br>
                         <label for="town">Town:</label><br>
                         <input type="text" id="town" name="town" required><br>
                         <label for="email">Email:</label><br>
                         <input type="text" id="email" name="email" required><br>
                         <label for="phone">Phone:</label><br>
                         <input type="text" id="phone" name="phone" required><br>

                      <label for="username">Username:</label><br>
                      <input type="text" id="username" name="username" required><br>
                      <label for="password">Password:</label><br>
                      <input type="text" id="password" name="password" required><br>
                      <input type="submit" name="Add" value="Add">
                  </form>
              </div>

    </div>
    <%@ include file="Fragments/footer.jsp" %>
</body>
</html>