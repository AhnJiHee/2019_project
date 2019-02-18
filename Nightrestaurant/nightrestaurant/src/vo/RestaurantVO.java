package vo;

public class RestaurantVO {
	
	String province;
	String address;
	String closetime;
	String name;
	String tag;
	String keyword;
	String lon;
	String lat;
	
	public RestaurantVO() {
	}
	
	public RestaurantVO(String province, String address, String closetime, String name) {
		this.province = province;
		this.address = address;
		this.closetime = closetime;
		this.name = name;
	}
	
	public RestaurantVO(String province, String address, String closetime, String name, String tag, String keyword) {
		this.province = province;
		this.address = address;
		this.closetime = closetime;
		this.name = name;
		this.tag = tag;
		this.keyword = keyword;
	}
	
	public RestaurantVO(String province, String address, String closetime, String name, String tag, String keyword,String lon, String lat) {
		this.province = province;
		this.address = address;
		this.closetime = closetime;
		this.name = name;
		this.tag = tag;
		this.keyword = keyword;
		this.lon = lon;
		this.lat = lat;
	
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getClosetime() {
		return closetime;
	}

	public void setClosetime(String closetime) {
		this.closetime = closetime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String toString() {
		return "RestaurantVO [province=" + province + ", address=" + address + ", closetime=" + closetime + ", name="
				+ name + ", tag=" + tag + ", keyword=" + keyword + "]";
	}
	
	

	

	
}
