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

import model.dao.AccountDAO;

/**
 * Servlet implementation class ShowAccountServlet
 */
@WebServlet("/show-account-servlet")
public class ShowAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAccountServlet() {
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
		
		HttpSession session = request.getSession();
		String authority = (String) session.getAttribute("authority");
		RequestDispatcher rd;
		AccountDAO adao = new AccountDAO();
		
		try {
			
			if (authority.equals("user")) {
				
				rd = request.getRequestDispatcher("UserAccount.jsp");
				request.setAttribute("bean", adao.getUserAccount((String) session.getAttribute("session_id")));
				
			} else if (authority.equals("shop")) {
				
				rd = request.getRequestDispatcher("ShopAccount.jsp");
				request.setAttribute("bean", adao.getShopAccount((String) session.getAttribute("session_id")));
				
			} else if (authority.equals("admin")) {
				
				rd = request.getRequestDispatcher("AdminAccount.jsp");
				request.setAttribute("bean", adao.getAdminAccount((String) session.getAttribute("session_id")));
				
			} else {
				
				rd = request.getRequestDispatcher("Login.jsp");
				
			}
			
		} catch (NullPointerException e) {
			
			rd = request.getRequestDispatcher("Login.jsp");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			rd = request.getRequestDispatcher("show-sweets-list-servlet");
			
		}
		
		rd.forward(request, response);
		
	}

}
