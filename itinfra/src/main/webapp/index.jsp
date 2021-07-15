<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
	if(session.getAttribute("sessionId") == null) {
%>
		<jsp:forward page="/login.do"/>
<%
	} else {
%>
		<jsp:forward page="/groupCode.do"/>
<%
	}
%>