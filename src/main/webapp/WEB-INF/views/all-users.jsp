<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Users</title>
</head>
<body>

<h2>All users</h2>
<br>

<table>
  <tr>
    <th>Name</th>
    <th>Surname</th>
    <th>Phone</th>
    <th>Email</th>
    <th>Operations</th>
  </tr>

  <c:forEach var = "user" items="${allUsers}">

    <c:url var="updateButton" value="/updateUser">
        <c:param name = "userID" value = "${user.id}"/>
    </c:url>

    <c:url var="deleteButton" value="/deleteUser">
      <c:param name = "userID" value = "${user.id}"/>
    </c:url>

    <tr>
      <td>${user.name}</td>
      <td>${user.surname}</td>
      <td>${user.phone}</td>
      <td>${user.email}</td>
      <td>
        <input type="button" value="Update"
               onclick="window.location.href = '${updateButton}'"/>

        <input type="button" value="Delete"
               onclick="window.location.href = '${deleteButton}'"/>
      </td>

    </tr>

  </c:forEach>

</table>

<br><br>

<input type="button" value = "Add"
       onclick="window.location.href = 'addNewUser'"/>
</body>
</html>
