<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//request.getLocale().getDisplayLanguage();
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Method: ${pageContext.request.method }<br />
		Locale: ${pageContext.request.locale }<br />
		Language: ${pageContext.request.locale.displayLanguage }<br />
		Language: ${pageContext.request.locale.language }<br />
	</body>
</html>