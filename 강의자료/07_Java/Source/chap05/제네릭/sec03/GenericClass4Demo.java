package sec03;

import java.util.ArrayList;

public class GenericClass4Demo {
    public static void main(String[] args) {
        ArrayList<Beverage> list1 = new ArrayList<>();
        list1.add(new Beer());                      // OK
        list1.add(new Boricha());                   // OK

        beverageTest(list1);

        ArrayList<Beer> list2 = new ArrayList<>();
        list2.add(new Beer());                      // OK
//        beverageTest(list2);
    }

    static public void beverageTest(ArrayList<?> al) { /* ... */ }
}