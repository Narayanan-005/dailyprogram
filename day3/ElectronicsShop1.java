public class ElectronicsShop1 {
    public static void main(String[] args) {
        int b = 60;
        int keyboards[] = {40, 50, 60};
        int drives[] = {5, 8, 12};
        System.out.println(getMoneySpent(keyboards, drives, b));
    }

    public static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int max = 0;
        for (int i = 0; i < keyboards.length; i++) {
            for (int j = 0; j < drives.length; j++) {
                if (keyboards[i] + drives[j] <= b) {
                    max = Math.max(max, keyboards[i] + drives[j]);
                }
            }
        }
        return max == 0 ? -1 : max;

    }
}
