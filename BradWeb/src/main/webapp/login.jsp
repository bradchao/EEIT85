<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	Login Page
	<hr />
	<form action="checkAccount.jsp" method="post">
		Account: <input name="account" /><br />
		Password: <input type="password" name="passwd" /><br />
		<input type="submit" value="Login" />
	</form>	
	</body>
</html>