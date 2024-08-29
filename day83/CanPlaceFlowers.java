public class CanPlaceFlowers {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers1(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(canPlaceFlowers2(new int[]{1, 0, 0, 0, 1}, 1));
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
        int i = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 1)
                i += 2;
            else {
                if ((i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1;
                    n--;
                    i += 2;
                } else {
                    i++;
                }
            }
            if (n == 0)
                return true;
        }
        return false;
    }

}
