import java.util.*;

public class MostCommonWord {
    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord1(paragraph, banned));
        System.out.println(mostCommonWord2(paragraph, banned));
        System.out.println(mostCommonWord3(paragraph, banned));
    }

    private static String mostCommonWord1(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().replaceAll("[^a-zA-Z]", " ");
        for (int i = 0; i < banned.length; i++) {
            paragraph = paragraph.replaceAll(banned[i], "");
        }
        paragraph = paragraph.trim();
        String[] strs = paragraph.split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            map.put(strs[i], map.getOrDefault(strs[i], 0) + 1);
        }
        String res = null;
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

    private static String mostCommonWord2(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().replaceAll("[^a-zA-Z]", " ");
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        paragraph = paragraph.trim();
        String[] strs = paragraph.split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        String res = "";
        int max = 0;
        for (int i = 0; i < strs.length; i++) {
            if (set.contains(strs[i])) {
                continue;
            }
            Integer val = map.get(strs[i]);
            if (val == null) {
                val = 0;
            }
            map.put(strs[i], val + 1);
            if (val + 1 > max) {
                max = val + 1;
                res = strs[i];
            }
        }
        return res;
    }

    private static String mostCommonWord3(String paragraph, String[] banned) {
        StringTokenizer tokenizer = new StringTokenizer(paragraph, " .,;!?'");
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < banned.length; i++) {
            set.add(banned[i]);
        }
        String current = "";
        int max = 0;
        String res = "";
        while (tokenizer.hasMoreTokens()) {
            current = tokenizer.nextToken().toLowerCase();
            if (set.contains(current)) {
                continue;
            }
            Integer val = map.get(current);
            if (val == null) {
                val = 0;
            }
            map.put(current, val + 1);
            if (val + 1 > max) {
                max = val + 1;
                res = current;
            }
        }
        return res;
    }
}

