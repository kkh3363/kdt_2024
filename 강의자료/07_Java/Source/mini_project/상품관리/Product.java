package chap14.sec04;

import java.text.MessageFormat;

public class Product {
	private int pno;
	private String name;
	private int price;
	private int stock;
	private int sale;
	
	public Product() {}

	public int getPno() { return pno; }
	public void setPno(int pno) { this.pno = pno; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }
	
	public int getStock() { return stock; }
	public void setStock(int stock) { this.stock = stock; }
	
	public int getSale() { return sale; }
	public void setSale(int sale) { this.sale = sale; }
	
	public String productString() {
		String str = MessageFormat.format("{0},{1},{2},{3},{4}"
				, String.valueOf(getPno())
				, getName()
				, String.valueOf(getPrice())
				, String.valueOf(getStock())
				, String.valueOf(getSale()));
		return str;
	}
}
/*
1001,마우스, 10000,5,0
1002, 키보드,20000,10,0
1003,웹캠,30000,2,0
1004,모니터,120000,5,0
*/
1005,공유기,40000,3,0
