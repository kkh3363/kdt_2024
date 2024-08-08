package rambda;

interface Negative {
    int neg(int x);

}

interface Printable {
    void print();
}

class classNega implements Negative {
	@Override
	public int neg(int x) {
		return -x;
	}
}

public class LambdaDemo2 {
	public static void main(String[] args) {
		Negative n;
		n = new classNega();
		
		n = (int x) -> {return -x;} ;
		n = (x) -> { return -x; };
		n = x -> { return -x; };
		n = (int x) -> -x;
		n = (x) -> -x;
		n = x -> -x;
		
		System.out.println(n.neg(10));
		// System.out.println(n.neg(10.1));
		
		Printable p;
		p = () -> { System.out.println("안녕!"); };
		p.print();
		p = () -> System.out.println("안녕!");
		p.print();
	}
}
