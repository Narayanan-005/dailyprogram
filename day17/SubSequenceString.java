import java.util.ArrayList;
import java.util.List;

public class SubSequenceString {
    public static void main(String[] args) {
        String input = "abc";
        System.out.println(subSequenceString1(input, ""));
        System.out.println(subSequenceString2(input));
        System.out.println(subSequenceString3(input));
    }

    private static List<String> subSequenceString1(String str, String res) {
        if (str.isEmpty()) {
            List<String> li = new ArrayList<>();
            li.add(res);
            return li;
        }
        List<String> left = subSequenceString1(str.substring(1), res);
        List<String> right = subSequenceString1(str.substring(1), res + str.charAt(0));
        left.addAll(right);
        return left;
    }

    private static List<String> subSequenceString2(String str) {
        int l = str.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, l); i++) {
            String temp = "";
            for (int j = l - 1; j >= 0; j--) {
                if ((i >> j & 1) == 1) {
                    temp += str.charAt(l - 1 - j);
                }
            }
            list.add(temp);
        }
        return list;
    }

    private static List<String> subSequenceString3(String str) {
        List<String> list = new ArrayList<>();
        list.add("");

        for (char c : str.toCharArray()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                list.add(list.get(i) + c);
            }
        }

        return list;
    }

}
