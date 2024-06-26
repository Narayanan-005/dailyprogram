import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IntegertoRoman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(integertoRoman1(n));
        System.out.println(integertoRoman2(n));
    }

    private static String integertoRoman1(int num) {
        Map<Integer, Character> map = new HashMap<>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
        StringBuilder res = new StringBuilder();
        int temp = 1;
        while (num != 0) {
            int rem = num % 10;
            if (rem == 0) {
                temp *= 10;
                num /= 10;
                continue;
            }
            if (rem == 4 || rem == 9) {
                rem *= temp;
                res.insert(0, map.get(temp + rem));
                res.insert(0, map.get(temp));
            } else {
                if (rem == 2) {
                    res.insert(0, map.get(temp) + "" + map.get(temp));
                } else if (rem == 3) {
                    res.insert(0, map.get(temp) + "" + map.get(temp) + "" + map.get(temp));
                } else if (rem == 6) {
                    rem *= temp;
                    res.insert(0, map.get(temp));
                    res.insert(0, map.get(rem - temp));
                } else if (rem == 7) {
                    rem *= temp;
                    res.insert(0, map.get(temp));
                    res.insert(0, map.get(temp));
                    res.insert(0, map.get(rem - (2 * temp)));
                } else if (rem == 8) {
                    rem *= temp;
                    res.insert(0, map.get(temp));
                    res.insert(0, map.get(temp));
                    res.insert(0, map.get(temp));
                    res.insert(0, map.get(rem - (3 * temp)));
                } else {
                    rem *= temp;
                    res.insert(0, map.get(rem));
                }
            }
            temp *= 10;
            num /= 10;
        }
        return res.toString();
    }

    private static String integertoRoman2(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                num -= values[i];
                res.append(symbols[i]);
            }
        }
        return res.toString();
    }
}
