<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Page</title>
</head>
<body>
<form action="GetResults.do" method=GET>
<input type="text" name="query" placeholder="Enter Query"/>
<input type="submit" value="Submit Query"/>
</form>
<br><hr>

<br><table>
<c:forEach var="row" items="${results}">
<tr>
<c:forEach var="value" items="${row}">
<td>${value}</td>
</c:forEach>
</tr>
</c:forEach>
</table>

</body>
</html>