public class GreatestCommonDivisorofStrings {
    public static void main(String[] args) {
        System.out.println(greatestCommonDivisorofStrings1("ABCABC", "ABC"));
        System.out.println(greatestCommonDivisorofStrings2("ABCABC", "ABC"));
    }

    private static String greatestCommonDivisorofStrings1(String str1, String str2) {
        String res = "";
        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                String temp = str1.substring(0, i + 1);
                if (str1.replaceAll(temp, "").isEmpty() && str2.replaceAll(temp, "").isEmpty()) {
                    res = temp;
                }
            } else {
                break;
            }
        }
        return res;
    }

    private static String greatestCommonDivisorofStrings2(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
