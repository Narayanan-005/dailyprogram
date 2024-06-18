import java.util.Scanner;

public class LenghtOfLastWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(lenghtOfLastWord1(str));
        System.out.println(lenghtOfLastWord2(str));
        System.out.println(lenghtOfLastWord3(str));
    }

    public static int lenghtOfLastWord1(String str) {
        str = str.strip();
        String arr[] = str.split(" ");
        return arr[arr.length - 1].length();
    }

    public static int lenghtOfLastWord2(String str) {
        str = str.trim();
        return str.length() - str.lastIndexOf(" ") - 1;
    }

    public static int lenghtOfLastWord3(String str) {
        int length = 0;
        boolean alphabet = false;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (Character.isAlphabetic(str.charAt(i))) {
                length++;
                alphabet = true;
            } else if (alphabet && str.charAt(i) == ' ') {
                break;
            }
        }
        return length;
    }
}
