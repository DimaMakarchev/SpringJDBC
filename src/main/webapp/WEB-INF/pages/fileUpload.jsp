<%--
  Created by IntelliJ IDEA.
  User: Asus 1
  Date: 25.12.2019
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form:form method="post"  action="/getxxx" modelAttribute="fileUpload" enctype="multipart/form-data">
        <input type="file" name="file"/>
        <input type="submit" value="Bro" style="background-color: #ff5e56;border-radius: 15px"/>
    </form:form>
</div>



</body>
</html>
