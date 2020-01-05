<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
    <ol>
        <li>
               <%= request.getAttribute("name")%>
               <% request.getAttribute("address");%>

            <%--
            <% Object have2 = request.getAttribute("have2");
                Object name = request.getAttribute("name");
                System.out.println(have2.toString());
                response.getWriter().write(name + " ");

            %>--%>

        </li>


        <% boolean have = (boolean) request.getAttribute("have");

            if (have) { %>
1
        <li>${name}</li>
        <li>${address}</li>
        <li>${man}</li>
        <li>${hobbyList}</li>
        <li><h1>${cafe}</h1><h1>${code}</h1></li>

        <%} else { %>

        NO))))))))

        <%}%>
    </ol>


</div>


</body>
</html>
