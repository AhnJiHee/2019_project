package vo;

public class ProductVO {
	int code;
	String name;
	int price;
	int balance;
	
	public ProductVO(int code, String name, int price, int balance) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.balance = balance;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
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
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String toString() {
		return code + "-" + name + "-" + price + "-" + balance;
	}
	
	
	
	
}
