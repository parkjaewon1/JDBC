package ch20;
import java.sql.*;
public class MySelect1 {
	public static void main(String[] args) throws SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&serverTimezone=UTC"
				+ "&allowPublicKeyRetrieval=true&useSSL=false";
		String sql = "select * from dept";
		System.out.println("부서코드\t부서명\t근무지");
		System.out.println("========================");
		Connection conn = null;   Statement stmt = null;  ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "wo1041819");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.print(rs.getInt("deptno")+"\t");
				System.out.print(rs.getString("dname")+"\t");
				System.out.println(rs.getString("loc"));
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			rs.close(); stmt.close(); conn.close();
		}
		System.out.println("========================");
	}
}