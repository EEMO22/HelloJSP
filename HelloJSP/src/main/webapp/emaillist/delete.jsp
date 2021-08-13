<%@page import="com.example.emaillist.dao.EmaillistDAOImpl"%>
<%@page import="com.example.emaillist.dao.EmaillistDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//	파라미터 받기
	Long pk = Long.valueOf(request.getParameter("no"));
	//	DAO 불러오기
	EmaillistDAO dao = new EmaillistDAOImpl();
	//	삭제
	dao.delete(pk);

	
	//	index.jsp로 리다이렉트
	response.sendRedirect(request.getContextPath() + "/emaillist/");
%>
