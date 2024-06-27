import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(sortCharactersByFrequency1(input));
        System.out.println(sortCharactersByFrequency2(input));
        System.out.println(sortCharactersByFrequency3(input));
    }

    private static String sortCharactersByFrequency1(String s) {
        int[][] count = new int[62][2];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isUpperCase(ch)) {
                count[ch - 'A' + 26][0] = ch;
                count[ch - 'A' + 26][1]++;
            } else if (Character.isLowerCase(ch)) {
                count[ch - 'a'][0] = ch;
                count[ch - 'a'][1]++;
            } else {
                count[ch - '0' + 52][0] = ch;
                count[ch - '0' + 52][1]++;
            }
        }
        Arrays.sort(count, (a, b) -> b[1] - a[1]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 62; i++) {
            if (count[i][0] != 0) {
                char ch = (char) count[i][0];
                while (count[i][1]-- > 0) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

    private static String sortCharactersByFrequency2(String s) {
        int[] count = new int[128];
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int i = 0; i < arr.length; ) {
            char ch = '.';
            for (int j = 0; j < 128; j++) {
                if (count[ch] < count[j]) {
                    ch = (char) j;
                }
            }
            while (count[ch]-- > 0) {
                arr[i++] = ch;
            }
        }
        return new String(arr);
    }

    private static String sortCharactersByFrequency3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (a, b) -> b.getValue().compareTo(a.getValue()));
        int i = 0;
        for (Map.Entry<Character, Integer> entry : list) {
            char key = entry.getKey();
            int val = entry.getValue();
            while (val-- > 0) {
                arr[i++] = key;
            }
        }
        return new String(arr);
    }
}
