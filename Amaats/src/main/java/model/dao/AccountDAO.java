package model.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import model.entity.ShopBean;

public class AccountDAO {
	
	public boolean login(String user_id, String password) {
		
		
		
	}
	
	public boolean loginShop(String shop_id, String shop_password) {
		
		
		
	}
	
	public boolean loginAdmin(String admin_id, String admin_password) {
		
		
		
	}
	
	public void logout() {
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
	}
	
	public List<UserBean> getUserList() {
		
		
		
	}
	
	public List<ShopBean> getShopList() {
		
		
		
	}
	
	public void insertNewUser(UserBean user) {
		
		
		
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
