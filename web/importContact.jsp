<%--
  Created by IntelliJ IDEA.
  User: Nelly
  Date: 12.06.2016
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>

<h3>Введите данные для импорта:</h3>
<form name="frm" >

    <input type="file" name="csvFile"  />

    <jsp:useBean id="mybean" scope="session" class="mypackage.CSVRead" />
    <jsp:setProperty name="mybean" property="csvFile" />

</form>

<form action="ContactServlet" method="doPost">
    <input type="submit" value="Выполнить"/>
</form>



</body>
</html>
