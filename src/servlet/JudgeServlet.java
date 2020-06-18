package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JudgeServlet
 */
@WebServlet("/JudgeServlet")
public class JudgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JudgeServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		if (request.getParameter("answer") == null || (request.getParameter("answer").length() == 0)) {
			response.sendRedirect("./miss.jsp");
		} else {
			if (request.getParameter("answer").equals("answer")) {
				response.sendRedirect("./correct.jsp");
			}
			else {
				response.sendRedirect("./miss.jsp");
			}
		}
	}

}
