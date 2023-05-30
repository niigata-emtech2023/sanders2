package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.SweetsBean;

public class SweetsDAO {
	/**
	 * 商品一覧
	 * @return sweetsList
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<SweetsBean> getSweetsList()
			throws SQLException, ClassNotFoundException {

		List<SweetsBean> sweetsList = new ArrayList<SweetsBean>();

		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery("SELECT * FROM m_sweets")) {

			// 結果の操作
			while (res.next()) {
				int sweetsId = res.getInt("sweets_id");
				String sweetsName = res.getString("sweets_name");
				int sweetsValue = res.getInt("sweets_value");
				String sweetsGenre = res.getString("sweets_genre");
				String shopId = res.getString("shop_id");


				SweetsBean sweets = new SweetsBean();
				sweets.setSweets_id(sweetsId);
				sweets.setSweets_name(sweetsName);
				sweets.setSweets_value(sweetsValue);
				sweets.setSweets_genre(sweetsGenre);
				sweets.setShop_id(shopId);

				sweetsList.add(sweets);
			}
		}
		return sweetsList;
	}
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
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO m_sweets (sweets_name, sweets_value, sweets_genre, shop_id) VALUE(?, ?, ?, ?)")) {

			// DTOからのデータの取り出し
			String sweetsName = sweets.getSweets_name();
			int sweetsValue = sweets.getSweets_value();
			String  sweetsGenre = sweets.getSweets_genre();
			String shopId = sweets.getShop_id();

			// プレースホルダへの値の設定
			pstmt.setString(1, sweetsName);
			pstmt.setInt(2, sweetsValue);
			pstmt.setString(3, sweetsGenre);
			pstmt.setString(4, shopId);

			// SQLステートメントの実行
			count = pstmt.executeUpdate();
		}

		return count;
	}
	/**
	 * 商品編集
	 * @param sweets スイーツオブジェクト
	 * @return processingNumber 処理件数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int updateSweets(SweetsBean sweets) throws SQLException, ClassNotFoundException {
		int processingNumber = 0; //処理件数

		String sql = "UPDATE m_sweets SET sweets_name = ?, sweets_value = ?, sweets_grene = ? WHERE sweets_name = ?";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// DTOからのデータの取り出し
			int sweetsId = sweets.getSweets_id();
			String sweetsName = sweets.getSweets_name();
			int sweetsValue = sweets.getSweets_value();
			String  sweetsGenre = sweets.getSweets_genre();
			String shopId = sweets.getShop_id();
			// プレースホルダへの値の設定
			pstmt.setString(1, sweetsName);
			pstmt.setInt(2, sweetsValue);
			pstmt.setString(3, sweetsGenre);
			pstmt.setString(4, sweetsName);

			// SQLステートメントの実行
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}



	/**
	 * 商品削除
	 * @param sweets
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int deleteSweets(SweetsBean sweets) throws SQLException, ClassNotFoundException {
		int processingNumber = 0;
		String sql = "DELETE  FROM m_sweets WHERE sweets_id = ?";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			SweetsBean bean = new SweetsBean();

			int sweets_id = bean.getSweets_id();

			// プレースホルダへの値の設定
			pstmt.setInt(1, sweets_id);


			// SQLステートメントの実行
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}

	/**
	 * カートに商品追加
	 * @param sweets
	 */
	public void insertCart(SweetsBean sweets) {
		List<SweetsBean> cartList = new ArrayList<SweetsBean>();

		int totalValue = 0;
		for (SweetsBean sweet : cartList) {
			totalValue += sweet.getSweets_value();
		}
		cartList.add(sweets);
	}

	public List<SweetsBean> checkCart() {
		List<SweetsBean> cartList = new ArrayList<SweetsBean>();

		for (int i = 0; i < cartList.size(); i++) {
			SweetsBean sweets = cartList.get(i);
		}

		return cartList;
	}


	/**
	 * カートを空にする
	 */
	public void emptyCart() {
		List<SweetsBean> cartList = new ArrayList<SweetsBean>();

		cartList.clear();
	}



	/**
	 * 商品の名前検索
	 * @param sweets_name
	 * @return sweetsList
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<SweetsBean> searchName(String sweets_name) throws SQLException, ClassNotFoundException {

		String sql = "SELECT * FROM m_sweets WHERE sweets_name LIKE ?";
		List<SweetsBean> sweetsList = new ArrayList<SweetsBean>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, "%" + sql + "%");

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {

				SweetsBean sb = new SweetsBean();

				sb.setSweets_id(res.getInt("sweets_id"));
				sb.setSweets_name(res.getString("sweets_name"));
				sb.setSweets_value(res.getInt("sweets_value"));
				sb.setSweets_genre(res.getString("sweets_genre"));
				sb.setShop_id(res.getString("shop_id"));

				sweetsList.add(sb);

			}

		}

		return sweetsList;

	}
	/**
	 * ジャンルで商品検索
	 * @param sweets_genre
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<SweetsBean> searchGenre(String sweets_genre) throws SQLException, ClassNotFoundException {

		String sql = "SELECT * FROM m_sweets WHERE sweets_genre LIKE ?";
		List<SweetsBean> sweetsList = new ArrayList<SweetsBean>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, "%" + sql + "%");

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {

				SweetsBean sb = new SweetsBean();

				sb.setSweets_id(res.getInt("sweets_id"));
				sb.setSweets_name(res.getString("sweets_name"));
				sb.setSweets_value(res.getInt("sweets_value"));
				sb.setSweets_genre(res.getString("sweets_genre"));
				sb.setShop_id(res.getString("shop_id"));

				sweetsList.add(sb);

			}

		}

		return sweetsList;

	}
	/**
	 * 価格の上限、下限で商品検索
	 * @param maxvalue
	 * @param minvalue
	 * @return sweetsList
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<SweetsBean> searchValue(int maxvalue, int minvalue) throws SQLException, ClassNotFoundException {

		String sql = "SELECT * FROM m_sweets WHERE sweets_value BETWEEN ? AND ?";
		List<SweetsBean> sweetsList = new ArrayList<SweetsBean>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setInt(1, minvalue);
			pstmt.setInt(1, maxvalue);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {

				SweetsBean sb = new SweetsBean();

				sb.setSweets_id(res.getInt("sweets_id"));
				sb.setSweets_name(res.getString("sweets_name"));
				sb.setSweets_value(res.getInt("sweets_value"));
				sb.setSweets_genre(res.getString("sweets_id"));
				sb.setShop_id(res.getString("shop_id"));

				sweetsList.add(sb);

			}

		}

		return sweetsList;
	}
}
