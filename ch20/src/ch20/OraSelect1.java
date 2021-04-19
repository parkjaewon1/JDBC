package ch20;
import java.sql.*;
public class OraSelect1 {
	public static void main(String[] args) throws SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;  // DB����
		Statement stmt = null;   // sql������ �����ϴ� ��ü
		ResultSet rs = null;     // ��ȸ ����� �����ϴ� ��ü
		String sql = "select * from dept";
		try {
		 	Class.forName(driver); // driver load
			conn = DriverManager.getConnection(url, "scott","tiger"); // db����
			stmt = conn.createStatement();  // ����� DB�� sql������ ��ü ����
			rs = stmt.executeQuery(sql);    // sql�� �����ϰ� �� ����� rs�� ����
			while(rs.next()) { // ���� ������ �д� ��� �����Ͱ� ������ ����, ������ ����
				System.out.println("�μ��ڵ� : "+rs.getInt("deptno") );
				System.out.println("�μ��� : "+rs.getString("dname") );
				System.out.println("�ٹ��� : "+rs.getString("loc") );
				System.out.println("==========================");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			rs.close();  stmt.close(); conn.close();
		}
	}
}