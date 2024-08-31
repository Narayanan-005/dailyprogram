import java.util.HashMap;
import java.util.Map;

public class NumberofSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        System.out.println(numberofSubstringsContainingAllThreeCharacters1("abcabc"));
        System.out.println(numberofSubstringsContainingAllThreeCharacters2("abcabc"));
        System.out.println(numberofSubstringsContainingAllThreeCharacters3("abcabc"));
    }

    private static int numberofSubstringsContainingAllThreeCharacters1(String s) {
        int count = 0;
        int l = s.length();
        int a = 0, b = 0, c = 0;
        char ch[] = s.toCharArray();
        for (int i = 0; i < l; i++) {
            for (int j = i; j < l; j++) {
                if (ch[j] == 'a') {
                    a++;
                } else if (ch[j] == 'b') {
                    b++;
                } else {
                    c++;
                }
                if (a != 0 && b != 0 && c != 0) {
                    count += l - j;
                    break;
                }
            }
            a = 0;
            b = 0;
            c = 0;
        }
        return count;
    }

    private static int numberofSubstringsContainingAllThreeCharacters2(String s) {
        int count = 0, l = s.length();
        int i = 0, j = 0;
        Map<Character, Integer> map = new HashMap();
        char ch[] = s.toCharArray();
        while (i <= j) {
            while (j < l && map.size() != 3) {
                map.put(ch[j], map.getOrDefault(ch[j], 0) + 1);
                j++;
            }
            if (map.size() == 3) {
                count += l - j + 1;
            } else {
                break;
            }
            Integer val = map.get(ch[i]);
            if (val == 1) {
                map.remove(ch[i]);
            } else {
                map.put(ch[i], val - 1);
            }
            i++;
        }
        return count;
    }

    private static int numberofSubstringsContainingAllThreeCharacters3(String s) {
        int count = 0, l = s.length();
        int i = 0, j = 0;
        int a = 0, b = 0, c = 0;
        char ch[] = s.toCharArray();
        while (i <= j) {
            while (j < l && (a == 0 || b == 0 || c == 0)) {
                if (ch[j] == 'a') a++;
                else if (ch[j] == 'b') b++;
                else c++;
                j++;
            }
            if (a != 0 && b != 0 && c != 0) {
                count += l - j + 1;
            } else {
                break;
            }
            if (ch[i] == 'a') a--;
            else if (ch[i] == 'b') b--;
            else c--;
            i++;
        }
        return count;
    }
}
