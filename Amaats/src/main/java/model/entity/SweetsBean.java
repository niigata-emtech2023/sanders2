package model.entity;

import java.io.Serializable;

public class SweetsBean implements Serializable {
	
	private String sweets_id;
	private String name;
	private int price;
	
	/* コンストラクタ */
	public SweetsBean() {
		
	}
	
	/* アクセサメソッド */
	public String getSweets_id() {
		return sweets_id;
	}
	public void setSweets_id(String sweets_id) {
		this.sweets_id = sweets_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
