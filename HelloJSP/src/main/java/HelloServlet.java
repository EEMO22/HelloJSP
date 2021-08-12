import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿은 HttpServlet을 상속
public class HelloServlet extends HttpServlet {

	//	GET 방식의 요청을 처리
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		//	응답의 페이지 타입을 결정
		resp.setContentType("text/html; charset=UTF-8");	//	text인데 html이다. text/CSS -> text인데 CSS이다...등 파일형식
		
		//	파라미터 확인
		String name = req.getParameter("name");
		if (name == null) {
			name = "Anonymous";
		}
		//	응답 출력을 위한 Writer
		PrintWriter out = resp.getWriter();
		out.println("<h3>Hello Servlet</h3>");
		out.println("<p>Welcome, " + name + "</p>");
	
	}

	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		//	페이지 응답 설정
		resp.setContentType("text/html; charset=UTF-8");
		
		//	폼 데이터 받기(파라미터 받기)
		//	input 태그의 name 속성의 이름 -> 서버로 전송했을 때 파라미터에 들어가는 이름 값
		String first_name = req.getParameter("first_name");
		String last_name = req.getParameter("last_name");
		
		PrintWriter out = resp.getWriter();
		out.println("<h3>Form Data</h3>");
		out.println("<p>성: " + last_name + "</p>");
		out.println("<p>이름: " + first_name + "</p>"	);
	}
	
	

}
