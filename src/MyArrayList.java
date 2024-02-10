import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<E extends Comparable<E>> {

    private E[] data;
    private int capacity;
    private int size;
    private static final double GROW_FACTOR = 1.5;

    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
        this.data = (E[]) Array.newInstance(Comparable.class, this.capacity);
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.data = (E[]) Array.newInstance(Comparable.class, this.capacity);
    }

    public void add(E item) {
        if (this.size + 1 > this.capacity) {
            expandArray((int) (this.capacity * GROW_FACTOR));
        }
        this.data[size++] = item;
    }

    @SuppressWarnings("unchecked")
    public void addAll(Collection<Comparable<E>> o) {
        int newCapacity = this.size + o.size();
        if (this.capacity < newCapacity) {
            expandArray(newCapacity);
        }

        Object[] arr = o.toArray();

        for (int i = 0; i < arr.length; i++) {
            add((E) arr[i]);
        }
    }

    public E get(int index) throws ArrayIndexOutOfBoundsException {
        return this.data[index];
    }

    public boolean remove(int index) throws ArrayIndexOutOfBoundsException {
        if (get(index) == null) {
            return false;
        }

        if (index == this.size - 1) {
            this.data[index] = null;
            this.size--;
            return true;
        }

        this.data[index] = null;
        this.size--;
        for (int i = index; i < this.size; i++, index++) {
            this.data[index] = this.data[i + 1];
        }

        this.data[size] = null;

        return true;
    }

    private void expandArray(int targetCapacity) {
        @SuppressWarnings("unchecked")
        E[] data = (E[]) Array.newInstance(Comparable.class, targetCapacity);
        for (int i = 0; i < this.size; i++) {
            data[i] = this.data[i];
        }

        this.data = data;
        this.capacity = data.length;
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.capacity;
    }

    public void bubbleSort() {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < this.size; i++) {
                if (this.data[i].compareTo(this.data[i-1]) < 0) {
                    E temp = this.data[i];
                    this.data[i] = this.data[i-1];
                    this.data[i-1] = temp;
                    isSorted = false;
                }
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
