package servlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBCPDataSource {
	ResultSet rs;
	static Statement st;
	static Connection conn;
	public static Connection getConnection() {
	   try {
		Class.forName("com.mysql.jdbc.Driver");
		   conn = DriverManager.getConnection(
		           "jdbc:mysql://localhost/chibi_crm","root", "");
		   st = conn.createStatement();
	   } catch(Exception e) {
		   // 何もしない
		   e.printStackTrace();
	   }
	return conn;
	}
}