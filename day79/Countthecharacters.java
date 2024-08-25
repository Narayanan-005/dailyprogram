import java.util.HashMap;
import java.util.Map;

public class Countthecharacters {
    public static void main(String[] args) {
        System.out.println(countthecharacters1("geeksforgeeks", 2));
        System.out.println(countthecharacters2("geeksforgeeks", 2));
    }

    private static int countthecharacters1(String S, int N) {
        Map<Character, Integer> map = new HashMap();
        char[] ch = S.toCharArray();
        for (int i = 1; i <= ch.length; i++) {
            if (i == ch.length || ch[i] != ch[i - 1]) {
                map.put(ch[i - 1], map.getOrDefault(ch[i - 1], 0) + 1);
            }
        }
        int res = 0;
        for (Integer i : map.values()) {
            if (i == N) {
                res++;
            }
        }
        return res;
    }

    private static int countthecharacters2(String S, int N) {
        int[] map = new int[26];
        char[] ch = S.toCharArray();
        for (int i = 1; i <= ch.length; i++) {
            if (i == ch.length || ch[i] != ch[i - 1]) {
                map[ch[i - 1] - 'a']++;
            }
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (map[i] == N) {
                res++;
            }
        }
        return res;
    }
}
