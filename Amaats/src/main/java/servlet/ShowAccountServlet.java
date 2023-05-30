package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		try {
			
			if (authority.equals("user")) {
				
				rd = request.getRequestDispatcher("UserAccount.jsp");
				
			} else if (authority.equals("shop")) {
				
				rd = request.getRequestDispatcher("ShopAccount.jsp");
				
			} else if (authority.equals("admin")) {
				
				rd = request.getRequestDispatcher("AdminAccount.jsp");
				
			} else {
				
				rd = request.getRequestDispatcher("Login.jsp");
				
			}
			
		} catch (NullPointerException e) {
			
			rd = request.getRequestDispatcher("Login.jsp");
			
		}
		
		rd.forward(request, response);
		
	}

}
