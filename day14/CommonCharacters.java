import java.util.ArrayList;
import java.util.List;

public class CommonCharacters {
    public static void main(String[] args) {
        String[] words = {"bella", "label", "roller"};
        System.out.println(commonCharacters1(words.clone()));
        System.out.println(commonCharacters2(words));
        System.out.println(commonCharacters3(words));
    }

    private static List<String> commonCharacters1(String[] words) {
        String word = words[0];
        List<String> list = new ArrayList();
        outer:
        for (int i = 0; i < word.length(); i++) {
            for (int j = 1; j < words.length; j++) {
                int index = words[j].indexOf(word.charAt(i));
                if (index != -1) {
                    words[j] = words[j].substring(0, index) + words[j].substring(index + 1);
                } else {
                    continue outer;
                }
            }
            list.add("" + word.charAt(i));
        }
        return list;
    }

    private static List<String> commonCharacters2(String[] words) {
        int count[] = count(words[0]);
        for (int i = 1; i < words.length; i++) {
            count = minCount(count, count(words[i]));
        }
        List<String> list = new ArrayList();
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                while (count[i]-- > 0) {
                    list.add(String.valueOf((char) (i + 'a')));
                }
            }
        }
        return list;
    }

    private static int[] count(String word) {
        int[] count = new int[26];
        for (int i = 0; i < word.length(); i++) {
            count[word.charAt(i) - 'a']++;
        }
        return count;
    }

    private static int[] minCount(int arr1[], int arr2[]) {
        int[] temp = new int[26];
        for (int i = 0; i < 26; i++) {
            temp[i] = Math.min(arr1[i], arr2[i]);
        }
        return temp;
    }

    private static List<String> commonCharacters3(String[] words) {
        int count[][] = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            count[i] = count(words[i]);
        }
        List<String> list = new ArrayList();
        for (int i = 0; i < 26; i++) {
            int cnt = count[0][i];
            for (int j = 1; j < words.length; j++) {
                cnt = Math.min(cnt, count[j][i]);
            }
            while (cnt-- > 0) {
                list.add(String.valueOf((char) (i + 'a')));
            }
        }
        return list;
    }
}
