package product.dto;

public class ProductDTO {
	String pid;
	String pname;
	String categorycode;
	int price;
	int stock;
	String product_img;
	String product_regist;
	int product_hit;
	int product_reply_cnt;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getCategorycode() {
		return categorycode;
	}

	public void setCategorycode(String categorycode) {
		this.categorycode = categorycode;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getProduct_img() {
		return product_img;
	}

	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}

	public String getProduct_regist() {
		return product_regist;
	}

	public void setProduct_regist(String product_regist) {
		this.product_regist = product_regist;
	}

	public int getProduct_hit() {
		return product_hit;
	}

	public void setProduct_hit(int product_hit) {
		this.product_hit = product_hit;
	}

	public int getProduct_reply_cnt() {
		return product_reply_cnt;
	}

	public void setProduct_reply_cnt(int product_reply_cnt) {
		this.product_reply_cnt = product_reply_cnt;
	}
}
