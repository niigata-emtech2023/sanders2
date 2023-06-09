package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.SweetsBean;

/**
 * 確認画面に遷移
 */
@WebServlet("/show-update-sweets-servlet")
public class ShowUpdateSweetsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowUpdateSweetsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		SweetsBean sb = new SweetsBean();
		
		sb.setSweets_id(Integer.parseInt(request.getParameter("sweets_id")));
		sb.setSweets_name(request.getParameter("sweets_name"));
		sb.setSweets_genre(request.getParameter("sweets_genre"));
		sb.setSweets_value(Integer.parseInt(request.getParameter("sweets_value")));
		sb.setSweets_info(request.getParameter("sweets_info"));
		sb.setPath(request.getParameter("path"));
		
		RequestDispatcher rd = request.getRequestDispatcher("UpdateSweetsForm.jsp");
		request.setAttribute("bean", sb);
		rd.forward(request, response);
	}

}
