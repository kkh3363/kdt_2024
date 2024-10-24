package ch08;

public class Product {
	private String id;
	private String name;
	private String maker;
	private int price;
	private String date;
	
	
	public Product(String id, String name, String maker, int price, String date) {
		this.id = id;
		this.name = name;
		this.maker = maker;
		this.price = price;
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
