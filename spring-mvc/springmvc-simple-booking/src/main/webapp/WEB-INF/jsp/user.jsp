<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Spring MVC Sample</title>
    <link rel="stylesheet" href="<spring:theme code='styleSheet'/>" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<header id="home" class="header">
    <h2>This is header</h2>
    <div class="nav">
        <a href="home">Home</a>
        <a href="event">Events</a>
        <a href="user">Users</a>
        <a href="ticket">Tickets</a>
    </div>
</header>

<body>
    <h2>User</h2>
    <c:if test="${not empty users}">
        <table class="table-content">
           <tr>
                <th>User ID</th>
                <th>Username</th>
                <th>Email</th>
           </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</body>

<footer class="footer">
    <div class="container">
        <h2>This is footer</h2>
    </div><!-- container -->
</footer><!-- footer -->


</html>