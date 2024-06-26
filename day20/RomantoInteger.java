import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
    public static void main(String[] args) {
        String str = "MCMXCIV";
        System.out.println(romantoInteger1(str));
        System.out.println(romantoInteger2(str));
        System.out.println(romantoInteger3(str));
    }

    private static int romantoInteger1(String str) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int tot = 0, l = str.length();
        for (int i = 0; i < l; i++) {
            if (i < l - 1 && str.charAt(i) == 'I' && (str.charAt(i + 1) == 'V' || str.charAt(i + 1) == 'X')) {
                tot += map.get(str.charAt(i + 1)) - map.get(str.charAt(i++));
            } else if (i < l - 1 && str.charAt(i) == 'X' && (str.charAt(i + 1) == 'L' || str.charAt(i + 1) == 'C')) {
                tot += map.get(str.charAt(i + 1)) - map.get(str.charAt(i++));
            } else if (i < l - 1 && str.charAt(i) == 'C' && (str.charAt(i + 1) == 'D' || str.charAt(i + 1) == 'M')) {
                tot += map.get(str.charAt(i + 1)) - map.get(str.charAt(i++));
            } else {
                tot += map.get(str.charAt(i));
            }
        }
        return tot;
    }

    private static int romantoInteger2(String str) {
        char[] romanChar = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] romanVal = {1, 5, 10, 50, 100, 500, 1000};

        int result = 0;
        int prevValue = 0;

        for (int i = str.length() - 1; i >= 0; i--) {
            char currChar = str.charAt(i);
            int currIndex = findIndex(romanChar, currChar);
            int currValue = romanVal[currIndex];

            if (currValue < prevValue) {
                result -= currValue;
            } else {
                result += currValue;
            }

            prevValue = currValue;
        }

        return result;
    }

    public static int findIndex(char[] arr, char target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private static int romantoInteger3(String str) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int tot = 0, l = str.length();
        for (int i = 0; i < l; i++) {
            int val = map.get(str.charAt(i));
            if (i + 1 < l && val < map.get(str.charAt(i + 1))) {
                tot -= val;
            } else {
                tot += val;
            }
        }
        return tot;
    }
}
