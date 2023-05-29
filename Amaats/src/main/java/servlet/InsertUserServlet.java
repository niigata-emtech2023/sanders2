package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.AccountDAO;
import model.entity.UserBean;

/**
 * Servlet implementation class InsertUserServlet
 */
@WebServlet("/insert-user-servlet")
public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUserServlet() {
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
		List<UserBean> userList = new ArrayList<UserBean>();
		RequestDispatcher rd;
		boolean flag = true;
		
		/* 入力情報に不備がないか確認 */
		if (request.getParameter("user_id").length() <= 0) {
			
			flag = false;
			
		}
		
		if (request.getParameter("user_name").length() <= 0) {
			
			flag = false;
			
		}
		
		if (request.getParameter("password").length() <= 0) {
			
			flag = false;
			
		}
		
		if (!request.getParameter("passcon").equals(request.getParameter("password"))) {
			
			flag = false;
			
		}
		
		if (request.getParameter("user_address").length() <= 0) {
			
			flag = false;
			
		}
		
		try {
			
			userList = adao.getUserList();
			
			/* 同じユーザーIDがないか確認 */
			for (UserBean user: userList) {
			
				if (user.getUser_id().equals(request.getParameter("user_id"))) {
				
					flag = false;
				
				}
				
			}
			
			/* 入力情報に不備がなければ登録、あれば戻る */
			if (flag) {
				
				UserBean ub = new UserBean();
				ub.setUser_id(request.getParameter("user_id"));
				ub.setUser_id(request.getParameter("user_name"));
				ub.setUser_id(request.getParameter("password"));
				ub.setUser_id(request.getParameter("user_address"));
				adao.insertNewUser(ub);
				
				rd = request.getRequestDispatcher("UserInsertResult.jsp");
				
			} else {
				
				request.setAttribute("alert", "入力情報に不備があります");
				rd = request.getRequestDispatcher("InsertUser.jsp");
				
			}
			
		} catch (SQLException e) {
			
			request.setAttribute("alert", "ユーザー登録ができるか確認が取れませんでした。");
			rd = request.getRequestDispatcher("InsertUser.jsp");
			
		} catch (ClassNotFoundException e) {
			
			request.setAttribute("alert", "データベースにアクセスできませんでした。");
			rd = request.getRequestDispatcher("InsertUser.jsp");
			
		}
		
		rd.forward(request, response);
		
	}

}
