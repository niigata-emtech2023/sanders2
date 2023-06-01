package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ReviewDAO;
import model.dao.SweetsDAO;

/**
 * Servlet implementation class ShowSweetsInfoServlet
 */
@WebServlet("/show-sweets-info-servlet")
public class ShowSweetsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowSweetsInfoServlet() {
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
		
		SweetsDAO sdao = new SweetsDAO();
		ReviewDAO rdao = new ReviewDAO();
		int sweets_id = Integer.parseInt(request.getParameter("id"));
		
		try {
			
			request.setAttribute("bean", sdao.getSweetsInfo(sweets_id));
			request.setAttribute("reviewList", rdao.getReviewList(sweets_id));
			
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("SweetsInfo.jsp");
		rd.forward(request, response);		
		
	}

}
