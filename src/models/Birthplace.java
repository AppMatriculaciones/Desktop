package models;

public class Birthplace {

	private String country;
	private String city;
	
	public Birthplace() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Birthplace(String country, String city) {
		super();
		this.country = country;
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Birthplace [country=" + country + ", city=" + city + "]";
	}
	
	
}
