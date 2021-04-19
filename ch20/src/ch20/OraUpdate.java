package ch20;
import java.sql.*;
import java.util.Scanner;
public class OraUpdate {
	public static void main(String[] args) throws SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;    PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �μ��ڵ� ?");
		int deptno = Integer.parseInt(sc.nextLine());
		System.out.println("������ �� ?");
		String dname = sc.nextLine();
		System.out.println("������ �ٹ��� ?");
		String loc = sc.nextLine();
		String sql = "update dept set dname=?,loc=? where deptno=?";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt  = conn.prepareStatement(sql); // ���⼭ sql			
			pstmt.setString(1, dname); // ù���� ?���� dname
			pstmt.setString(2, loc);   // �ι��� ?���� loc
			pstmt.setInt(3, deptno);   // ����° ?���� deptno 
			int result = pstmt.executeUpdate();  // ����� sql�� ����
			if (result > 0) System.out.println("��������");
			else System.out.println("���� ����");
		}catch (Exception e) { System.out.println("���� ���� : "+e.getMessage());
		}finally { pstmt.close();  conn.close(); 		}	
		sc.close();
	}
}