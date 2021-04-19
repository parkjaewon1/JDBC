package ch20;
import java.sql.*;
import java.util.Scanner;
public class OraPro1 {
	public static void main(String[] args) throws SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;  CallableStatement cs = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("�μ��ڵ� ?");
		int deptno = Integer.parseInt(sc.nextLine());
		System.out.println("�μ��� ?");
		String dname = sc.nextLine();
		System.out.println("�ٹ��� ?");
		String loc = sc.nextLine();
		String sql = "{call dept_insert(?,?,?)}";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			cs   = conn.prepareCall(sql);
			cs.setInt(1, deptno);  cs.setString(2, dname); cs.setString(3, loc);
			int result = cs.executeUpdate();
			if (result > 0) System.out.println("�Է� ����");
			else System.out.println("�Է� ����");
		}catch (Exception e) { System.out.println("���� : "+e.getMessage());			
		}finally { cs.close(); conn.close(); }
		sc.close();
	}
}