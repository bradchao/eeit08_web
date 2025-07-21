<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<c:if test="${empty param.account }">
	<c:redirect url="login.html"></c:redirect>
</c:if>
<sql:query var="rs" dataSource="jdbc/mysql">
	SELECT * FROM member WHERE account = ?
	<sql:param>${param.account }</sql:param>
</sql:query>
<c:if test="${rs.rowCount == 0 }">
	<c:redirect url="login.html"></c:redirect>
</c:if>
