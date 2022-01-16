package com.don.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddrDB {

	// JDBC
	// 1. 접속정보 세팅

	// DBMS 주소
	String url = "jdbc:mysql://localhost:3306/add?serverTimezone=UTC";
	// 인증정보
	String user = "root";
	String pass = "";

	// 드라이버 정보(자바 클래스)
	String driver = "com.mysql.cj.jdbc.Driver";

	private Connection getConnection() {

		Connection conn = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			System.out.println("작업수행 중 오류발생");
		}

		return conn;
	}

	// 데이터를 DB에 저장하는 메서드
	public void insertData() {

		String sql = "INSERT INTO addr SET `name` = '홍길동', address = '서울', phone = '010-1234-1234'";

		Connection conn = getConnection();
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
