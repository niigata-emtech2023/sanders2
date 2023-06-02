package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.SweetsDAO;
import model.entity.SweetsBean;

/**
 * Servlet implementation class InsertSweetServlet
 */
@WebServlet("/insert-sweets-servlet")
public class InsertSweetsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSweetsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		
		HttpSession session=request.getSession();
		RequestDispatcher rd;
		SweetsDAO sdao=new SweetsDAO();
		
		if(!session.getAttribute("session_id").equals(null)) {
			
			try {
				
				request.setCharacterEncoding("UTF-8");
				
				SweetsBean bean = new SweetsBean();
				
				bean.setSweets_name(request.getParameter("sweets_name"));
				bean.setSweets_value(Integer.parseInt(request.getParameter("sweets_value")));
				bean.setSweets_genre(request.getParameter("sweets_genre"));
				bean.setShop_id((String) session.getAttribute("session_id"));
				bean.setSweets_info(request.getParameter("sweets_info"));
				
				sdao.insertSweets(bean);
				
				request.setAttribute("bean", bean);
				
				rd = request.getRequestDispatcher("SweetsInsertResult.jsp");
				
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				rd =request.getRequestDispatcher("InsertSweets.jsp");
				request.setAttribute("alert", "データベース操作で問題が発生しました");
				
			}
		
		} else {
			
			session.invalidate();
			rd=request.getRequestDispatcher("Login.jsp");
			
		}

		rd.forward(request, response);
		
	}

	
}
