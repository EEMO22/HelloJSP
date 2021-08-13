<%@page import="com.example.emaillist.vo.EmailVO"%>
<%@page import="com.example.emaillist.dao.EmaillistDAOImpl"%>
<%@page import="com.example.emaillist.dao.EmaillistDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//	파라미터 받아오기
	String lastName = request.getParameter("last_name");
	String firstName = request.getParameter("first_name");
	String email = request.getParameter("email");
	//	파라미터 확인
	//	DAO
	EmaillistDAO dao = new EmaillistDAOImpl();
	
	//	Vo 객체 생성
	EmailVO vo = new EmailVO();
	vo.setLastName(lastName);
	vo.setFirstName(firstName);
	vo.setEmail(email);
	
	dao.insert(vo);
	
	//	index.jsp로 리다이렉트(페이지 전환: 302)
	response.sendRedirect(request.getContextPath() + "/emaillist/");
%>