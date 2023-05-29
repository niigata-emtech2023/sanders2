package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.entity.SweetsBean;

public class SweetsDAO {
	
	/**
	 *  商品の登録
	 * @param sweets
	 * @return 処理件数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int insertSweets(SweetsBean sweets) throws SQLException, ClassNotFoundException {
		int count = 0; //処理件数
		//商品の追加
		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO m_sweets VALUE(?, ?, ?, ?, ?)")) {

			// DTOからのデータの取り出し
			String sweetsId = sweets.getSweets_id();
			String sweetsName = sweets.getSweets_name();
			int sweetsValue = sweets.getSweets_value();
			String  sweetsGenre = sweets.getSweets_genre();
			String shopId = sweets.getShop_id();

			// プレースホルダへの値の設定
			pstmt.setString(1,sweetsId);
			pstmt.setString(2, sweetsName);
			pstmt.setInt(3, sweetsValue);
			pstmt.setString(4, sweetsGenre);
			pstmt.setString(5, shopId);

			// SQLステートメントの実行
			count = pstmt.executeUpdate();
		}

		return count;
	}
	/**
	 * 
	 * @param sweets スイーツオブジェクト
	 * @return processingNumber 処理件数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int updateSweets(SweetsBean sweets) throws SQLException, ClassNotFoundException {
		int processingNumber = 0; //処理件数

		String sql = "UPDATE m_sweets SET sweets_name = ?, sweets_value = ?, sweets_grene = ? WHERE sweets_id = ?";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// DTOからのデータの取り出し
			String sweetsId = sweets.getSweets_id();
			String sweetsName = sweets.getSweets_name();
			int sweetsValue = sweets.getSweets_value();
			String  sweetsGenre = sweets.getSweets_genre();
			String shopId = sweets.getShop_id();
			// プレースホルダへの値の設定
			pstmt.setString(1, sweetsName);
			pstmt.setInt(2, sweetsValue);
			pstmt.setString(3, sweetsGenre);
			pstmt.setString(4, sweetsId);

			// SQLステートメントの実行
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}
}


