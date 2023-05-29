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
		
		String sql = "SELECT admin_password FROM m_user WHERE admin_id = ?";
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
	
	public List<UserBean> getUserList() throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT admin_password FROM m_user";
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
	
	public List<ShopBean> getShopList() {
		
		
		
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
	
	public void insertNewShop(ShopBean shop) {
		
		
		
	}
	
	public void UpdateUser(UserBean user) {
		
		
		
	}
	
	public void UpdateShop(ShopBean shop) {
		
		
		
	}
	
	public void UpdateAdmin(AdminBean admin) {
		
		
		
	}
	
	public void deleteUser(String user_id) {
		
		
		
	}
	
	public void deleteShop(String shop_id) {
		
		
		
	}
	
	public UserBean getUserAccount() {
		
		
		
	}
	
	public ShopBean getShopAccount() {
		
		
		
	}
	
	public AdminBean getAdminAccount() {
		
		
		
	}

}
