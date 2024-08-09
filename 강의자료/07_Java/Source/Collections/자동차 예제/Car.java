package chap13.exam_car;

public class Car {
	private String model;
    private String madeCompany;
    private int genYear;
    private int mileage;
    
    public Car() {}
    
    public Car(String model, String madeCompany, int genYear, int mileage) {
        this.model = model;
        this.madeCompany = madeCompany;
        this.genYear = genYear;
        this.mileage = mileage;
    } 
    public void setModel(String model) {
    	this.model = model;
    }
    public String getModel() {
        return model;
    }

    public String getMadeCompany() {
        return madeCompany;
    }
    public void setMadeCompany(String madeCompany) {
    	this.madeCompany = madeCompany;
    }
    public int getGenYear() {
        return genYear;
    }
    public void setGetnYear(int genYear) {
    	this.genYear = genYear;
    }

    public void setMileage(int mileage) {
    	this.mileage = mileage;
    }
    public int getMileage() {
        return mileage;
    }

    public String toString() {
        return String.format("Car(%s, %s, %d, %d)", model, madeCompany, genYear, mileage);
    }
}
