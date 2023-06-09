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

/**
 * Servlet implementation class ShowDeleteAccountServlet
 */
@WebServlet("/show-delete-user-account-servlet")
public class ShowDeleteUserAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDeleteUserAccountServlet() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		String url = null;
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("session_id");
		
		if (user_id != null) {
			try {
				AccountDAO adao = new AccountDAO();
				request.setAttribute("userList", adao.getUserList());
				request.setAttribute("shopList", adao.getShopList());
				url = "DeleteAccount.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			url = "Login.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
