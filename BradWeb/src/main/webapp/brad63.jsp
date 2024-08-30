<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String account = (String)session.getAttribute("account");

	if (account == null){
		response.sendRedirect("brad61.html");
	}

%>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	Wecome, ${account }<br />
	<a href="signout.jsp">Sign out</a>
	</body>
</html>