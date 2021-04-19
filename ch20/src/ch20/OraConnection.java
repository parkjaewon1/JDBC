package ch20;
import java.sql.*;
public class OraConnection {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		try {
			Class.forName(driver); // driver load
			Connection conn=DriverManager.getConnection(url,"sys as sysdba","1234");
			System.out.println("연결 성공 ㅋㅋ");
			conn.close();
		} catch (Exception e) {
			System.out.println("연결 실패 : "+e.getMessage());
		}
	}
}