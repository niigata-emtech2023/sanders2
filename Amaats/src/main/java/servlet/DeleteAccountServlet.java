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
 * Servlet implementation class DeleteAccountServlet
 */
@WebServlet("/delete-account-servlet")
public class DeleteAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAccountServlet() {
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
		HttpSession session=request.getSession();
		RequestDispatcher rd;
		AccountDAO adao=new AccountDAO();
		
		try {
		
		if(!session.getAttribute("session_id").equals(null)) {
			
			if (request.getParameter("type").equals("shop")) {
				
				String shop_id = request.getParameter("shop_id");
				adao.deleteShop(shop_id);
				
			} else {
				
				String user_id = request.getParameter("user_id");
				adao.deleteUser(user_id);
				
			}
			
			rd = request.getRequestDispatcher("DeleteAccouhntResult.jsp");
			
		}else {
			session.invalidate();
			rd=request.getRequestDispatcher("Login.jsp");
			
		}
		}catch(ClassNotFoundException e) {
			rd=request.getRequestDispatcher("show-delete-user-account-servlet");
		}catch(SQLException e) {
			rd=request.getRequestDispatcher("show-delete-user-account-servlet");
			
		}
		rd.forward(request, response);
	}

}
