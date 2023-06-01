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
import javax.servlet.http.HttpSession;

import model.dao.SweetsDAO;
import model.entity.SweetsBean;

/**
 * Servlet implementation class ShowDeleteSweetsServlet
 */
@WebServlet("/show-delete-sweets-servlet")
public class ShowDeleteSweetsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDeleteSweetsServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		SweetsDAO sdao = new SweetsDAO();
		List<SweetsBean> sweetsList = new ArrayList<SweetsBean>();
		
		if (!session.getAttribute("session_id").equals(null)) {
			
			try {
				
				sweetsList = sdao.searchShop((String) session.getAttribute("session_id"));
				
			} catch (SQLException | ClassNotFoundException e) {
				
				e.printStackTrace();
				
			}
			
			rd = request.getRequestDispatcher("DeleteSweets.jsp");
			request.setAttribute("beanList", sweetsList);

		} else {

			rd = request.getRequestDispatcher("Login.jsp");

		}

		rd.forward(request, response);

	}
	
}
