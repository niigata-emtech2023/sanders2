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
 * Servlet implementation class CheckInsertSweetsInfoServlet
 */
@WebServlet("/check-insert-sweets-info-servlet")
public class CheckInsertSweetsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckInsertSweetsInfoServlet() {
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
		
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher rd;
		
		boolean flag = true;
		
		try {
			System.out.println(request.getParameter("sweets_name"));
			System.out.println(request.getParameter("sweets_value"));
			System.out.println(request.getParameter("sweets_genre"));
			System.out.println(request.getParameter("sweets_info"));
			if(request.getParameter("sweets_name").length()>32){
				flag=false;
			}
			if(Integer.parseInt(request.getParameter("sweets_value")) <= 0) {
				flag=false;
			}
			if(request.getParameter("sweets_genre").equals("default")){
				flag=false;
			}
			
		} catch (NullPointerException e) {
			e.printStackTrace();
			flag = false;
			
		}
		
		if(flag) {
			
			SweetsBean sweetsbean = new SweetsBean();
			sweetsbean.setSweets_name(request.getParameter("sweets_name"));
			sweetsbean.setSweets_genre(genre(request.getParameter("sweets_genre")));
			sweetsbean.setSweets_value(Integer.parseInt(request.getParameter("sweets_value")));
			sweetsbean.setSweets_info(request.getParameter("sweets_info"));
			
			request.setAttribute("bean", sweetsbean);
			
			rd=request.getRequestDispatcher("CheckInsertSweets.jsp");
		}else {
			request.setAttribute("alert","入力情報に不備があります");
			request.setAttribute("sweets_name", request.getParameter("sweets_name"));
			request.setAttribute("sweets_genre", request.getParameter("sweets_genre"));
			request.setAttribute("sweets_value", request.getParameter("sweets_value"));
			request.setAttribute("sweets_info", request.getParameter("sweets_info"));
			rd=request.getRequestDispatcher("InsertSweets.jsp");
		}
		
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
		}
		
		return genre;
		
	}

}
