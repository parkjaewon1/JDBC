package ch20;
import java.sql.*;
import java.util.Scanner;
public class MyInsert {
	public static void main(String[] args) throws SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&serverTimezone=UTC";
		Connection conn = null;  Statement stmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("�μ��ڵ� ?");
		String deptno = sc.nextLine();
		System.out.println("�μ��� ?");
		String dname = sc.nextLine();
		System.out.println("�ٹ��� ?");
		String loc = sc.nextLine();
		String sql = String.format("insert into dept values (%s,'%s','%s')",deptno, dname,loc);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"root","wo1041819");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			if (result > 0) System.out.println("�Է� ����");
			else System.out.println("�Է� ����");
		}catch (Exception e) { System.out.println("�Է� ���� : "+ e.getMessage());
		}finally {	stmt.close(); conn.close();		}
		sc.close();
	}
}