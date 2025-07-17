<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c:catch var="err">
			<sql:setDataSource
				driver="com.mysql.cj.jdbc.Driver"
				url="jdbc:mysql://localhost/brad"
				user="root"
				password="root"
			/>
			<sql:update var="n1">
				INSERT INTO cust (cname,tel,birthday) VALUES ('aaa','123','1999-02-03'),
				('aaa','123','1999-02-03'),
				('aaa','123','1999-02-03')
			</sql:update>
		</c:catch>
		${err }<br />
		Insert: ${n1 }<br />
		
	</body>
</html>