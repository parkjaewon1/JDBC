package ch20;
import java.sql.*;
import java.util.Scanner;
public class OraSelect2 {
	public static void main(String[] args) throws SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.println("������� �μ����� �ڵ带 �Է��ϼ���");
		int deptno = sc.nextInt();
		String sql = "select * from dept where deptno = "+deptno;
		Connection conn = null;		Statement stmt = null;		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				System.out.println("�μ��ڵ� : "+rs.getInt("deptno"));
				System.out.println("�μ��� : "+rs.getString("dname"));
				System.out.println("�ٹ��� : "+rs.getString("loc"));				
			} else System.out.println("���� �μ��Դϴ�");
		}catch (Exception e) {		System.out.println(e.getMessage());
		}finally {		rs.close(); stmt.close();  conn.close();		}
		sc.close();
	}
}