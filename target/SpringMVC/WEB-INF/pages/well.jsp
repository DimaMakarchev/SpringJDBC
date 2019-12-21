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
       <h1><form:label path="name">Name Bro</form:label>
           <form:input path="name"/></h1>
       <h1><form:label path="code">Name Bro</form:label>
           <form:input path="code"/></h1>
        <input type="submit" value="BRO"/>
    </form:form>


</div>


</body>
</html>
