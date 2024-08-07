package generic_package;


public class MethodDemo {
	static class Utils {
		public static <T> void showArray(T[] a) {
			for (T t : a)
				System.out.printf("%s", t);
			System.out.println();
		}
		public static <T> T getLast(T[] a) {
			return a[a.length-1];
		}
	}
	
	public static void main(String[] args) {
		Integer[] ia = { 1, 2, 3, 4, 5 };
		Character[] ca = { 'H', 'E', 'L', 'L', 'O' };

		Utils.showArray(ia);
		Utils.<Character>showArray(ca);

		System.out.println(Utils.getLast(ia));

	}

}
