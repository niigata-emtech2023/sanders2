package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.AccountDAO;
import model.entity.UserBean;

/**
 * Servlet implementation class CheckUpdateUserAccountServlet
 */
@WebServlet("/check-update-user-account-servlet")
public class UpdateUserAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserAccountServlet() {
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
		UserBean ub = new UserBean();
		
		ub.setUser_id(request.getParameter("user_id"));
		ub.setUser_name(request.getParameter("user_name"));
		ub.setPassword(request.getParameter("password"));
		ub.setUser_genre(request.getParameter("user_genre"));
		ub.setUser_address(request.getParameter("user_address"));
		
		try {
			
			adao.UpdateUser(ub);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
