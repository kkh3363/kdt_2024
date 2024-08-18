package sec07.exam03_view;

import javafx.beans.property.SimpleStringProperty;

public class Phone {
	private SimpleStringProperty smartPhone;
	private SimpleStringProperty image;
	
	public Phone() {
		this.smartPhone = new SimpleStringProperty();
		this.image = new SimpleStringProperty();
	}
	public Phone(String smartPhone, String image) {
		this.smartPhone = new SimpleStringProperty(smartPhone);
		this.image = new SimpleStringProperty(image);
	}
	
	public String getSmartPhone() {
		return smartPhone.get();
	}
	public void setSmartPhone(String smartPhone) {
		this.smartPhone.set(smartPhone);;
	}
	public String getImage() {
		return image.get();
	}
	public void setImage(String image) {
		this.image.set(image);;
	}
}
