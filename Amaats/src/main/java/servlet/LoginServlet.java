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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		
		try {
			
			if (adao.login(request.getParameter("id"), request.getParameter("password"))) {
				
				session.setAttribute("session_id", request.getParameter("id"));
				session.setAttribute("authority", "user");
				rd = request.getRequestDispatcher("show-sweets-list-servlet");
				
			} else {
				
				System.out.println("not in user");
				throw new SQLException();
				
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			try {
				
				if (adao.loginShop(request.getParameter("id"), request.getParameter("password"))) {
					
					session.setAttribute("session_id", request.getParameter("id"));
					session.setAttribute("authority", "shop");
					rd = request.getRequestDispatcher("show-sweets-list-servlet");
					
				} else {
					
					System.out.println("not in shop");
					throw new SQLException();
					
				}
				
			} catch (SQLException e2) {
				e2.printStackTrace();
				try {
					
					if (adao.loginAdmin(request.getParameter("id"), request.getParameter("password"))) {
						
						session.setAttribute("session_id", request.getParameter("id"));
						session.setAttribute("authority", "admin");
						rd = request.getRequestDispatcher("show-sweets-list-servlet");
						
					} else {
						
						System.out.println("not in admin");
						throw new SQLException();
						
					}
					
				} catch (SQLException e3) {
					e3.printStackTrace();
					rd = request.getRequestDispatcher("Login.jsp");
					request.setAttribute("alert", "ログインIDまたはパスワードが間違っています。");
					
				} catch (ClassNotFoundException e3) {
					
					rd = request.getRequestDispatcher("Login.jsp");
					request.setAttribute("alert", "データベースにアクセスできませんでした。");
					
				}
				
			} catch (ClassNotFoundException e2) {
				
				rd = request.getRequestDispatcher("Login.jsp");
				request.setAttribute("alert", "データベースにアクセスできませんでした。");
				
			}

			
		} catch (ClassNotFoundException e1) {
			
			rd = request.getRequestDispatcher("Login.jsp");
			request.setAttribute("alert", "データベースにアクセスできませんでした。");
			
		}
		
		rd.forward(request, response);
		
	}

}
