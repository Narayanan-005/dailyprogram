import java.util.Scanner;

public class IntToBinary {
    public static void main(String[] args) {
        System.out.println("Enter the number from 1 to 1023");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        intToBinary1(n);
        intToBinary2(n);
        intToBinary3(n);
    }

    public static void intToBinary1(int n) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        while (n > 0) {
            int digit = n % 2;
            if (digit == 1) {
                count++;
            }
            builder.insert(0, digit);
            n /= 2;
        }
        int remains = 10 - builder.length();
        for (int i = 0; i < remains; i++) {
            builder.insert(0, "0");
        }
        System.out.println(builder.toString());
        System.out.println("Count of 1's is :" + count);
    }

    public static void intToBinary2(int n) {
        String binary = recursion(n);
        int count = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                count++;
            }
        }
        if (binary.length() < 10) {
            binary = "0".repeat(10 - binary.length()) + binary;
        }
        System.out.println(binary);
        System.out.println("Count of 1's is :" + count);
    }

    public static String recursion(int n) {
        if (n == 0) {
            return "";
        }
        return recursion(n / 2) + n % 2;
    }

    public static void intToBinary3(int n) {
        int binary = 0;
        int bits = 0;
        int countOnes = 0;
        while (n > 0) {
            int digit = n % 2;
            if (digit == 1) {
                countOnes++;
            }
            bits++;
            binary = binary * 10 + digit;
            n /= 2;
        }
        int remainBit = 10 - bits;
        while (remainBit-- > 0) {
            System.out.print(0);
        }
        while (bits-- > 0) {
            System.out.print(binary % 10);
            binary /= 10;
        }
        System.out.println();
        System.out.println("Count of 1's is :" + countOnes);
    }
}
