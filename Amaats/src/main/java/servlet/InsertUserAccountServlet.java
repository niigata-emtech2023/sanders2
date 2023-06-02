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
@WebServlet("/insert-user-account-servlet")
public class InsertUserAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUserAccountServlet() {
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
		
		request.setCharacterEncoding("UTF-8");
		AccountDAO adao = new AccountDAO();
		RequestDispatcher rd;
		boolean flag = true;
		
		try {
			
			if (request.getParameter("user_id").length() > 10 || request.getParameter("user_id").length() <= 0) {
				flag = false;
			}
			if (request.getParameter("user_name").length() > 32 || request.getParameter("user_name").length() <= 0) {
				flag = false;
			}
			if (request.getParameter("password").length() > 16 || request.getParameter("password").length() <= 0) {
				flag = false;
			}
			if (request.getParameter("user_address").length() > 10 || request.getParameter("user_address").length() <= 0 ) {
				flag = false;
			}
			if (!request.getParameter("password").equals(request.getParameter("passcon"))) {
				flag = false;
			}
			
			if (flag) {
				UserBean ub = new UserBean();
				ub.setUser_id(request.getParameter("user_id"));
				ub.setUser_name(request.getParameter("user_name"));
				ub.setPassword(request.getParameter("password"));
				ub.setUser_address(request.getParameter("user_address"));
				
				adao.insertNewUser(ub);
				rd = request.getRequestDispatcher("InsertUserAccountResult.jsp");
			} else {
				request.setAttribute("alert", "入力内容に不備があります。");
				request.setAttribute("user_id", request.getParameter("user_id"));
				request.setAttribute("user_name", request.getParameter("user_name"));
				request.setAttribute("password", request.getParameter("password"));
				request.setAttribute("passcon", request.getParameter("passcon"));
				request.setAttribute("user_address", request.getParameter("user_address"));
				rd = request.getRequestDispatcher("InsertUserAccount.jsp");
			}
			
				
			
		} catch (SQLException e) {
			
			rd = request.getRequestDispatcher("InsertUserAccount.jsp");
			request.setAttribute("alert", "データベースの操作に失敗しました。");
			
		} catch (ClassNotFoundException e) {
			
			rd = request.getRequestDispatcher("InsertUserAccount.jsp");
			request.setAttribute("alert", "データベースに接続できませんでした。");
			
		}
		
		rd.forward(request, response);
		
	}

}
