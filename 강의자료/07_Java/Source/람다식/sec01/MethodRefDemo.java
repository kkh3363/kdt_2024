package sec01;

interface Mathematical {
    double calculate(double d);
}

interface Pickable {
    char pick(String s, int i);
}

interface Computable {
    int compute(int x, int y);
}

class Utils {
    int add(int a, int b) {
        return a + b;
    }
}

//interface Applyable {
//    boolean apply(Box a, Box b);
//}
//
//class Box {
//    int no;
//
//    public Box(int no) {
//        this.no = no;
//    }
//
//    boolean isSame(Box b) {
//        return this.no == b.no;
//    }
//}

public class MethodRefDemo {
    public static void main(String[] args) {
        Mathematical m;
        Pickable p;
        Computable c;

//        m = d -> Math.abs(d);
        m = Math::abs;
        System.out.println(m.calculate(-50.3));

//        p = (a, b) -> a.charAt(b);
        p = String::charAt;
        System.out.println(p.pick("안녕, 인스턴스 메서드 참조!", 4));

        Utils utils = new Utils();
//        c = (a, b) -> utils.add(a, b);
        c = utils::add;
        System.out.println(c.compute(20, 30));

//        Applyable app;
////        app = (a, b) -> a.isSame(b);
//        app = Box::isSame;
//        System.out.println(app.apply(new Box(1), new Box(2)));
//        System.out.println(app.apply(new Box(1), new Box(1)));
    }
}
