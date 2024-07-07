import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WeightedUniformStrings {
    public static void main(String[] args) {
        String s = "abccddde";
        List<Integer> list = List.of(6, 1, 3, 12, 5, 9, 10);
        System.out.println(weightedUniformStrings1(s, list));
        System.out.println(weightedUniformStrings2(s, list));
    }

    private static List<String> weightedUniformStrings1(String s, List<Integer> queries) {
        Set<Integer> set = new HashSet<>();
        int val = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                val += s.charAt(i - 1) - 'a' + 1;
                set.add(val);
            } else {
                val += s.charAt(i - 1) - 'a' + 1;
                set.add(val);
                val = 0;
            }
        }
        val += s.charAt(s.length() - 1) - 'a' + 1;
        set.add(val);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            if (set.contains(queries.get(i))) {
                list.add("Yes");
            } else {
                list.add("No");
            }
        }
        return list;
    }

    private static List<String> weightedUniformStrings2(String s, List<Integer> queries) {
        int l = s.length();
        int val = 0;
        List<String> list = new ArrayList();
        for (int i = 0; i < queries.size(); i++) {
            list.add("No");
        }
        for (int i = 1; i < l; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                val += s.charAt(i - 1) - 'a' + 1;
                find(val, queries, list);
            } else {
                val += s.charAt(i - 1) - 'a' + 1;
                find(val, queries, list);
                val = 0;
            }
            if (i == l - 1) {
                val += s.charAt(l - 1) - 'a' + 1;
                find(val, queries, list);
            }
        }
        return list;
    }

    public static void find(int val, List<Integer> list, List<String> res) {
        if (list.contains(val)) {
            int index = list.indexOf(val);
            res.set(index, "Yes");
        }
    }
}
