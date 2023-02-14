<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>User-Info</title>
</head>
<body>
<h2>User-Info</h2>
<br>

<form:form action="saveNewUser" modelAttribute="user">

  <form:hidden path="id"/>

  Name <form:input path="name"/>
  <br><br>
  Surname <form:input path="surname"/>
  <br><br>
  Phone <form:input path="phone"/>
  <form:errors path="phone"/>
  <br><br>
  Email <form:input path="email"/>
  <br><br>

  <input type="submit" value="OK">

</form:form>

</body>
</html>
