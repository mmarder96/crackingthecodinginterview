package Data_Structures;

import java.util.Arrays;

public class ArrayListTest {
    public static ArrayList<Integer> arrayList;

    public static void main(String[] args) {

        arrayList = new ArrayList<>();

        // add elements to list
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);

        assert arrayList.get(0).equals(1);
        assert arrayList.get(5).equals(6);

        // remove elements from list
        arrayList.remove(1);

        assert arrayList.get(0).equals(1);
        assert arrayList.get(1).equals(3);
    }

}

class ArrayList<T> {
    private int size = 0;
    private static final int DEFAULT_CAP = 10;
    private Object array[];

    public ArrayList() {
        this.array = new Object[DEFAULT_CAP];
    }

    public void add(T t) {
        if (size == array.length) {
            doubleCap();
        }
        array[size] = t;
        this.size++;
    }

    private void doubleCap() {
        int newCap = array.length * 2;
        array = Arrays.copyOf(array, newCap);
    }

    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index != array.length) {
            for (int i=index; i<this.size-1; i++) {
                array[index] = array[index + 1];
            }
        }
        array[this.size] = null;
        this.size--;
    }

    public Object get(int index) {
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }
}