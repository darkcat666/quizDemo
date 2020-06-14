package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ログインID
	 */
	private String user = "";

	/**
	 * パスワード
	 */
	private String password = "";

	/**
	 * TestSqlインスタンス化
	 */
	TestSql testSql = new TestSql();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// セッションスコープに格納
		HttpSession session = request.getSession(true);

		// UTF-8に変換
		request.setCharacterEncoding("UTF-8");

		if (request.getParameter("user") != null) {
			user = request.getParameter("user");
		} else {
			// 処理を中断（元のjspに戻す）
			response.sendRedirect("./login.jsp");
		}

		if (request.getParameter("password") != null) {
			password = request.getParameter("password");
		} else {
			// 処理を中断（元のjspに戻す）
			response.sendRedirect("./login.jsp");
		}

		// セッションスコープに保存(password)
		session.setAttribute("password", password);

		// セッションスコープに保存(user)
		session.setAttribute("user", user);

		// ログイン判定
		Boolean result = testSql.JudgeLogin(user, password);
		if (result == true) {
			// ログイン成功！
			session.setAttribute("isLogin", "true");
			response.sendRedirect("./LoginSuccess");
		} else {
			// ログイン失敗！
			// 処理を中断（元のjspに戻す）
			response.sendRedirect("./login.jsp");
		}
	}
}
