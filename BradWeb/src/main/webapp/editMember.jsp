<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.mindrot.*" %>  
<%@page import="java.util.Base64"%> 
<%@page import="tw.brad.apis.Member"%>
<%@page import="javax.servlet.jsp.jstl.sql.Result"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%
	request.setCharacterEncoding("UTF-8");
%>    
<c:if test="${empty member.account }">
	<c:redirect url="login.jsp"></c:redirect>
</c:if>
<sql:setDataSource
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost/iii"
	user="root"
	password="root"
	/> 	
<c:if test="${!empty param.editid }">
	<sql:query var="rs">
		SELECT * FROM member WHERE id = ?
		<sql:param>${param.editid }</sql:param>
	</sql:query>
	<c:if test="${rs.rowCount == 0 }"><c:redirect url="main.jsp"></c:redirect></c:if>
	
	<%
		Result rs = (Result)pageContext.getAttribute("rs");
		long id = (Long)rs.getRows()[0].get("id");
		String account = (String)rs.getRows()[0].get("account");
		String passwd = (String)rs.getRows()[0].get("passwd");
		String name = (String)rs.getRows()[0].get("name");
		byte[] icon = (byte[])rs.getRows()[0].get("icon");
		String iconBase64 = Base64.getEncoder().encodeToString(icon);
		
		Member member = new Member();
		member.setId((int)id);
		member.setAccount(account);
		member.setPasswd(passwd);
		member.setName(name);
		member.setIcon(iconBase64);
		
		session.setAttribute("edidMember", member);
	%>	
	
	
</c:if>

<c:if test="${!empty param.account }">
	<c:if test="${pageContext.request.method != 'POST' }"><c:redirect url="logout.jsp"></c:redirect></c:if>
	<sql:update>
		UPDATE member SET account=?,passwd=?,name=? WHERE id = ?
		<sql:param>${param.account }</sql:param>
		<sql:param>${BCrypt.hashpw(param.passwd, BCrypt.gensalt()) }</sql:param>
		<sql:param>${param.name }</sql:param>
		<sql:param>${param.id }</sql:param>
	</sql:update>
	<c:redirect url="main.jsp"></c:redirect>		
</c:if>	 
	
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	Edit Member Page
	<hr />
	<form method="post">
		<input type="hidden" name="id" value="${edidMember.id }">
		Account: <input name="account" value="${edidMember.account }" /><br />
		Password: <input type="password" name="passwd" /><br />
		Name:<input name="name" value="${edidMember.name }" /><br />
		Icon: <img src="data:image/png; base64, ${edidMember.icon }" /><br />
		<input type="submit" value="Update" />
	</form>		
	</body>
</html>