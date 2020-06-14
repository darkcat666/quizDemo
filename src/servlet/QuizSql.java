package servlet;

import java.sql.ResultSet;
import java.sql.Statement;

public class QuizSql {
	ResultSet rs;
	Statement st;

	public ResultSet getQuizData(int targetId) {
		   try {
			   st = DBCPDataSource.getConnection().createStatement();
			   rs =  st.executeQuery("select id, question, answer, miss1, miss2, miss3, hint from quiz where id = '" + targetId + "'");
		   }catch(Exception e) {
			   // 何もしない
			   e.printStackTrace();
		   }
	       return rs;
	}
}
