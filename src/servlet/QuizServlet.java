package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuizServlet
 */
@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List list;
	ResultSet rs;
	QuizSql quizsql;
	GetMaxQuizNum getmaxquiznum;
	private int MAX_QUIZ_NUM;
	String quiz;
	String answer;
	String miss1;
	String miss2;
	String miss3;
	String hint;
	boolean alreadyEmptyFlag;

	public QuizServlet() {
		super();
		quizsql = new QuizSql();
		list = new ArrayList();
		getmaxquiznum = new GetMaxQuizNum();
		setMaxQuizNum();
		for (int i = 1; i <= MAX_QUIZ_NUM; i++) {
			list.add(i);
		}
	}

	public void setMaxQuizNum() {
		int tmpNum = 0;
		ResultSet rss;
		rss = getmaxquiznum.getQuizNum();
		try {
			while(rss.next()) {
				tmpNum = rss.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.MAX_QUIZ_NUM = tmpNum;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("クイズ・開始ッ！！");
		try {
			if (request.getAttribute("retry") != null) {
				if (list.isEmpty()) {
					for (int i = 1; i <= MAX_QUIZ_NUM; i++) {
						list.add(i);
					}
					request.removeAttribute("retry");
					this.alreadyEmptyFlag = false;
				}
			} else if (list.isEmpty()) {
				alreadyEmptyFlag = true;
				// finish.jsp にページ遷移
				RequestDispatcher dispatch = request.getRequestDispatcher("./finish.jsp");
				dispatch.forward(request, response);
			}
			if (!alreadyEmptyFlag) {
				rs = quizsql.getQuizData(getTargetNumber());

				while(rs.next()) {
					quiz = rs.getString(2);
					answer = rs.getString(3);
					miss1 = rs.getString(4);
					miss2 = rs.getString(5);
					miss3 = rs.getString(6);
					hint = rs.getString(7);

					request.setAttribute("quiz", quiz);
					request.setAttribute("answer", answer);
					request.setAttribute("miss1", miss1);
					request.setAttribute("miss2", miss2);
					request.setAttribute("miss3", miss3);
					request.setAttribute("hint", hint);

					// quiz.jsp にページ遷移
					RequestDispatcher dispatch = request.getRequestDispatcher("./quiz.jsp");
					dispatch.forward(request, response);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int getTargetNumber() {
		int num = 0;
		int targetNum = 0;
		Random random = new Random();
		num = random.nextInt(list.size());
		targetNum = (int) list.get(num);

		if (!list.isEmpty()) {
			list.remove(num);
		}
		return targetNum;
	}

}
