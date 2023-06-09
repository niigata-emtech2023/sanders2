package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.UserBean;

/**
 * Servlet implementation class CheckUserUpdateServlet
 */
@WebServlet("/check-user-update-servlet")
public class CheckUserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUserUpdateServlet() {
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
		String user_id = (String) session.getAttribute("session_id");
		UserBean ub = new UserBean();
		
		if (user_id != null) {
			
			try {
				
				boolean flag = true;
				
				if (request.getParameter("password").length() > 16 || request.getParameter("password").length() <= 0) {
					
					flag = false;
					
				}
				
				if (request.getParameter("user_name").length() > 16 || request.getParameter("user_name").length() <= 0) {
					
					flag = false;
					
				}
				
				if (request.getParameter("user_address").length() > 16 || request.getParameter("user_address").length() <= 0) {
					
					flag = false;
					
				}
				
				if (flag) {
					
					ub.setUser_id(request.getParameter("user_id")); 
					ub.setUser_name(request.getParameter("user_name"));
					ub.setPassword(request.getParameter("password"));
					ub.setUser_genre(request.getParameter("user_genre"));
					ub.setUser_address(request.getParameter("user_address"));
					
					
					url = "UpdateUserCheck.jsp";
					request.setAttribute("bean", ub);
					
				} else {
					
					url = "UpdateUserAccount.jsp";
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
