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

import model.dao.SweetsDAO;
import model.entity.SweetsBean;

/**
 * Servlet implementation class SearchGenreServlet
 */
@WebServlet("/search-shop-servlet")
public class SearchShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchShopServlet() {
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
		
		SweetsDAO sdao = new SweetsDAO();
		
		List<SweetsBean> sweetsList = new ArrayList<SweetsBean>();
		
		try {
			
			sweetsList = sdao.searchShop(request.getParameter("shop_id"));
			
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		/* フォワード */
		RequestDispatcher rd = request.getRequestDispatcher("SearchResult.jsp");
		request.setAttribute("beanList", sweetsList);
		rd.forward(request, response);
		
	}

}