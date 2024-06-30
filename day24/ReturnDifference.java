import java.util.*;

public class ReturnDifference {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abcde";
        System.out.println(returnDifference1(s1, s2));
        System.out.println(returnDifference2(s1, s2));
        System.out.println(returnDifference3(s1, s2));
    }

    private static char returnDifference1(String str1, String str2) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str1.length(); i++) {
            set.add(str1.charAt(i));
        }
        for (int i = 0; i < str2.length(); i++) {
            if (!set.contains(str2.charAt(i))) {
                return str2.charAt(i);
            }
        }
        return ' ';
    }

    private static char returnDifference2(String str1, String str2) {
        List<String> list1 = new ArrayList<>(Arrays.asList(str1.split("")));
        List<String> list2 = new ArrayList<>(Arrays.asList(str2.split("")));
        list2.removeAll(list1);
        return list2.get(0).charAt(0);
    }

    private static char returnDifference3(String str1, String str2) {
        int ch = 0;
        int l = str1.length();
        ch ^= str2.charAt(l);
        for (int i = 0; i < l; i++) {
            ch ^= str1.charAt(i);
            ch ^= str2.charAt(i);
        }
        return (char) ch;
    }
}
