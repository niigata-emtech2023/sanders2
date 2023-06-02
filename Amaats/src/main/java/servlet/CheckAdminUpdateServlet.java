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
 * Servlet implementation class CheckSAdminpdateServlet
 */
@WebServlet("/check-admin-update-servlet")
public class CheckAdminUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAdminUpdateServlet() {
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
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String url = null;
		String admin_id = (String) session.getAttribute("session_id");
		AccountDAO adao = new AccountDAO();
		
		if (admin_id != null) {
			
			try {
				
				boolean flag = true;
				
				if (request.getParameter("admin_password").length() > 16 || request.getParameter("admin_password").length() <= 0) {
					
					flag = false;
					
				}
				
				if (flag) {
					url = "UpdateAdminCheck.jsp";
					request.setAttribute("admin_password", request.getParameter("admin_password"));
					request.setAttribute("bean", adao.getAdminAccount(admin_id));
					
				} else {
					
					url = "UpdateAdminAccount.jsp";
					request.setAttribute("alert", "入力情報に不備があります。");
					request.setAttribute("admin_password", request.getParameter("admin_password"));
					request.setAttribute("admin_id", admin_id);
					
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
