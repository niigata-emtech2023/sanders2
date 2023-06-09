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
import model.entity.AdminBean;

/**
 * Servlet implementation class UpdateAdminAccountServlet
 */
@WebServlet("/update-admin-account-servlet")
public class UpdateAdminAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminAccountServlet() {
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
		AdminBean ab = new AdminBean();
		RequestDispatcher rd;
		
		ab.setAdmin_id(request.getParameter("admin_id"));
		ab.setAdmin_password(request.getParameter("admin_password"));
		
		try {
			
			adao.UpdateAdmin(ab);
			
			rd = request.getRequestDispatcher("UpdateAccountResult.jsp");
			
		} catch (SQLException e) {
			
			e.printStackTrace();

			rd = request.getRequestDispatcher("show-account-servlet");
			request.setAttribute("alert", "データベースの操作が完了できませんでした。");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
			rd = request.getRequestDispatcher("show-account-servlet");
			request.setAttribute("alert", "データベースに接続できませんでした。");
		}
		
		rd.forward(request, response);
	}

}
