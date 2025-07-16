package tw.brad.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDB {
	private static final String URL = "jdbc:mysql://localhost/brad";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String checkSQL = "SELECT count(account) count FROM member WHERE account = ?";
	private static final String addSQL = "INSERT INTO member (account,passwd,name) VALUES (?,?,?)";
	
	private Connection conn;
	
	public MemberDB() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	public boolean isAccountExist(String account) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(checkSQL);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("count") != 0;
		}catch(Exception e) {
			System.out.println(e);
			return true;
		}
	}
	
	public boolean addMember(String account, String passwd, String name) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(addSQL);
			pstmt.setString(1, account);
			pstmt.setString(2, BCrypt.hashpw(passwd, BCrypt.gensalt()));
			pstmt.setString(3, name);
			return pstmt.executeUpdate() > 0;
		}catch(Exception e) {
			System.out.println(e);
			return true;
		}
	}
	
}
