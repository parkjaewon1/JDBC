package ch20;
import java.sql.*;
import java.util.Scanner;
public class OraDelete {
	public static void main(String[] args) throws SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null; Statement stmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �μ��ڵ� ?");
		int deptno = sc.nextInt();
		String sql = "delete from dept where deptno="+deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			if (result > 0) System.out.println("���� �Ƴ�");
			else System.out.println("��ȿ !! ���о�");
		}catch (Exception e) {
			System.out.println("���� ���� : "+e.getMessage());
		}finally {	stmt.close(); conn.close();		}
		sc.close();
	}
}
