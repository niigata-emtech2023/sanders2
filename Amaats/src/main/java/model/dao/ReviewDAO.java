package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.ReviewBean;


public class ReviewDAO {
	/**
	 * 口コミ
	 */
	public List<ReviewBean> getReviewList(int sweetsId)
			throws SQLException, ClassNotFoundException {

		List<ReviewBean> reviewList = new ArrayList<ReviewBean>();
		String sql ="SELECT * FROM t_review WHERE sweets_id =?";

		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){



			// プレースホルダへの値の設定
			pstmt.setInt(1, sweetsId);
			ResultSet res =pstmt.executeQuery();


			while(res.next()) {

				ReviewBean review = new ReviewBean();
				review.setReview_id(res.getInt("review_id"));
				review.setReview_text(res.getString("review_text"));
				review.setUser_id(res.getString("user_id"));
				review.setSweets_id(res.getInt("sweets_id"));

				reviewList.add(review);

			}
			return reviewList;
		}
	}

	/*口コミ登録機能*/
	public int insertReview(ReviewBean review) throws SQLException, ClassNotFoundException {
		int count = 0; //処理件数
		//商品の追加
		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO t_review VALUES (100, ?, ?, ?)")) {
//(review_text, user_id, sweets_id)
			// DTOからのデータの取り出し
			String review_text = review.getReview_text();
			String  user_id = review.getUser_id();
			int sweets_id = review.getSweets_id();

			// プレースホルダへの値の設定
			pstmt.setString(1, review_text);
			pstmt.setString(2, user_id);
			pstmt.setInt(3, sweets_id);

			// SQLステートメントの実行
			count = pstmt.executeUpdate();
		}

		return count;
	}

}