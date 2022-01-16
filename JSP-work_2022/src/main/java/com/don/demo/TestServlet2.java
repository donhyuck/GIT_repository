package com.don.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestB")
public class TestServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("TestServlet 2이 실행됩니다.");
		System.out.println("Hello");

		// 클라이언트 브라우저에 응답
		// request -> 요청에 관한 다양한 정보와 기능들이 모여있음. 입력도구
		// response -> 응답에 관한 다양한 정보와 기능들이 모여있음. 출력도구

		// 인코딩 설정
		response.setCharacterEncoding("UTF-8"); // tomcat 에게 "UTF-8 처리해서 보내라"
		response.setContentType("text/html; charset=UTF-8"); // 브라우저에게 내가 보내는 걸 UTF-8로 처리해라
		// text/html : html, text/plain : 일반텍스트

		// 브라우저에 출력(사용자에게 노출)
		PrintWriter out = response.getWriter();
		// 알파벳은 정상적으로 출력된다.
		out.println("<h1>Hello</h1>");
		out.println("<h2>my name is<br></h2>");
		out.println("<h3>TestServlet2<br></h3>");
		out.println("ABCDEFG");
		out.println("<br>");

		// 한글 및 다른 알파벳을 제외한 언어는 인코딩작업이 필요하다.
		// 아스키코드는 알파벳만 존재한다.
		// 특정 문자표를 사용해서 데이터를 다시 문자로 : 인코딩
		// 문자를 데이터로 : 디코딩
		out.println("안녕하세요<br>");
		out.println("가나다라마바사<br>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
