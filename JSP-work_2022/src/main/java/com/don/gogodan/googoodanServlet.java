package com.don.gogodan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Testdan")
public class googoodanServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("googoodanServlet이 실행됩니다.");
		System.out.println("Hello");

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		String sdan = request.getParameter("dan"); // 요청받음
		int dan = Integer.parseInt(sdan);

		String sgop = request.getParameter("gop");
		int gop = Integer.parseInt(sgop);

		// 1. 클라이언트가 서버에게 데이터를 보내는 법 (요청할때 같이 보내야 함)
		// => 요청주소?보낼데이터
		// key = value
		// ex) dan = 3, gop = 100
		// http://localhost:9100/JSP-work/gogodan?dan=3

		// 2. 들어온 요청을 처리해야함
		// 고객이 넘긴 데이터 == 요청 파라미터
		// -> 요청 파라미터를 꺼내는 법 == request.getParameter() 사용(String반환됨)

		// 3.보낼 데이터가 2개 이상일 때
		// & 로 구분한다.
		// http://localhost:9100/JSP-work/Testdan?dan=3&gop=100
		// 이를 query, queryString 이라고 함.

		out.println("<h2>구구단</h2>"); // 들어온 요청처리
		out.printf("<h3>=== %d단 ===</h3>", dan);

		for (int i = 1; i <= gop; i++) {
			out.printf("%d * %d = %d<br>", dan, i, dan * i);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
