import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SequenceEquation {
    public static void main(String[] args) {
        System.out.println(sequenceEquation1(List.of(5, 2, 1, 3, 4)));
        System.out.println(sequenceEquation2(List.of(5, 2, 1, 3, 4)));
        System.out.println(sequenceEquation3(List.of(5, 2, 1, 3, 4)));
    }

    private static List<Integer> sequenceEquation1(List<Integer> p) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < p.size(); i++) {
            list.add(p.indexOf(p.indexOf(i + 1) + 1) + 1);
        }
        return list;
    }

    private static List<Integer> sequenceEquation2(List<Integer> p) {
        List<Integer> lst = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        int[] arr = new int[p.size()];
        for (int i = 0; i < p.size(); i++) {
            arr[p.get(i) - 1] = i + 1;
            mp.put(p.get(i), i + 1);
        }
        for (int j : arr) {
            lst.add(mp.get(j));
        }
        return lst;
    }

    private static List<Integer> sequenceEquation3(List<Integer> p) {
        List<Integer> y = new ArrayList<Integer>();
        for (int x = 0; x < p.size(); x++)
            for (int k = 0; k < p.size(); k++)
                if (p.get(p.get(k) - 1) == x + 1)
                    y.add(k + 1);
        return y;
    }
}
