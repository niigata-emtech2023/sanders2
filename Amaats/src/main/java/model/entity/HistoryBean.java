package model.entity;


import java.io.Serializable;
import java.sql.Timestamp;

public class HistoryBean implements Serializable{
	private String user_id;
	private String sweets_id;
	private Timestamp history_time;
	private int history_num;

	/*コンストラクタ*/
	public HistoryBean() {

	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getSweets_id() {
		return sweets_id;
	}

	public void setSweets_id(String sweets_id) {
		this.sweets_id = sweets_id;
	}

	public Timestamp getHistory_time() {
		return history_time;
	}

	public void setHistory_time(Timestamp history_time) {
		this.history_time = history_time;
	}

	public int getHistory_num() {
		return history_num;
	}

	public void setHistory_num(int history_num) {
		this.history_num = history_num;
	}

}
