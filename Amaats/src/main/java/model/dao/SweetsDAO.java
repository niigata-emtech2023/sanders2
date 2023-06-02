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
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO m_sweets (sweets_name, sweets_value, sweets_genre, shop_id, sweets_info) VALUES(?, ?, ?, ?, ?)")) {

			// DTOからのデータの取り出し
			String sweetsName = sweets.getSweets_name();
			int sweetsValue = sweets.getSweets_value();
			String  sweetsGenre = sweets.getSweets_genre();
			String shopId = sweets.getShop_id();
			String sweetsInfo = sweets.getSweets_info();

			// プレースホルダへの値の設定
			pstmt.setString(1, sweetsName);
			pstmt.setInt(2, sweetsValue);
			pstmt.setString(3, sweetsGenre);
			pstmt.setString(4, shopId);
			pstmt.setString(5, sweetsInfo);

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

		String sql = "UPDATE m_sweets SET sweets_name = ?, sweets_value = ?, sweets_grene = ?, sweets_info = ? WHERE sweets_id = ?";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// DTOからのデータの取り出し
			int sweetsId = sweets.getSweets_id();
			String sweetsName = sweets.getSweets_name();
			int sweetsValue = sweets.getSweets_value();
			String  sweetsGenre = sweets.getSweets_genre();
			String sweetsInfo = sweets.getSweets_info();
			
			// プレースホルダへの値の設定
			pstmt.setString(1, sweetsName); System.out.println(sweetsName);
			pstmt.setInt(2, sweetsValue); System.out.println(sweetsValue);
			pstmt.setString(3, sweetsGenre); System.out.println(sweetsGenre);
			pstmt.setString(4, sweetsInfo); System.out.println(sweetsInfo);
			pstmt.setInt(5, sweetsId); System.out.println(sweetsId);

			// SQLステートメントの実行
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}
	
	public int addImage(String sweets_id, String filename) throws SQLException, ClassNotFoundException {
		
		String sql = "UPDATE m_sweets SET path = ? WHERE sweets_id = ?";
		int count = 0;
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1, filename);
			pstmt.setString(2, sweets_id);
			
			count = pstmt.executeUpdate();
			
		}
		
		return count;
		
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

			int sweets_id = sweets.getSweets_id();

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

			pstmt.setString(1, "%" + sweets_name + "%");

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {

				SweetsBean sb = new SweetsBean();

				sb.setSweets_id(res.getInt("sweets_id"));
				sb.setSweets_name(res.getString("sweets_name"));
				sb.setSweets_value(res.getInt("sweets_value"));
				sb.setSweets_genre(res.getString("sweets_genre"));
				sb.setShop_id(res.getString("shop_id"));
				sb.setPath(res.getString("path"));

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

		String sql = "SELECT * FROM m_sweets WHERE sweets_genre = ?";
		List<SweetsBean> sweetsList = new ArrayList<SweetsBean>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, sweets_genre);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {

				SweetsBean sb = new SweetsBean();

				sb.setSweets_id(res.getInt("sweets_id"));
				sb.setSweets_name(res.getString("sweets_name"));
				sb.setSweets_value(res.getInt("sweets_value"));
				sb.setSweets_genre(res.getString("sweets_genre"));
				sb.setShop_id(res.getString("shop_id"));
				sb.setPath(res.getString("path"));

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
			pstmt.setInt(2, maxvalue);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {

				SweetsBean sb = new SweetsBean();

				sb.setSweets_id(res.getInt("sweets_id"));
				sb.setSweets_name(res.getString("sweets_name"));
				sb.setSweets_value(res.getInt("sweets_value"));
				sb.setSweets_genre(res.getString("sweets_genre"));
				sb.setShop_id(res.getString("shop_id"));
				sb.setPath(res.getString("path"));

				sweetsList.add(sb);

			}

		}

		return sweetsList;
		
	}
	
	public List<SweetsBean> searchShop(String shop_id) throws SQLException, ClassNotFoundException {

		String sql = "SELECT * FROM m_sweets WHERE shop_id = ?";
		List<SweetsBean> sweetsList = new ArrayList<SweetsBean>();
		System.out.println(shop_id);
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, shop_id);

			ResultSet res = pstmt.executeQuery();
			int i = 0;
			while (res.next()) {
				i++;
				SweetsBean sb = new SweetsBean();

				sb.setSweets_id(res.getInt("sweets_id")); System.out.println(res.getInt("sweets_id"));
				sb.setSweets_name(res.getString("sweets_name")); res.getString("sweets_name");
				sb.setSweets_value(res.getInt("sweets_value")); res.getInt("sweets_value");
				sb.setSweets_genre(res.getString("sweets_genre")); res.getString("sweets_genre");
				sb.setSweets_info(res.getString("sweets_info")); res.getString("sweets_info");
				sb.setShop_id(res.getString("shop_id")); res.getString("shop_id");
				sb.setPath(res.getString("path")); res.getString("path");

				sweetsList.add(sb);

			}
			System.out.println(i);

		}

		return sweetsList;
	}
	
	public SweetsBean getSweetsInfo (int sweets_id) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM m_sweets WHERE sweets_id = ?";
			SweetsBean sb = new SweetsBean();

			try (Connection con = ConnectionManager.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {

				pstmt.setInt(1, sweets_id);

				ResultSet res = pstmt.executeQuery();
				res.next();

					sb.setSweets_id(res.getInt("sweets_id"));
					sb.setSweets_name(res.getString("sweets_name"));
					sb.setSweets_value(res.getInt("sweets_value"));
					sb.setSweets_genre(res.getString("sweets_genre"));
					sb.setShop_id(res.getString("shop_id"));
					sb.setPath(res.getString("path"));

			}

			return sb;
		
	}
	
}
