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
 * Servlet implementation class CheckUpdateSweetsServlet
 */
@WebServlet("/check-update-sweets-servlet")
public class CheckUpdateSweetsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUpdateSweetsServlet() {
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
		
		SweetsBean sb = new SweetsBean();
		
		sb.setSweets_id(Integer.parseInt(request.getParameter("id"))); System.out.println(request.getParameter("sweets_genre"));
		sb.setSweets_name(request.getParameter("sweets_name"));
		sb.setSweets_genre(genre(request.getParameter("sweets_genre")));
		sb.setSweets_value(Integer.parseInt(request.getParameter("sweets_value")));
		sb.setSweets_info(request.getParameter("sweets_info"));
		
		request.setAttribute("bean", sb);
		
		RequestDispatcher rd = request.getRequestDispatcher("UpdateSweetsCheck.jsp");
		rd.forward(request, response);
		
	}
	
	String genre (String sweets_genre) {
		
		String genre;
		
		switch (sweets_genre) {
		case "sweets2":
			genre = "ケーキ";
			break;
		case "sweets3":
			genre = "チョコ";
			break;
		case "sweets4":
			genre = "クッキー";
			break;
		case "sweets5":
			genre = "カヌレ";
			break;
		case "sweets6":
			genre = "マカロン";
			break;
		case "sweets7":
			genre = "和菓子";
			break;
		case "sweets8":
			genre = "その他";
			break;
		default:
			genre = sweets_genre;
			break;
		}
		
		return genre;
		
	}

}
