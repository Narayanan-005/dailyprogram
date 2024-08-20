public class WaterBottlesII {
    public static void main(String[] args) {
        System.out.println(waterBottlesII1(13, 6));
        System.out.println(waterBottlesII2(13, 6));
    }

    private static int waterBottlesII1(int numBottles, int numExchange) {
        int drinked = 0;
        while (numBottles != 0) {
            int q = numBottles / numExchange;
            if (q == 0) {
                break;
            }
            numBottles -= numExchange - 1;
            drinked += numExchange;
            numExchange++;
        }
        drinked += numBottles;
        return drinked;
    }

    private static int waterBottlesII2(int numBottles, int numExchange) {
        int res = numBottles;
        int emptyBottles = numBottles;
        int fullBottles = 0;
        while (numExchange <= emptyBottles) {
            while (emptyBottles >= numExchange) {
                fullBottles++;
                emptyBottles -= numExchange;
                numExchange++;
            }
            res += fullBottles;
            emptyBottles += fullBottles;
            fullBottles = 0;
        }
        return res;
    }


}
