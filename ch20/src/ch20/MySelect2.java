package ch20;

import java.sql.*;
import java.util.Scanner;

public class MySelect2 {
	public static void main(String[] args) throws SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&serverTimezone=UTC"
				+ "&allowPublicKeyRetrieval=true&useSSL=false";
	
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
	
		Scanner sc = new Scanner(System.in);
		System.out.println("보고싶은 직원의 사번을 입력하세요");
		int empno = sc.nextInt();
		String sql = "select * from emp where empno = "+empno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "wo1041819");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println("========================");
				System.out.println("사번 : "+rs.getInt("empno"));  // empno 자리에 1을 넣어도된다.
				System.out.println("이름 : "+rs.getString("ename")); // 마찬가지로 2를 넣어도된다.
				System.out.println("업무 : "+rs.getString("job"));   
				System.out.println("관리자 사번 : "+rs.getInt("mgr")); 
				System.out.println("입사일 : "+rs.getDate("hiredate"));
				System.out.println("급여 : "+rs.getInt("sal"));
				System.out.println("comm : "+rs.getInt("comm"));
				System.out.println("부서코드 : "+rs.getInt("deptno"));  // 8을 넣어도 같은 값이 나온다.
			}else
				System.out.println("없는 직원입니다");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		System.out.println("========================");
	}
}