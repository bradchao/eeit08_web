<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="tw.brad.apis.Member"></jsp:useBean>
<jsp:setProperty property="account" value='${param.account }' name="member"/>	
<jsp:setProperty property="name" value='${param.name }' name="member"/>	    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Member: <jsp:getProperty property="account" name="member"/> :
				<jsp:getProperty property="name" name="member"/><hr />
		Member: <%= member.getAccount() %> : <%= member.getName() %><hr />
		Member: ${member }<hr />
		Member: ${member.account } | ${member.name }<hr />
		${Math.random() }<br />
		${Math.PI } 		
	</body>
</html>