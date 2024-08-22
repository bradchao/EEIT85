package tw.brad.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class MemberDB {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:mysql://localhost/iii";
	private static final String SQL_CHECK = "SELECT count(account) count FROM member WHERE account = ?";
	private static final String SQL_INSERT = "INSERT INTO member (account,passwd,name) VALUES (?,?,?)";
	
	private Connection conn;
	
	public MemberDB() throws Exception {
		Properties prop = new Properties();
		prop.put("user", USER); prop.put("password", PASSWORD);
		
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(URL, prop);
	}
	
	public boolean isAccountExist(String account) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL_CHECK);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("count") > 0;
		}catch(Exception e) {
			System.out.println("ERROR(1)");
		}
		
		return true;
	}
	
	public boolean addMember(String account, String passwd, String name) {
		return true;
	}
	
	
}
