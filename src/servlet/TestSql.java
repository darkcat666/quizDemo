package servlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSql {
	StringBuilder sb = new StringBuilder();
	ResultSet rs;
	Statement st;
	Connection conn;
	public Boolean JudgeLogin(String name, String password) {
		try {
			st = DBCPDataSource.getConnection().createStatement();
			rs =  st.executeQuery("select name, password from users where name = '" + name + "' and password = '" + password + "'");

			while(rs.next()) {
				// user・password
				if (((rs.getString(1)) != null) &&
						rs.getString(2) != null) {
					// ログイン成功！
					return true;

				} else {
					// ログイン失敗！
					return false;

				}
			}
		} catch (Exception e) {
			System.out.println("データベース接続エラー"+ e);
		}
		return false;
	}
}
