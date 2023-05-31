package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SweetsDAO;
import model.entity.SweetsBean;


/**
 * 商品の一覧表示の制御
 */
@WebServlet("/show-sweets-list-servlet")
public class ShowSweetsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ShowSweetsListServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SweetsBean> sweetsList = null;

		// DAOの生成
		SweetsDAO dao = new SweetsDAO();

		try {
			// DAOの利用
			sweetsList = dao.getSweetsList();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// リクエストスコープへの属性の設定
		request.setAttribute("sweetsList", sweetsList);

		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("SweetsList.jsp");
		rd.forward(request, response);
	}	
}
