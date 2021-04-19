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
		System.out.println("������� ������ ����� �Է��ϼ���");
		int empno = sc.nextInt();
		String sql = "select * from emp where empno = "+empno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "wo1041819");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println("========================");
				System.out.println("��� : "+rs.getInt("empno"));  // empno �ڸ��� 1�� �־�ȴ�.
				System.out.println("�̸� : "+rs.getString("ename")); // ���������� 2�� �־�ȴ�.
				System.out.println("���� : "+rs.getString("job"));   
				System.out.println("������ ��� : "+rs.getInt("mgr")); 
				System.out.println("�Ի��� : "+rs.getDate("hiredate"));
				System.out.println("�޿� : "+rs.getInt("sal"));
				System.out.println("comm : "+rs.getInt("comm"));
				System.out.println("�μ��ڵ� : "+rs.getInt("deptno"));  // 8�� �־ ���� ���� ���´�.
			}else
				System.out.println("���� �����Դϴ�");
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