public class ElectronicsShop2 {
    public static void main(String[] args) {
        int b = 60;
        int keyboards[] = {40, 50, 60};
        int drives[] = {5, 8, 12};
        System.out.println(getMoneySpent(keyboards, drives, b));
    }

    public static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int i = keyboards.length - 1;
        int j = 0;
        int max = -1;

        while (i >= 0 && j < drives.length) {
            int total = keyboards[i] + drives[j];

            if (total > max && total <= b) {
                max = total;
            }

            if (total > b) {
                i--;
            } else {
                j++;
            }


        }

        return max;
    }
}
