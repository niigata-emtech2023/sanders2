package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.entity.AdminBean;
import model.entity.ShopBean;
import model.entity.UserBean;

public class AccountDAO {
	
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
			pstmt.setString(5, user.getUser_address());
			
			pstmt.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
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
