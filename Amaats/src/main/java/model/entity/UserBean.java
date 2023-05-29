package model.entity;

import java.io.Serializable;

public class UserBean implements Serializable {
	
	private String user_id;
	private String user_name;
	private String password;
	private String user_genre;
	private String user_adress;
	
	
	/* コンストラクタ */
	public UserBean() {
		
	}
	
	/* アクセサメソッド */
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_genre() {
		return user_genre;
	}

	public void setUser_genre(String user_genre) {
		this.user_genre = user_genre;
	}

	public String getUser_adress() {
		return user_adress;
	}

	public void setUser_address(String user_adress) {
		this.user_adress = user_adress;
	}
	
}
