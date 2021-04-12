package models;

public class Address {
	
	private String type;
	private String name;
	private String number;
	private String others;
	private String state;
	private String city;
	private String district;
	private String cp;
	private String country;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String type, String name, String number, String others, String state, String city, String district,
			String cp, String country) {
		super();
		this.type = type;
		this.name = name;
		this.number = number;
		this.others = others;
		this.state = state;
		this.city = city;
		this.district = district;
		this.cp = cp;
		this.country = country;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [type=" + type + ", name=" + name + ", number=" + number + ", others=" + others + ", state="
				+ state + ", city=" + city + ", district=" + district + ", cp=" + cp + ", country=" + country + "]";
	}
	
	
}
