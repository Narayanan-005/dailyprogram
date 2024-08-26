public class SplitaStringinBalancedStrings {
    public static void main(String[] args) {
        System.out.println(splitaStringinBalancedStrings1("RLRRLLRLRL"));
        System.out.println(splitaStringinBalancedStrings2("RLRRLLRLRL"));
    }

    private static int splitaStringinBalancedStrings1(String s) {
        int countR = 0;
        int countL = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                countL++;
            } else {
                countR++;
            }
            if (countL == countR) {
                res++;
                countL = 0;
                countR = 0;
            }
        }
        return res;
    }

    private static int splitaStringinBalancedStrings2(String s) {
        int[] count = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                count[i + 1] = count[i] + 1;
            } else {
                count[i + 1] = count[i] - 1;
            }
        }
        int res = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) {
                res++;
            }
        }
        return res;
    }
}

