import java.util.HashMap;
import java.util.Map;

public class RearrangeCharacterstoMakeTargetString {
    public static void main(String[] args) {
        System.out.println(rearrangeCharacterstoMakeTargetString1("abcba", "abc"));
        System.out.println(rearrangeCharacterstoMakeTargetString2("abcba", "abc"));
        System.out.println(rearrangeCharacterstoMakeTargetString3("abcba", "abc"));
    }

    private static int rearrangeCharacterstoMakeTargetString1(String s, String target) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap();
        for (char ch : s.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        for (char ch : target.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        int copies = s.length();
        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            Integer i = map1.get(entry.getKey());
            if (i != null) {
                copies = Math.min(copies, i / entry.getValue());
            } else {
                return 0;
            }
        }
        return copies;
    }

    private static int rearrangeCharacterstoMakeTargetString2(String s, String target) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (char ch : s.toCharArray()) {
            map1[ch - 'a']++;
        }
        for (char ch : target.toCharArray()) {
            map2[ch - 'a']++;
        }
        int copies = s.length();
        for (int i = 0; i < 26; i++) {
            if (map2[i] != 0) {
                if (map1[i] != 0) {
                    copies = Math.min(copies, map1[i] / map2[i]);
                } else {
                    return 0;
                }
            }
        }
        return copies;
    }

    private static int rearrangeCharacterstoMakeTargetString3(String s, String target) {
        int copies = s.length();
        int[] map = new int[26];
        for (char ch : target.toCharArray()) {
            map[ch - 'a']++;
        }
        for (int j = 0; j < 26; j++) {
            char ch = (char) (j + 'a');
            int i = map[j];
            if (i == 0) {
                continue;
            }
            int count = 0;
            int index = -1;
            while ((index = s.indexOf(ch, index + 1)) != -1) {
                count++;
            }
            if (count == 0) {
                return 0;
            }
            copies = Math.min(copies, count / i);
        }
        return copies;
    }
}
