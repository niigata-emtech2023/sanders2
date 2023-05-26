package model.entity;

import java.io.Serializable;

public class AdminBean implements Serializable{
	private String admin_id;
	private String admin_password;

	/*コンストラクタ*/
	public AdminBean() {

	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	
}
