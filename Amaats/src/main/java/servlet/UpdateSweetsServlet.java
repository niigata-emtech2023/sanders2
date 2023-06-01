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
 * スイーツの編集制御
 * @author emtech-user
 *
 */
@WebServlet("/update-sweets-servlet")
public class UpdateSweetsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateSweetsServlet() {
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
		
		request.setCharacterEncoding("UTF-8");
		// セッションオブジェクトの取得
		HttpSession session = request.getSession();

		RequestDispatcher rd;

		if(!session.getAttribute("session_id").equals(null)) {
			
			SweetsBean sb = new SweetsBean();
			sb.setSweets_id(Integer.parseInt(request.getParameter("sweets_id")));
			sb.setSweets_name(request.getParameter("sweets_name"));
			sb.setSweets_genre(request.getParameter("sweets_genre"));
			sb.setSweets_value(Integer.parseInt(request.getParameter("sweets_value")));
			sb.setSweets_info(request.getParameter("sweets_info"));
			
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
			
			sb.setPath(filename);
			
			// DAOの生成
			SweetsDAO dao = new SweetsDAO();

			int processingNumber = 0; //処理件数

			try {
				// DAOの利用
				processingNumber = dao.updateSweets(sb);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}


			// リクエストスコープへの属性の設定
			request.setAttribute("processingNumber", processingNumber);

			// リクエストの転送
			rd = request.getRequestDispatcher("update-sweets-result.jsp");
		} else {

			session.invalidate();
			rd=request.getRequestDispatcher("Login.jsp");

		}
		rd.forward(request, response);
	}

}
