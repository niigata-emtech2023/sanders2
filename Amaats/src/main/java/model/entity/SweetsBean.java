package model.entity;

import java.io.Serializable;

public class SweetsBean implements Serializable {

	private int sweets_id;
	private String sweets_name;
	private int sweets_value;
	private String sweets_genre;
	private String sweets_info;
	private String shop_id;
	
	/*コンストラクタ*/
	public SweetsBean() {
		
	}
	
	public int getSweets_id() {
		return sweets_id;
	}
	public void setSweets_id(int sweets_id) {
		this.sweets_id = sweets_id;
	}
	public String getSweets_name() {
		return sweets_name;
	}
	public void setSweets_name(String sweets_name) {
		this.sweets_name = sweets_name;
	}
	public int getSweets_value() {
		return sweets_value;
	}
	public void setSweets_value(int sweets_value) {
		this.sweets_value = sweets_value;
	}
	public String getSweets_genre() {
		return sweets_genre;
	}
	public void setSweets_genre(String sweets_genre) {
		this.sweets_genre = sweets_genre;
	}
	public String getSweets_info() {
		return sweets_info;
	}
	public void setSweets_info(String sweets_info) {
		this.sweets_info = sweets_info;
	}
	public String getShop_id() {
		return shop_id;
	}
	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}


}
