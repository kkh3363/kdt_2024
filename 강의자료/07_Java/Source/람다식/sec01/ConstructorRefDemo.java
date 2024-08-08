package sec01;

interface NewObject<T> {
    T getObject(T o);
}

interface NewArray<T> {
    T[] getArray(int size);
}

public class ConstructorRefDemo {
    public static void main(String[] args) {
        NewObject<String> s;
        NewArray<Integer> i;

//        s = x -> new String(x);
        s = String::new;
        String str = s.getObject("사과");

//        i = x -> new Integer[x];
        i = Integer[]::new;
        Integer[] array = i.getArray(2);
        array[0] = 10;
        array[1] = 20;
    }
}
