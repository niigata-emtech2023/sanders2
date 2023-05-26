package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.SweetsBean;

/**
 * Servlet implementation class InsertSweetServlet
 */
@WebServlet("/InsertSweetServlet")
public class InsertSweetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSweetServlet() {
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
		
		SweetsBean bean = new SweetsBean();
		
		bean.setSweets_id(request.getString("sweets_id"));
		bean.setSweets_name(request.getString("sweets=name"));
		bean.setSweets_value(request.getInt("sweets_value"));
		bean.setSweets_genre(request.getString("sweets_genre"));
		bean.setShop_id(request.getString("shop_id"));
		
		InsertSweets(bean);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("show-insert-shop-servlet");
		rd.forward(request, response);
		
	}

	
}
