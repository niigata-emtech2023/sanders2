package servlet;

import java.io.IOException;
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
 * Servlet implementation class ShowCartList
 */
@WebServlet("/show-cart-list-servlet")
public class ShowCartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCartListServlet() {
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
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		
		String url = null;

		HttpSession session = request.getSession();

		if (session.getAttribute("user_id") != null) {
			try {
				SweetsDAO dao = new SweetsDAO();
				
				List<SweetsBean> cartList = dao.checkCart();
				
				request.setAttribute("cartList", cartList);
				
				url = "CartList.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			url = "Login.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
