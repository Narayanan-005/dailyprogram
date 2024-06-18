import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams1(strs.clone()));
        System.out.println(groupAnagrams2(strs));
        System.out.println(groupAnagrams3(strs));
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> list = new ArrayList();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("-1")) {
                continue;
            }
            List<String> li = new ArrayList();
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[j].equals("-1")) {
                    continue;
                }
                if (anagram(strs[i], strs[j])) {
                    li.add(strs[j]);
                    strs[j] = "-1";
                }
            }
            li.add(strs[i]);
            list.add(li);
        }
        return list;
    }

    public static boolean anagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int count[] = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i) - 'a']++;
            count[str2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList());
            }
            map.get(sortedStr).add(str);
        }
        return new ArrayList(map.values());
    }

    public static List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] sortArr = new char[26];
            char[] arr = str.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                sortArr[arr[i] - 'a']++;
            }
            String sortStr = new String(sortArr);
            if (!map.containsKey(sortStr)) {
                map.put(sortStr, new ArrayList());
            }
            map.get(sortStr).add(str);
        }
        return new ArrayList(map.values());
    }
}
