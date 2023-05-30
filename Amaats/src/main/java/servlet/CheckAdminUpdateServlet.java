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
import model.entity.AdminBean;

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
		
		String url = null;
		String admin_id = request.getParameter("admin_id");
		
		AccountDAO dao = new AccountDAO();
		
		if (admin_id != null) {
			try {
			AdminBean admin = dao.selectAdmin(admin_id);

			HttpSession session = request.getSession();

			session.setAttribute("admin", admin);
			
			url = "updateAdminCheck.jsp";
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
