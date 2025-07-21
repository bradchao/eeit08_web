<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="brad" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Brad Big Company</h1>
		<hr />
		<brad:test1 /><br />
		<brad:test2 /><br />
		<brad:test3 /><br />
		<hr />
		<table width="100%" border="1">
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
			<brad:test4 pname="mouse" price="1000" />
			<brad:test4 pname="ps" price="20,000" />
			<brad:test4 pname="keyboard" price="2000" />
		</table>
	</body>
</html>