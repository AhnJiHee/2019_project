package vo;

public class MemberVO {

	String id;
	String password;
	String name;
	String phone;
	String email;
	
	public MemberVO(String id, String password, String name, String phone, String email) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}
	
}
