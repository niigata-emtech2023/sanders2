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
	 * 
	 * @param user_id
	 * @param password
	 * @return
	 */
	public boolean login(String user_id, String password) {
			
		String sql = "SELECT password FROM m_user WHERE user_id = ?";
		boolean accept = false;
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				
				pstmt.setString(1, user_id);
				ResultSet res = pstmt.executeQuery();
				
				res.next();
				accept = true;
				
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		return accept;
		
	}
	
	public boolean loginShop(String shop_id, String shop_password) {
		
		String sql = "SELECT shop_password FROM m_shop WHERE shop_id = ?";
		boolean accept = false;
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				
				pstmt.setString(1, shop_id);
				ResultSet res = pstmt.executeQuery();
				
				res.next();
				accept = true;
				
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		return accept;
		
	}
	
	public boolean loginAdmin(String admin_id, String admin_password) {
		
		String sql = "SELECT admin_password FROM m_user WHERE admin_id = ?";
		boolean accept = false;
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				
				pstmt.setString(1, admin_id);
				ResultSet res = pstmt.executeQuery();
				
				res.next();
				accept = true;
				
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		return accept;
		
	}
	
	public List<UserBean> getUserList() {
		
	}
	
	public List<ShopBean> getShopList() {
		
		
		
	}
	
	public void insertNewUser(UserBean user) {
		
		String sql1 = "INSERT INTO m_user VALUES (?, ?, ?, ?, ?)";
		String sql2 = "INSERT INTO m_user VALUES (?, ?, ?, NULL, ?)";
		
		try (Connection con = ConnectionManager.getConnection()) {
			
			boolean flag = false;
			
			try {
				
				user.getUser_genre();
				
				flag = true;
				
			} catch (NullPointerException e) {
				
			}
			
			PreparedStatement pstmt;
			
			if (flag) {
				
				pstmt = con.prepareStatement(sql1);
				
				pstmt.setString(4, user.getUser_genre());
				
			} else {
				
				pstmt = con.prepareStatement(sql2);
				
			}
			
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_name());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(5, user.getUser_adress());
			
			pstmt.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void insertNewShop(ShopBean shop) throws ClassNotFoundException, SQLException {
		String sql = "NSERT INTO m_shop VALUES (?, ?, ?, ?, ?)";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			ShopBean bean = new ShopBean();
			String shop_id = bean.getShop_id();
			String shop_name = bean.getShop_name();
			String shop_password = bean.getShop_password();
			String shop_adress = bean.getShop_adress();
			String shop_tel = bean.getShop_tel();

			pstmt.setString(1, shop_id);
			pstmt.setString(2, shop_name);
			pstmt.setString(3, shop_password);
			pstmt.setString(4, shop_adress);
			pstmt.setString(5, shop_tel);
			
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
			String user_adress = bean.getUser_adress();
			
			pstmt.setString(1, user_name);
			pstmt.setString(2, password);
			pstmt.setString(3, user_genre);
			pstmt.setString(4, user_adress);
			pstmt.setString(5, user_id);
			
			pstmt.executeUpdate();
		}
	}
	
	public void UpdateShop(ShopBean shop) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE m_shop SET user_name = ?, password = ?, user_genre = ?, user_adress = ? WHERE user_id = ?";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			ShopBean bean = new ShopBean();
			String shop_id = bean.getShop_id();
			String shop_name = bean.getShop_name();
			String shop_password = bean.getShop_password();
			String shop_adress = bean.getShop_adress();
			String shop_tel = bean.getShop_tel();
			
			pstmt.setString(1, shop_name);
			pstmt.setString(2, shop_password);
			pstmt.setString(3, shop_adress);
			pstmt.setString(4, shop_tel);
			pstmt.setString(5, shop_id);
			
			pstmt.executeUpdate();
		}
	}
	
	public void UpdateAdmin(AdminBean admin) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE m_admin SET admin_password = ? WHERE admin_id = ?";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			AdminBean bean = new AdminBean();

			String admin_id = bean.getAdmin_id();
			String admin_password = bean.getAdmin_password();
			
			pstmt.setString(1, admin_id);
			pstmt.setString(2, admin_password);
			
			pstmt.executeUpdate();
		}
	}
	
	public void deleteUser(String user_id) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM m_user WHERE user_id = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			UserBean bean = new UserBean();
			user_id = bean.getUser_id();

			pstmt.setString(1, user_id);

			pstmt.executeUpdate();
		}
	}
	
	public void deleteShop(String shop_id) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM m_shop WHERE shop_id = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			ShopBean bean = new ShopBean();
			shop_id = bean.getShop_id();

			pstmt.setString(1, shop_id);

			pstmt.executeUpdate();
		}
	}
	
	public List<UserBean> getUserAccount() throws SQLException, ClassNotFoundException {
		List<UserBean> userList = new ArrayList<UserBean>();
		String sql = "SELECT * FROM m_user";
		
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)) {

			while (res.next()) {
				String user_id = res.getString("user_id");
				String user_name = res.getString("user_name");
				String password = res.getString("password");
				String user_genre = res.getString("user_genre");
				String user_address = res.getString("user_adress");

				UserBean user = new UserBean();
				user.setUser_id(user_id);
				user.setUser_name(user_name);
				user.setPassword(password);
				user.setUser_genre(user_genre);
				user.setUser_address(user_address);

				userList.add(user);
			}
		}
		return userList;
	}
	
	public List<ShopBean> getShopAccount() throws SQLException, ClassNotFoundException {
		List<ShopBean> shopList = new ArrayList<ShopBean>();
		String sql = "SELECT * FROM m_shop";
		
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)) {

			while (res.next()) {
				String shop_id = res.getString("shop_id");
				String shop_name = res.getString("shop_name");
				String shop_password = res.getString("shop_password");
				String shop_adress = res.getString("shop_adress");
				String shop_tel = res.getString("shop_tel");

				ShopBean shop = new ShopBean();
				shop.setShop_id(shop_id);
				shop.setShop_name(shop_name);
				shop.setShop_password(shop_password);
				shop.setShop_adress(shop_adress);
				shop.setShop_tel(shop_tel);

				shopList.add(shop);
			}
		}
		return shopList;
	}
	
	public List<AdminBean> getAdminAccount() throws SQLException, ClassNotFoundException {
		List<AdminBean> adminList = new ArrayList<AdminBean>();

		String sql = "SELECT * FROM m_admin";

		try(Connection con = ConnectionManager.getConnection();
				Statement stmt =  con.createStatement();
				ResultSet res = stmt.executeQuery(sql)){

			while(res.next()) {
				AdminBean admin = new AdminBean();
				admin.setAdmin_id(res.getString("admin_id"));
				admin.setAdmin_password(res.getString("admin_password"));
				adminList.add(admin);
			}
		}

		return adminList;
	}

}
