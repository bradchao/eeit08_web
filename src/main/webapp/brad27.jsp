<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String x = request.getParameter("x");
	String y = request.getParameter("y");
	Integer lottery = (Integer)request.getAttribute("lottery");
%>
		I am Brad27<hr />
		x = <%= x %><br />
		x = <%= y %><br />
		Lottery = <%= lottery %>
