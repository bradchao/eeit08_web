<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Object obj = session.getAttribute("x");
	if (obj == null){
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "get out here");
	}
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	I am brad56<hr />
	x = ${x }<br />
	y = ${y }<br />
	z = ${z }<hr />
	a1[2] = ${a1[2] }<hr />		
	Bike = ${b1 }
	<a href="brad57.jsp">Brad57</a>
	</body>
</html>