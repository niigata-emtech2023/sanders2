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
import model.entity.ShopBean;

/**
 * Servlet implementation class InsertShopAccountServlet
 */
@WebServlet("/insert-shop-account-servlet")
public class InsertShopAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertShopAccountServlet() {
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
			AccountDAO adao = new AccountDAO();
			ShopBean sb = new ShopBean();
			
			try {
				
				sb.setShop_id(request.getParameter("shop_id"));
				sb.setShop_name(request.getParameter("shop_id"));
				sb.setShop_password(request.getParameter("shop_id"));
				
				adao.insertNewShop(sb);
				
				rd = request.getRequestDispatcher("InsertShopAccountResult.jsp");
				
			} catch (SQLException | ClassNotFoundException e) {
				
				rd = request.getRequestDispatcher("InsertShopAccount.jsp");
				request.setAttribute("alert", "データベースの操作を完了できませんでした。");
				
			}
			
		} else {
			
			rd = request.getRequestDispatcher("Login.jsp");
			
		}
		
		rd.forward(request, response);
		
	}

}
