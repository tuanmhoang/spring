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

    <h2>Event</h2>
    <c:if test="${not empty events}">
        <table class="table-content">
           <tr>
                <th>Event ID</th>
                <th>Title</th>
                <th>Date</th>
           </tr>
            <c:forEach var="event" items="${events}">
                <tr>
                    <td>${event.id}</td>
                    <td>${event.title}</td>
                    <td>${event.date}</td>
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