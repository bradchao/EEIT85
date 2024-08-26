<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty member.account }">
	<c:redirect url="login.jsp"></c:redirect>
</c:if>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<sql:setDataSource
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost/iii"
	user="root"
	password="root"
	/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	Welcome, ${member.name }
	<a href="logout.jsp">Logout</a>
	<a href="addMember.jsp">Add Member</a>
	<hr />
	<table border="1" width="100%">
		<tr>
			<th>ID</th>
			<th>Account</th>
			<th>Name</th>
		</tr>
		<sql:query var="rs">
			SELECT * FROM member
		</sql:query>
		<c:forEach var="row" items="${rs.rows }">
			<tr>
				<td>${row.id }</td>
				<td>${row.account }</td>
				<td>${row.name }</td>
			</tr>
		</c:forEach>
		
	</table>
	
	
	
		
	</body>
</html>