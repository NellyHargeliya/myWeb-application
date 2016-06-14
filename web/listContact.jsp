<%--
  Created by IntelliJ IDEA.
  User: Nelly
  Date: 12.06.2016
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Page Contact</title>
</head>
<body>
<h1>Список контактов!</h1>
<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Login</th>
        <th>E-mail</th>
        <th>Phone Number</th>
    </tr>
    <c:forEach var="contact" items="${contactList}">
        <tr>
            <td>${contact.name}</td>
            <td>${contact.surname}</td>
            <td>${contact.login}</td>
            <td>${contact.email}</td>
            <td>${contact.phoneNumber}</td>
        </tr>
    </c:forEach>
</table>

<c:if test="${currentPage!=1}">
    <td><a href="contact.do?page=${currentPage-1}">Previous</a></td>
</c:if>

<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <td>${i}</td>
                </c:when>
                <c:otherwise>
                    <td><a href="contact.do?page=${i}">${i}</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
</table>

<c:if test="${currentPage lt noOfPages}">
    <td><a href="contact.do?page=${currentPage + 1}">Next</a></td>
</c:if>

<div id="sortTable" class="Contact">

    <h3>SORT TABLE</h3>
    <display:table name="contactList" export="false" sort="list" pagesize="5" uid="two">
        <display:column property="name" title="Name" sortable="true" sortName="name"/>
        <display:column property="surname" sortable="true" sortName="surname" title="Surname"/>
        <display:column property="login" sortable="true" sortName="login" title="Login"/>
        <display:column property="email" sortable="true" sortName="email" title="E-mail"/>
        <display:column property="phoneNumber" sortable="true" sortName="phoneNumber" title="Phone Number"/>
    </display:table>

</body>
</html>
