package common;

import java.sql.Statement;

import javax.servlet.ServletContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBConnect {
	public Connection con; //db 와 연결
	public Statement stmt; // 인파라미터가 없는 정적 쿼리문 실행
	public PreparedStatement psmt; // 매개변수 전달된 값을 설정
	public ResultSet rs; // select쿼리문의결과를 저장
	
	public JDBConnect() {
		try {
			// 1번째 JDBC 드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");
			
			//DB에 연결
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "musthave";
			String pwd = "1234";
			con = DriverManager.getConnection(url,id,pwd);
			
			System.out.println("DB 연결 성공(기본 생성자)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if (rs!=null) rs.close();
			if (stmt != null) stmt.close();
			if (psmt!=null) psmt.close();
			if (con!=null) con.close();
			System.out.println("JDBC 자원 해제");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 2번째 web.xml 에서  옴긴것들 생성자를 jdbconnect 클래스에 추가
	public JDBConnect(String driver, String url, String id, String pwd) {
		try {
			Class.forName(driver);
			
			//DB 연결
			con = DriverManager.getConnection(url,id,pwd);
			System.out.println("DB 연결 성공(인수 생성자 1)");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 3번째 접속 정보
	public JDBConnect(ServletContext application) {
		try {
			String driver = application.getInitParameter("OracleDriver");
			Class.forName(driver);
			
			String url = application.getInitParameter("OracleURL");
			String id = application.getInitParameter("OracleId");
			String pwd = application.getInitParameter("OraclePwd");
			con = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("DB 연결 성공(인수 생성자 2)");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
