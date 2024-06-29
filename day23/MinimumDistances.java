import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDistances {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(7);
        System.out.println(minimumDistances1(list));
        System.out.println(minimumDistances2(list));
        System.out.println(minimumDistances3(list));
    }

    private static int minimumDistances1(List<Integer> list) {
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    distance = Math.min(distance, (j - i));
                }
            }
        }
        return distance != Integer.MAX_VALUE ? distance : -1;
    }

    private static int minimumDistances2(List<Integer> list) {
        int distance = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Integer temp = map.get(list.get(i));
            if (temp != null) {
                distance = Math.min(distance, (i - temp));
            }
            map.put(list.get(i), i);
        }
        return distance == Integer.MAX_VALUE ? -1 : distance;
    }

    private static int minimumDistances3(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i; j++) {
                if (list.get(j).equals(list.get(j + i))) {
                    return i;
                }
            }
        }
        return -1;
    }

}
