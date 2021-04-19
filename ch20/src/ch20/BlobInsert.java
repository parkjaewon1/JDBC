package ch20;
import java.io.*;
import java.sql.*;
public class BlobInsert {
	public static void main(String[] args) throws SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String sql = "insert into test values('a1',?)";
		Connection conn = null;  PreparedStatement pstmt = null;
		try {
			File fileName = new File("ioi.jpg");
			int size = (int)fileName.length();
			InputStream is = new FileInputStream(fileName);
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setBinaryStream(1, is, size);
			int result = pstmt.executeUpdate();
			if (result > 0) System.out.println("�Է� ����");
			else System.out.println("����");
		}catch (Exception e) {	System.out.println("�Է� ���� : "+e.getMessage());
		}finally {		pstmt.close();   conn.close();		}
	}
}