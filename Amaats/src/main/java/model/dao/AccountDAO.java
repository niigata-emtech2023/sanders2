package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.AdminBean;
import model.entity.ShopBean;
import model.entity.UserBean;

public class AccountDAO {

	/**
	 * ユーザーログイン認証
	 * @param user_id
	 * @param password
	 * @return
	 */
	public boolean login(String user_id, String password) throws SQLException, ClassNotFoundException {

		String sql = "SELECT password FROM m_user WHERE user_id = ?";

		boolean flag = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, user_id);
			ResultSet res = pstmt.executeQuery();

			res.next();

			flag = res.getString("password").equals(password);

		}

		return flag;

	}

	/**
	 * 店舗ログイン認証
	 * @param shop_id
	 * @param shop_password
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean loginShop(String shop_id, String shop_password) throws SQLException, ClassNotFoundException {

		String sql = "SELECT shop_password FROM m_shop WHERE shop_id = ?";
		boolean flag = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, shop_id);
			ResultSet res = pstmt.executeQuery();

			res.next();

			flag = res.getString("shop_password").equals(shop_password);

		}

		return flag;

	}

	/**
	 * サイト管理者ログイン認証
	 * @param admin_id
	 * @param admin_password
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean loginAdmin(String admin_id, String admin_password) throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT admin_password FROM m_admin WHERE admin_id = ?";
		
		boolean flag = false;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, admin_id);
			ResultSet res = pstmt.executeQuery();

			res.next();

			flag = res.getString("admin_password").equals(admin_password);

		}

		return flag;

	}

	public UserBean selectUser(String user_id) throws SQLException, ClassNotFoundException {
		UserBean user = new UserBean();

		String sql = "SELECT * FROM m_user WHERE user_id = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, user_id);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				user.setUser_id(res.getString("user_id"));
				user.setUser_name(res.getString("user_name"));
				user.setPassword(res.getString("password"));
				user.setUser_genre(res.getString("user_genre"));
				user.setUser_address(res.getString("user_adress"));
			}
		}
		return user;
	}

	public ShopBean selectShop(String shop_id) throws SQLException, ClassNotFoundException {
		ShopBean shop = new ShopBean();

		String sql = "SELECT * FROM m_shop WHERE shop_id = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, shop_id);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				shop.setShop_id(res.getString("shop_id"));
				shop.setShop_name(res.getString("shop_name"));
				shop.setShop_password(res.getString("shop_password"));
				shop.setShop_address(res.getString("shop_address"));
				shop.setShop_tel(res.getString("shop_tel"));
			}
		}
		return shop;
	}
	
	public AdminBean selectAdmin(String admin_id) throws SQLException, ClassNotFoundException {
		AdminBean admin = new AdminBean();

		String sql = "SELECT * FROM m_admin WHERE admin_id = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, admin_id);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				admin.setAdmin_id(res.getString("admin_id"));
				admin.setAdmin_password(res.getString("admin_password"));

			}
		}
		return admin;
	}
	
	public List<UserBean> getUserList() throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT * FROM m_user";
		
		List<UserBean> userList = new ArrayList<UserBean>();

		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)) {

			while (res.next()) {

				UserBean ub = new UserBean();

				ub.setUser_id(res.getString("user_id"));
				ub.setUser_name(res.getString("user_name"));
				ub.setPassword(res.getString("password"));
				ub.setUser_genre(res.getString("user_genre"));
				ub.setUser_address(res.getString("user_address"));

				userList.add(ub);

			}

		}

		return userList;

	}

	public List<ShopBean> getShopList() throws SQLException, ClassNotFoundException{

		String sql = "SELECT * FROM m_shop";
		List<ShopBean> shopList = new ArrayList<ShopBean>();

		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)) {

			while (res.next()) {

				ShopBean sb = new ShopBean();
				sb.setShop_id(res.getString("shop_id"));
				sb.setShop_name(res.getString("shop_name"));
				sb.setShop_password(res.getString("shop_password"));
				sb.setShop_address(res.getString("shop_address"));
				sb.setShop_tel(res.getString("shop_tel"));

				shopList.add(sb);

			}

		}

		return shopList;

	}

	public int insertNewUser(UserBean user) throws SQLException, ClassNotFoundException, NullPointerException {

		int count = 0;
		String sql = "INSERT INTO m_user(user_id, user_name, password, user_address) VALUES (?, ?, ?, ?)";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_name());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getUser_address());

			count = pstmt.executeUpdate();

		}

		return count;

	}

	public void insertNewShop(ShopBean shop) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO m_shop VALUES (?, ?, ?, NULL, NULL)";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			String shop_id = shop.getShop_id();
			String shop_name = shop.getShop_name();
			String shop_password = shop.getShop_password();

			pstmt.setString(1, shop_id);
			pstmt.setString(2, shop_name);
			pstmt.setString(3, shop_password);

			pstmt.executeUpdate();
		}
	}

	public void UpdateUser(UserBean user) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE m_user SET user_name = ?, password = ?, user_genre = ?, user_adress = ? WHERE user_id = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			UserBean bean = new UserBean();
			String user_id = bean.getUser_id();
			String user_name = bean.getUser_name();
			String password = bean.getPassword();
			String user_genre = bean.getUser_genre();
			String user_adress = bean.getUser_address();

			pstmt.setString(1, user_name);
			pstmt.setString(2, password);
			pstmt.setString(3, user_genre);
			pstmt.setString(4, user_adress);
			pstmt.setString(5, user_id);

			pstmt.executeUpdate();
		}
	}

	public void UpdateShop(ShopBean shop) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE m_shop SET shop_name = ?, shop_password = ?, shop_address = ?, shop_tel = ? WHERE shop_id = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			ShopBean bean = new ShopBean();
			String shop_id = bean.getShop_id();
			String shop_name = bean.getShop_name();
			String shop_password = bean.getShop_password();
			String shop_address = bean.getShop_address();
			String shop_tel = bean.getShop_tel();

			pstmt.setString(1, shop_name);
			pstmt.setString(2, shop_password);
			pstmt.setString(3, shop_address);
			pstmt.setString(4, shop_tel);
			pstmt.setString(5, shop_id);

			pstmt.executeUpdate();
		}
	}

	public void UpdateAdmin(AdminBean admin) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE m_admin SET admin_password = ? WHERE admin_id = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			String admin_id = admin.getAdmin_id();
			String admin_password = admin.getAdmin_password();

			pstmt.setString(2, admin_id);
			pstmt.setString(1, admin_password);

			pstmt.executeUpdate();
		}
	}

	public void deleteUser(String user_id) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM m_user WHERE user_id = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, user_id);

			pstmt.executeUpdate();
			
		}
	}

	public void deleteShop(String shop_id) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM m_shop WHERE shop_id = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, shop_id);

			pstmt.executeUpdate();
		}
	}

	public UserBean getUserAccount(String user_id) throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT * FROM m_user WHERE user_id = ?";
		
		UserBean ub = new UserBean();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1, user_id);
			
			ResultSet res = pstmt.executeQuery();
			
			res.next();
			
			ub.setUser_id(res.getString("user_id"));
			ub.setUser_name(res.getString("user_name"));
			ub.setPassword(res.getString("password"));
			ub.setUser_address(res.getString("user_address"));
			ub.setUser_genre(res.getString("user_genre"));
			
		}
		
		return ub;
		
	}

	public ShopBean getShopAccount(String shop_id) throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT * FROM m_shop WHERE shop_id = ?";

		ShopBean sb = new ShopBean();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1, shop_id);
			
			ResultSet res = pstmt.executeQuery();
			
			res.next();
			
			sb.setShop_id(res.getString("shop_id"));
			sb.setShop_name(res.getString("shop_name"));
			sb.setShop_password(res.getString("shop_password"));
			sb.setShop_address(res.getString("shop_address"));
			sb.setShop_tel(res.getString("shop_tel"));
			
		}
		
		return sb;
		
	}

	public AdminBean getAdminAccount(String admin_id) throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT * FROM m_admin WHERE admin_id = ?";

		AdminBean ab = new AdminBean();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1, admin_id);
			
			ResultSet res = pstmt.executeQuery();
			
			res.next();
			
			ab.setAdmin_id(res.getString("admin_id"));
			ab.setAdmin_password(res.getString("admin_password"));
			
		}
		
		return ab;
		
	}

}
