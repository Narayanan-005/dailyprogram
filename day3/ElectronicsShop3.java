import java.util.Arrays;

public class ElectronicsShop3 {
    public static void main(String[] args) {
        int b = 60;
        int keyboards[] = {40, 50, 60};
        int drives[] = {5, 8, 12};
        System.out.println(getMoneySpent(keyboards, drives, b));
    }

    public static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int remains[] = new int[keyboards.length];
        for (int i = 0; i < remains.length; i++) {
            if (keyboards[i] <= b) {
                remains[i] = b - keyboards[i];
            } else {
                remains[i] = -1;
            }
        }
        boolean isValid = false;
        Arrays.sort(drives);
        for (int i = remains.length - 1; i >= 0; i--) {
            isValid = false;
            if (remains[i] == -1) {
                continue;
            }
            int j = drives.length - 1;
            while (j >= 0) {
                if (remains[i] >= drives[j]) {
                    remains[i] -= drives[j];
                    isValid = true;
                    break;
                }
                j--;
            }
            if (!isValid) {
                remains[i] = -1;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < remains.length; i++) {
            if (remains[i] != -1 && min > remains[i]) {
                min = remains[i];
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return b - min;
    }
}
