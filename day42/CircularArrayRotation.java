import java.util.ArrayList;
import java.util.List;

public class CircularArrayRotation {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(4);
        a.add(5);
        List<Integer> a1 = new ArrayList<>(a);
        List<Integer> a2 = new ArrayList<>(a);
        List<Integer> queries = new ArrayList<>();
        queries.add(1);
        queries.add(2);
        List<Integer> queries1 = new ArrayList<>(queries);
        List<Integer> queries2 = new ArrayList<>(queries);
        System.out.println(circularArrayRotation1(a, 2, queries));
        System.out.println(circularArrayRotation2(a1, 2, queries1));
        System.out.println(circularArrayRotation3(a2, 2, queries2));
    }

    private static List<Integer> circularArrayRotation1(List<Integer> a, int k, List<Integer> queries) {
        int l = a.size();
        for (int i = 0; i < k; i++) {
            a.add(0, a.remove(l - 1));
        }
        for (int i = 0; i < queries.size(); i++) {
            queries.set(i, a.get(queries.get(i)));
        }
        return queries;
    }

    private static List<Integer> circularArrayRotation2(List<Integer> a, int k, List<Integer> queries) {
        int l = a.size();
        k = k % l;
        for (int i = 0; i < queries.size(); i++) {
            int index = queries.get(i) - k;
            if (index < 0) {
                index = l + index;
            }
            queries.set(i, a.get(index));
        }
        return queries;
    }

    private static List<Integer> circularArrayRotation3(List<Integer> a, int k, List<Integer> queries) {
        int l = a.size();
        k = k % l;
        a = swap(a, l - k, l - 1);
        a = swap(a, 0, l - k - 1);
        a = swap(a, 0, l - 1);
        for (int i = 0; i < queries.size(); i++) {
            queries.set(i, a.get(queries.get(i)));
        }
        return queries;
    }


    private static List<Integer> swap(List<Integer> list, int i, int j) {
        while (i < j) {
            int temp = list.get(j);
            list.set(j, list.get(i));
            list.set(i, temp);
            i++;
            j--;
        }
        return list;
    }
}
