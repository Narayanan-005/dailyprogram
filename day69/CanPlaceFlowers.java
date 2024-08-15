public class CanPlaceFlowers {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers1(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(canPlaceFlowers2(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(canPlaceFlowers3(new int[]{1, 0, 0, 0, 1}, 1, 0));
    }

    private static boolean canPlaceFlowers1(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            int pre = (i == 0) ? 0 : flowerbed[i - 1];
            int post = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
            if (pre + flowerbed[i] + post == 0) {
                n--;
                i++;
            }
        }
        return n < 1;
    }

    private static boolean canPlaceFlowers2(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            boolean left = i == 0 || flowerbed[i - 1] == 0;
            boolean right = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;

            if (left && right && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n < 1;
    }

    private static boolean canPlaceFlowers3(int[] flowerbed, int n, int ind) {
        if (ind == flowerbed.length) {
            return n < 1;
        }
        if ((ind == 0 || flowerbed[ind - 1] == 0) && flowerbed[ind] == 0 && (ind == flowerbed.length - 1 || flowerbed[ind + 1] == 0)) {
            n--;
        }
        return canPlaceFlowers3(flowerbed, n, ind + 1);
    }
}
