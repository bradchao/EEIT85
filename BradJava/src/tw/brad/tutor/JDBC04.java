package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

public class JDBC04 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://127.0.0.1:3306/brad";
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try(Connection conn = DriverManager.getConnection(url, prop)){
			String name = "Amy";
			String tel = "1234567";
			String birthday = "1999-03-04";
			int id = 4;
			String sql = "UPDATE cust SET name = ?, tel = ?, birthday = ? WHERE id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			pstmt.setString(3, birthday);
			pstmt.setInt(4, id);
			
			pstmt.executeUpdate();
			System.out.println("OK");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
