package customer;
import java.sql.*;
public class CustomerDaoImpl {
	private static Connection conn = null;
	public Connection getConnection() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
		}catch (Exception e) {
			System.out.println("���ῡ�� : "+e.getMessage());
		}
		return conn;
	}
	public Customer select(String id) {
		Customer customer = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from customer where id=?";
		Connection conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				customer = new Customer();
				customer.setId(rs.getString("id"));
				customer.setEmail(rs.getString("email"));
				customer.setName(rs.getString("name"));
				customer.setPass(rs.getString("pass"));
				customer.setReg_date(rs.getDate("reg_date"));
			}
		}catch (Exception e) {	System.out.println(e.getMessage());
		}finally {
			try {
				if (rs    != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn  != null) conn.close();
			}catch (Exception e) {	}
		}
		return customer;
	}
	public int insert(Customer customer) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into customer values (?,?,?,?,sysdate)";
		Connection conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customer.getId());
			pstmt.setString(2, customer.getPass());
			pstmt.setString(3, customer.getEmail());
			pstmt.setString(4, customer.getName());
			result = pstmt.executeUpdate();
		}catch (Exception e) {	System.out.println(e.getMessage());
		}finally {
			try {
				if (rs    != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn  != null) conn.close();
			}catch (Exception e) {	}
		}
		return result;
	}
}