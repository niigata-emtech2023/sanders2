package driver;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.SweetsBean;

/**
 * Servlet implementation class SweetsInfoDriver
 */
@WebServlet("/SweetsInfoDriver")
public class SweetsInfoDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SweetsInfoDriver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SweetsBean sb = new SweetsBean();
		
		sb.setSweets_id(111111);
		sb.setSweets_name("ショートケーキ");
		sb.setSweets_value(350);
		sb.setSweets_genre("ケーキ");
		sb.setShop_id("88");
		
		RequestDispatcher rd = request.getRequestDispatcher("SweetsInfo.jsp");
		request.setAttribute("bean", sb);
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
