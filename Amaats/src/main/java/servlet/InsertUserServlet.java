package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.AccountDAO;
import model.entity.UserBean;

/**
 * Servlet implementation class InsertUserServlet
 */
@WebServlet("/insert-user-servlet")
public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUserServlet() {
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
		
		AccountDAO adao = new AccountDAO();
		RequestDispatcher rd;
		
		try {
			
			UserBean ub = new UserBean();
			ub.setUser_id(request.getParameter("user_id"));
			ub.setUser_name(request.getParameter("user_name"));
			ub.setPassword(request.getParameter("password"));
			ub.setUser_address(request.getParameter("user_address"));
			adao.insertNewUser(ub);
			
			rd = request.getRequestDispatcher("InsertUserResult.jsp");
			
		} catch (SQLException e) {
			
			rd = request.getRequestDispatcher("InsertUserResult.jsp");
			request.setAttribute("alert", "データベースの操作に失敗しました。");
			
		} catch (ClassNotFoundException e) {
			
			rd = request.getRequestDispatcher("InsertUserResult.jsp");
			request.setAttribute("alert", "データベースに接続できませんでした。");
			
		}
		
		rd.forward(request, response);
		
	}

}
