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
 * Servlet implementation class CheckInsertShopAccountServlet
 */
@WebServlet("/check-insert-shop-account-servlet")
public class CheckInsertShopAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckInsertShopAccountServlet() {
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
		
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		
		if (!session.getAttribute("session_id").equals(null)) {
			
			request.setCharacterEncoding("UTF-8");
			boolean flag = true;

			if (request.getParameter("shop_id").length() <= 0 || request.getParameter("shop_id").length() > 10) {
				flag = false;

			}

			if (request.getParameter("shop_name").length() <= 0 || request.getParameter("shop_id").length() > 32) {
				flag = false;

			}

			if (request.getParameter("shop_password").length() <= 0 || request.getParameter("shop_password").length() > 16) {
				
				flag = false;

			}

			if (!request.getParameter("shop_password").equals(request.getParameter("passcon"))) {
				
				flag = false;

			}

			if (flag) {
				
				rd = request.getRequestDispatcher("CheckInsertShopAccount.jsp");

			} else {
				
				request.setAttribute("shop_name", request.getParameter("shop_name"));
				request.setAttribute("shop_id", request.getParameter("shop_id"));
				request.setAttribute("password", request.getParameter("shop_password"));
				request.setAttribute("passcon", request.getParameter("passcon"));
				rd = request.getRequestDispatcher("InsertShopAccount.jsp");
				request.setAttribute("alert", "入力情報に不備があります。");

			}

		} else {

			rd = request.getRequestDispatcher("Login.jsp");

		}

		rd.forward(request, response);


	}

}
