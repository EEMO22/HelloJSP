<%@ page language="java" 
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<!-- 동적 페이지 인클루드 -->
<jsp:include page="/WEB-INF/views/includes/header.jsp">
	<jsp:param value="메인 페이지" name="message"/></jsp:include>

	
	<h4>GET 전송</h4>
	<!-- 
	- URL로 데이터 전송
	- 파라미터는 ? 뒤에 파라미터명 = 파라미터값으로 전송
	- 여러 개의 파라미터는 & 로 연결
	 -->
	 <p>
	 	<a href="hs?name=Servlet">HelloServlet 호출</a>
	 </p>
	 
	<h4>POST 전송</h4>
	<!-- 사용자 입력 데이터 전송을 위한 form tag -->
	<form action="hs" method="POST">
		<label for="last_name">성</label>
		<input type="text" name="last_name" id="last_name" /><br />
		<label for="first_name">이름</label>
		<input type="text" name="first_name" id="first_name" /><br />
		
		<input type="submit" value="전송" />
	</form>
	 
	<h4>Emaillist (Model 1)</h4>
	<p><a href="/web/emaillist/">이메일 리스트 (Model 1)</a>
	
	<h4>Emaillist (Model 2:MVC)</h4>
	<p><a href="/web/el">이메일 리스트 (Model 2)</a>
	
	<h4>Cookie Test</h4>
	<p><a href="<%= request.getContextPath() %>/cookies">쿠키 테스트</a>

<!-- 정적 페이지 인클루드 -->
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>