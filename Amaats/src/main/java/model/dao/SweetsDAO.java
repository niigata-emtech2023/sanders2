package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.entity.SweetsBean;

public class SweetsDAO {
	public int insert(SweetsBean sweets) throws SQLException, ClassNotFoundException {
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
}


