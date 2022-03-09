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

    <h2>Ticket</h2>
    <c:if test="${not empty tickets}">
        <table class="table-content">
           <tr>
                <th>ID</th>
                <th>Event ID</th>
                <th>Event Title</th>
                <th>User ID</th>
                <th>User name</th>
                <th>Category</th>
                <th>Place</th>
           </tr>
            <c:forEach var="ticket" items="${tickets}">
                <tr>
                    <td>${ticket.id}</td>
                    <td>${ticket.event.id}</td>
                    <td>${ticket.event.title}</td>
                    <td>${ticket.user.id}</td>
                    <td>${ticket.user.name}</td>
                    <td>${ticket.category}</td>
                    <td>${ticket.place}</td>
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