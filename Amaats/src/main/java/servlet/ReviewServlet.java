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

import model.dao.ReviewDAO;
import model.entity.ReviewBean;

/**
 * 口コミ機能の登録制御
 */
@WebServlet("/review-servlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReviewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストオブジェクトのエンコーディング方式の指定
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();

		// リクエストパラメータの取得
		String review_text = request.getParameter("review_text");
		String user_id = (String) session.getAttribute("session_id");
		int sweets_id = Integer.parseInt(request.getParameter("sweets_id"));
		
		ReviewBean review = new ReviewBean();
		
		review.setReview_text(review_text);
		review.setUser_id(user_id);
		review.setSweets_id(sweets_id);
		// DAOの生成
		ReviewDAO dao = new ReviewDAO();

		int count = 0;	// 処理件数

		try {
			// DAOの利用
			count = dao.insertReview(review);
			System.out.println(count);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// リクエストスコープへの属性の設定
		request.setAttribute("count", count);
		request.setAttribute("sweets_id", request.getParameter("sweets_id"));
		request.setAttribute("review_text", review_text);

		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("show-sweets-info-servlet");
		rd.forward(request, response);

	}

}
