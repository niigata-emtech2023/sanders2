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
 * Servlet implementation class DeleteSweetsServlet
 */
@WebServlet("/delete-sweets-servlet")
public class DeleteSweetsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSweetsServlet() {
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
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		RequestDispatcher rd;
		SweetsDAO sdao=new SweetsDAO();
		
		try {
		
		if(!session.getAttribute("session_id").equals(null)) {
			SweetsBean sweetsbean = new SweetsBean();
			sweetsbean.setSweets_id(Integer.parseInt(request.getParameter("sweets_id")));
			sweetsbean.setSweets_name(request.getParameter("sweets_name"));
			sweetsbean.setSweets_value(Integer.parseInt(request.getParameter("sweets_value")));
			sweetsbean.setSweets_genre(request.getParameter("sweets_genre"));
			sweetsbean.setSweets_info(request.getParameter("sweets_info"));
			sdao.deleteSweets(sweetsbean);
			
			rd = request.getRequestDispatcher("DeleteSweetsResult.jsp");
			
		}else {
			session.invalidate();
			rd=request.getRequestDispatcher("Login.jsp");
			
		}
		}catch(ClassNotFoundException e) {
			rd=request.getRequestDispatcher("DeleteSweets.jsp");
		}catch(SQLException e) {
			rd=request.getRequestDispatcher("DeleteSweets.jsp");
			
		}
		rd.forward(request, response);
		
	}

}
