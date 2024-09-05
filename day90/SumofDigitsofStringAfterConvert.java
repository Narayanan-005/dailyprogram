public class SumofDigitsofStringAfterConvert {
    public static void main(String[] args) {
        System.out.println(sumofDigitsofStringAfterConvert1("iiii", 1));
        System.out.println(sumofDigitsofStringAfterConvert2("iiii", 1));
    }

    private static int sumofDigitsofStringAfterConvert1(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append(ch - 'a' + 1);
        }
        int res = 0;
        while (k-- > 0) {
            res = 0;
            for (int i = 0; i < sb.length(); i++) {
                res += sb.charAt(i) - '0';
            }
            sb.setLength(0);
            sb.append(res);
        }
        return res;
    }

    private static int sumofDigitsofStringAfterConvert2(String s, int k) {
        int sum = 0;
        for (char ch : s.toCharArray()) {
            sum += getSum(ch - 'a' + 1);
        }
        while (k-- > 1) {
            sum = getSum(sum);
        }
        return sum;
    }

    private static int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

}
