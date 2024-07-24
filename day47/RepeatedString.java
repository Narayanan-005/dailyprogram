public class RepeatedString {
    public static void main(String[] args) {
        System.out.println(repeatedString1("abcac", 10));
        System.out.println(repeatedString2("abcac", 10));
    }

    private static long repeatedString1(String s, long n) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < n) {
            sb.append(s);
        }
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == 'a') {
                count++;
            }
        }
        return count;
    }

    private static long repeatedString2(String s, long n) {
        int countA = 0;
        int l = s.length();
        long count = 0;
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == 'a') {
                countA++;
            }
            if (n % l == i + 1) {
                count = countA;
            }
        }
        count += (n / l) * countA;
        return count;
    }


}
