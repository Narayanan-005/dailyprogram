public class WaterBottles {
    public static void main(String[] args) {
        System.out.println(waterBottles1(9, 3));
        System.out.println(waterBottles2(9, 3));
    }

    private static int waterBottles1(int numBottles, int numExchange) {
        int drinked = 0;
        while (numBottles != 0) {
            int q = numBottles / numExchange;
            int r = numBottles % numExchange;
            numBottles = q + r;
            drinked += q * numExchange;
            if (q == 0) {
                break;
            }
        }
        drinked += numBottles;
        return drinked;
    }

    private static int waterBottles2(int numBottles, int numExchange) {
        return numBottles + ((numBottles - 1) / (numExchange - 1));
    }
}
