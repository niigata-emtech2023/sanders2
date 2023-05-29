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

import model.dao.SweetsDAO;
import model.entity.SweetsBean;
/**
 * スイーツの編集制御
 * @author emtech-user
 *
 */
@WebServlet("/update-sweets-servlet")
public class UpdateSweetsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateSweetsServlet() {
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
		// セッションオブジェクトの取得
		HttpSession session = request.getSession();

		RequestDispatcher rd;

		if(!session.getAttribute("session_id").equals(null)) {
			// セッションスコープからの属性値の取得
			SweetsBean sweets = (SweetsBean) session.getAttribute("sweets");

			// DAOの生成
			SweetsDAO dao = new SweetsDAO();

			int processingNumber = 0; //処理件数

			try {
				// DAOの利用
				processingNumber = dao.updateSweets(sweets);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}


			// リクエストスコープへの属性の設定
			request.setAttribute("processingNumber", processingNumber);

			// リクエストの転送
			rd = request.getRequestDispatcher("update-sweets-result.jsp");
		} else {

			session.invalidate();
			rd=request.getRequestDispatcher("Login.jsp");

		}
		rd.forward(request, response);
	}

}
