package servlet;

import java.io.IOException;

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
 * Servlet implementation class InsertSweetServlet
 */
@WebServlet("/InsertSweetsServlet")
public class InsertSweetsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSweetsServlet() {
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
		
		HttpSession session=request.getSession();
		RequestDispatcher rd;
		SweetsDAO sdao=new SweetsDAO();
		
		if(!session.getAttribute("session_id").equals(null)) {
			
			request.setCharacterEncoding("UTF-8");
			
			SweetsBean bean = new SweetsBean();
			
			bean.setSweets_id(Integer.parseInt(request.getParameter("sweets_id")));
			bean.setSweets_name(request.getParameter("sweets=name"));
			bean.setSweets_value(Integer.parseInt(request.getParameter("sweets_value")));
			bean.setSweets_genre(request.getParameter("sweets_genre"));
			bean.setShop_id(request.getParameter("shop_id"));
			
			
			sdao.insertSweets(bean);
			
			
			rd = request.getRequestDispatcher("SweetsInsertResult.jsp");
		
		} else {
			
			session.invalidate();
			rd=request.getRequestDispatcher("Login.jsp");
			
		}

		rd.forward(request, response);
		
	}

	
}
