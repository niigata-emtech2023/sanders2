package servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.dao.SweetsDAO;
import model.entity.SweetsBean;

/**
 * Servlet implementation class InsertSweetServlet
 */
@WebServlet("/insert-sweets-servlet")
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
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/form.jsp");
		rd.forward(request, response);
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
			
			try {
				
				request.setCharacterEncoding("UTF-8");
				
				String name=request.getParameter("name");
				String word=request.getParameter("word");
				//name属性がpictのファイルをPartオブジェクトとして取得
				Part part=request.getPart("pict");
				//ファイル名を取得
				//String filename=part.getSubmittedFileName();//ie対応が不要な場合
				String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString();
				//アップロードするフォルダ
				String path=getServletContext().getRealPath("/upload");
				//実際にファイルが保存されるパス確認
				System.out.println(path);
				//書き込み
				part.write(path+File.separator+filename);
				
				SweetsBean bean = new SweetsBean();
				
				bean.setSweets_id(Integer.parseInt(request.getParameter("sweets_id")));
				bean.setSweets_name(request.getParameter("sweets=name"));
				bean.setSweets_value(Integer.parseInt(request.getParameter("sweets_value")));
				bean.setSweets_genre(request.getParameter("sweets_genre"));
				bean.setShop_id(request.getParameter("shop_id"));
				
				bean.setPath(ここから書く);
				
				sdao.insertSweets(bean);
				
				rd = request.getRequestDispatcher("SweetsInsertResult.jsp");
				
			} catch (SQLException | ClassNotFoundException e) {
				
				rd =request.getRequestDispatcher("InsertSweet.jap");
				request.setAttribute("alert", "データベース操作で問題が発生しました");
				
			}
		
		} else {
			
			session.invalidate();
			rd=request.getRequestDispatcher("Login.jsp");
			
		}

		rd.forward(request, response);
		
	}

	
}
