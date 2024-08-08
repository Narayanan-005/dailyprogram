public class CalculateDigitSumofaString {
    public static void main(String[] args) {
        System.out.println(calculateDigitSumofaString1("11111222223", 3));
        System.out.println(calculateDigitSumofaString2("11111222223", 3));
    }

    private static String calculateDigitSumofaString1(String s, int k) {
        StringBuilder res = new StringBuilder(s);
        StringBuilder temp = new StringBuilder();
        while (res.length() > k) {
            int sum = 0;
            for (int i = 0; i < res.length(); i++) {
                sum += res.charAt(i) - '0';
                if ((i + 1) % k == 0 || i == res.length() - 1) {
                    temp.append(sum);
                    sum = 0;
                }
            }
            res.setLength(0);
            res.append(temp);
            temp.setLength(0);
        }
        return res.toString();
    }

    private static String calculateDigitSumofaString2(String s, int k) {
        while (s.length() > k) {
            s = recSum(s, k, 0);
        }
        return s;
    }

    private static String recSum(String s, int k, int index) {
        if (index >= s.length()) {
            return "";
        }
        int sum = 0;
        for (int i = index; i < s.length() && i < index + k; i++) {
            sum += s.charAt(i) - '0';
        }
        return String.valueOf(sum) + recSum(s, k, index + k);
    }

}
