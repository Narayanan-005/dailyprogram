import java.util.Arrays;

public class ConvertIntegertotheSumofTwoNoZeroIntegers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(convertIntegertotheSumofTwoNoZeroIntegers1(11)));
        System.out.println(Arrays.toString(convertIntegertotheSumofTwoNoZeroIntegers2(11)));
    }

    private static int[] convertIntegertotheSumofTwoNoZeroIntegers1(int n) {
        int[] res = new int[2];
        for (int i = 1; i <= n / 2; i++) {
            if (isValid(i, n - i)) {
                res[0] = i;
                res[1] = n - i;
                break;
            }
        }
        return res;
    }

    private static boolean isValid(int n, int m) {
        while (n > 0) {
            if (n % 10 == 0) {
                return false;
            }
            n /= 10;
        }
        while (m > 0) {
            if (m % 10 == 0) {
                return false;
            }
            m /= 10;
        }
        return true;
    }

    private static int[] convertIntegertotheSumofTwoNoZeroIntegers2(int n) {
        for (int i = 1; i <= n / 2; i++) {
            if (!(i + "" + (n - i)).contains("0")) {
                return new int[]{i, n - i};
            }
        }
        return new int[2];
    }
}
