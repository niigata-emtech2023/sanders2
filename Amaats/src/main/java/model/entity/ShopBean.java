package model.entity;

import java.io.Serializable;

public class ShopBean implements Serializable{
	private String shop_id;
	private String shop_name;
	private String shop_password;
	private String shop_adress;
	private String shop_tel;
	
	/*コンストラクタ*/
	public ShopBean() {
		
	}

	public String getShop_id() {
		return shop_id;
	}

	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public String getShop_password() {
		return shop_password;
	}

	public void setShop_password(String shop_password) {
		this.shop_password = shop_password;
	}

	public String getShop_adress() {
		return shop_adress;
	}

	public void setShop_adress(String shop_adress) {
		this.shop_adress = shop_adress;
	}

	public String getShop_tel() {
		return shop_tel;
	}

	public void setShop_tel(String shop_tel) {
		this.shop_tel = shop_tel;
	}
	
	
}