package sec03;

import sec03.generic.Cup;

public class GenericClass3Demo {
    public static void main(String[] args) {
        Cup c = new Cup();

        c.setBeverage(new Beer());

//        Beer beer = c.getBeverage();
        Beer beer = (Beer) c.getBeverage();
    }
}