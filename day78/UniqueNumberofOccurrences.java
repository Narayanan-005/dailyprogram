import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberofOccurrences {
    public static void main(String[] args) {
        System.out.println(uniqueNumberofOccurrences1(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println(uniqueNumberofOccurrences2(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println(uniqueNumberofOccurrences3(new int[]{1, 2, 2, 1, 1, 3}));
    }

    private static boolean uniqueNumberofOccurrences1(int[] arr) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1001) {
                continue;
            }
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    arr[j] = 1001;
                }
            }
            if (set.contains(count)) {
                return false;
            }
            set.add(count);
        }
        return true;
    }

    private static boolean uniqueNumberofOccurrences2(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Set<Integer> set = new HashSet(map.values());
        return set.size() == map.size();
    }

    private static boolean uniqueNumberofOccurrences3(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int count[] = new int[arr.length + 1];
        for (Integer i : map.values()) {
            if (count[i] != 0) {
                return false;
            }
            count[i]++;
        }
        return true;
    }
}
