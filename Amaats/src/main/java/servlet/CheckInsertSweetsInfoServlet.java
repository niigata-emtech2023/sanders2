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
		
		if(request.getParameter("sweets_name").length()<=0 && request.getParameter("sweets_name").length()>32){
			flag=false;
		}
		if(Integer.parseInt(request.getParameter("sweets_value")) <= 0) {
			flag=false;
		}
		if(request.getParameter("sweets_genre").equals(null)) {
			flag=false;
		}
		
		
		SweetsBean sweetsbean = new SweetsBean();
		sweetsbean.setSweets_name(request.getParameter("sweets_name"));
		sweetsbean.setSweets_genre(request.getParameter("sweets_genre"));
		sweetsbean.setSweets_value(Integer.parseInt(request.getParameter("sweets_value")));
		sweetsbean.setSweets_info(request.getParameter("sweets_info"));
		
		request.setAttribute("bean","sweetsbean");
		
		
		
		if(flag) {
			rd=request.getRequestDispatcher("CheckInsertSweets.jsp");
		}else {
			request.setAttribute("alert","入力情報に不備があります");
			rd=request.getRequestDispatcher("InsertSweets.jsp");
		}
		
		rd.forward(request, response);
		
	}

}
