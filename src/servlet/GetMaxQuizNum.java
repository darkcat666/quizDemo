package servlet;

import java.sql.ResultSet;
import java.sql.Statement;

public class GetMaxQuizNum {
	ResultSet rs;
	Statement st;

	public ResultSet getQuizNum() {
		try {
			st = DBCPDataSource.getConnection().createStatement();
			rs =  st.executeQuery("select count(id) from quiz");
		}catch(Exception e) {
			// 何もしない
			e.printStackTrace();
		}
		return rs;
	}
}
