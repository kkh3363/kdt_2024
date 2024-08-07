package generic_package;

public class Cup<T> {
	private T beverage;
	public T getBeverage() {
        return beverage;
    }

    public void setBeverage(T beverage) {
        this.beverage = beverage;
    }
}
