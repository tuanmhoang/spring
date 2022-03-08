<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Spring MVC Sample</title>
    <link rel="stylesheet" href="css/style.css" type="text/css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<header id="home" class="header">
    <h2>This is header</h2>
    <div class="nav">
        <a href="/ticket">Home</a>
        <a href="/event">Event</a>
        <a href="/user">User</a>
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

    <h2>Ticket</h2>
    <c:if test="${not empty tickets}">
        <table class="table-content">
           <tr>
                <th>ID</th>
                <th>Event ID</th>
                <th>User ID</th>
                <th>Category</th>
                <th>Place</th>
           </tr>
            <c:forEach var="ticket" items="${tickets}">
                <tr>
                    <td>${ticket.id}</td>
                    <td>${ticket.event.id}</td>
                    <td>${ticket.user.id}</td>
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