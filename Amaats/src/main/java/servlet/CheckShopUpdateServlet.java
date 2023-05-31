package servlet;

import java.io.IOException;

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
 * Servlet implementation class CheckShopUpdate
 */
@WebServlet("/check-shop-update-servlet")
public class CheckShopUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckShopUpdateServlet() {
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
		//doGet(request, response);
		HttpSession session = request.getSession();
		String url = null;
		String shop_id = (String) session.getAttribute("session_id");
		AccountDAO adao = new AccountDAO();
		
		if (shop_id != null) {
			
			try {
				ShopBean sb=new ShopBean();
				
				
				boolean flag = true;
				
				if (request.getParameter("shop_password").length() > 16 || request.getParameter("shop_password").length() <= 0) {
					
					flag = false;
					
				}
				
				if (request.getParameter("shop_name").length() > 32 || request.getParameter("shop_name").length() <= 0) {
					
					flag = false;
					
				}
				
				if (flag) {
					
					sb.setShop_name(request.getParameter("shop_name"));
					sb.setShop_id(request.getParameter("shop_id"));
					sb.setShop_password(request.getParameter("shop_password"));
					sb.setShop_address(request.getParameter("shop_address"));
					sb.setShop_tel(request.getParameter("shop_tel"));
					
					url = "UpdateShopCheck.jsp";
					request.setAttribute("bean", sb);
					
				} else {
					
					url = "UpdateShopAccount.jsp";
					request.setAttribute("alert", "入力情報に不備があります。");
					
				}
			
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			session.invalidate();
			url = "Login.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	
	}

}
