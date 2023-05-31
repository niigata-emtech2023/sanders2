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
@WebServlet("/check-insert-user-account-servlet")
public class CheckInsertUserAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckInsertUserAccountServlet() {
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
		
		request.setCharacterEncoding("UTF-8");
		
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
			try {
				
				for (UserBean user: userList) {
					
					if (user.getUser_id().equals(request.getParameter("user_id"))) {
						
						flag = false;
						
					}
					
				}
				
			} catch (NullPointerException e) {
				
				
				
			}
			
			/* 入力情報に不備がなければ確認、あれば戻る */
			if (flag) {
				
				rd = request.getRequestDispatcher("CheckUserInsertAccount.jsp");
				
			} else {
				
				request.setAttribute("alert", "入力情報に不備があります");
				rd = request.getRequestDispatcher("InsertUser.jsp");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("alert", "ユーザー登録ができるか確認が取れませんでした。");
			rd = request.getRequestDispatcher("InsertUser.jsp");
			
		} catch (ClassNotFoundException e) {
			
			request.setAttribute("alert", "データベースにアクセスできませんでした。");
			rd = request.getRequestDispatcher("InsertUser.jsp");
			
		}
		
		rd.forward(request, response);
		
	}

}
