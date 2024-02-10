import java.util.List;

public class Main {
    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(5);

        list.addAll(List.of(7,9,3,4,8));

        System.out.println(list);

        list.remove(3);

        System.out.println(list);

        list.bubbleSort();

        System.out.println(list);

        list.addAll(List.of(15,18,100,215,6,7,22,36));

        System.out.println(list);

        list.bubbleSort();

        System.out.println(list);
    }
}