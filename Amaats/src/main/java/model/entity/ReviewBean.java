package model.entity;
import java.io.Serializable;


public class ReviewBean implements Serializable{
	private String review_id;
	private String review_text;
	private String user_id;
	private String sweets_id;

	/*コンストラクタ*/
	public ReviewBean() {

	}

	public String getReview_id() {
		return review_id;
	}

	public void setReview_id(String review_id) {
		this.review_id = review_id;
	}

	public String getReview_text() {
		return review_text;
	}

	public void setReview_text(String review_text) {
		this.review_text = review_text;
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

}
