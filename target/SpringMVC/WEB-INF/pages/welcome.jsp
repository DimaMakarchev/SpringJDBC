<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            background-color: #ffc7fd;
        }
    </style>
</head>
<body>
<div>
    <form:form action="/post" method="post">
        <ol>
            <li><form:label path="name">Name :</form:label>
                <form:input path="name"/>
            </li>
            <li><form:label path="address">Address : </form:label>
                <form:textarea path="address"/>
            </li>
            <li>
              <form:label path="man">Man :</form:label>
                <form:checkbox path="man"/>
            </li>
            <li>
                <form:label path="hobby" >Hobby : </form:label>
                <form:checkboxes items="${hobbyList}" path="hobby"/>
            </li>
            <li>
                <form:label path="have">Have : </form:label>
                <form:checkbox path="have"/>
            </li>
            <li>

            <input type="submit" value="Bro"/>

            </li>
        </ol>
    </form:form>


</div>


</body>
</html>
