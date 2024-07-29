import java.math.BigInteger;
import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(plusOne1(arr.clone())));
        System.out.println(Arrays.toString(plusOne2(arr.clone())));
        System.out.println(Arrays.toString(plusOne3(arr.clone())));
    }

    private static int[] plusOne1(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + carry;
            if (digits[i] == 10) {
                digits[i] = 0;
                carry = 1;
            } else {
                carry = 0;
                break;
            }
        }
        if (carry == 1) {
            return newArray(digits);
        }
        return digits;
    }

    private static int[] newArray(int[] arr) {
        int res[] = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            res[i + 1] = arr[i];
        }
        res[0] = 1;
        return res;
    }

    private static int[] plusOne2(int[] digits) {
        BigInteger num = BigInteger.valueOf(0);
        for (int i = 0; i < digits.length; i++) {
            num = num.multiply(BigInteger.valueOf(10));
            num = num.add(BigInteger.valueOf(digits[i]));
        }
        num = num.add(BigInteger.valueOf(1));
        return newArray2(num.toString());
    }

    private static int[] newArray2(String n) {
        int res[] = new int[n.length()];
        for (int i = 0; i < n.length(); i++) {
            res[i] = n.charAt(i) - '0';
        }
        return res;
    }

    private static int[] plusOne3(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
