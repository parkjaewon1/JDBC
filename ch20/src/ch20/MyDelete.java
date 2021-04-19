package ch20;
import java.sql.*;
import java.util.Scanner;
public class MyDelete {
	public static void main(String[] args) throws SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&serverTimezone=UTC";
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �μ��ڵ� ?");
		String deptno = sc.nextLine();
		Connection conn = null;  PreparedStatement pstmt = null;
		String sql = "delete from dept where deptno=?";
		try{Class.forName(driver);
			conn = DriverManager.getConnection(url,"root","wo1041819");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptno);
			int result = pstmt.executeUpdate();
			if (result > 0) System.out.println("���� �ƾ� ����");
			else System.out.println("������ ���о�");
		}catch (Exception e) {
			System.out.println("���� ���� : "+e.getMessage());
		}finally {		pstmt.close();   conn.close();		}
		sc.close();
	}
}
