import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Gemstones {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("abc");
        list.add("bc");
        System.out.println(gemstones1(list));
        System.out.println(gemstones2(list));
    }

    private static int gemstones1(List<String> arr) {
        int count = 0;
        Set<String> set = new HashSet<>();
        int l = arr.size();
        for (String str : arr.get(0).split("")) {
            if (set.contains(str)) {
                continue;
            }
            int i = 1;
            for (; i < l; i++) {
                if (!arr.get(i).contains(str)) {
                    break;
                }
            }
            if (i == l) {
                count++;
            }
            set.add(str);
        }
        return count;
    }

    private static int gemstones2(List<String> arr) {
        int count = 0;
        int l = arr.size();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int i = 0;
            for (; i < l; i++) {
                if (!arr.get(i).contains("" + ch)) {
                    break;
                }
            }
            if (i == l) {
                count++;
            }
        }
        return count;
    }
}
