package Music;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConn {
	static String url ="jdbc:mysql://localhost:3306/music"
			+"?user=root&password=123456"
			+"&characterEncoding=utf-8"
			+"&serverTimezone=Asia/Shanghai&useSSL=false";
	
	public static Connection getConn(){
		try {
			return DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
