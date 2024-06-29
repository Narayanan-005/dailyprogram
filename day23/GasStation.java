public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(gasStation1(gas, cost));
        System.out.println(gasStation2(gas, cost));
        System.out.println(gasStation3(gas, cost));
    }

    private static int gasStation1(int[] gas, int[] cost) {
        int fuel = 0, index = -1, l = gas.length;
        for (int i = 0; i < l; i++) {
            fuel = 0;
            if (gas[i] != 0 && gas[i] >= cost[i]) {
                int j = i;
                int k = 0;
                while (k++ < l) {
                    fuel += gas[(j) % l] - cost[(j++) % l];
                    if (fuel < 0) break;
                    if (j == l) j = 0;
                }
                if (i == j && fuel >= 0) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    private static int gasStation2(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) {
            return -1;
        }
        int startStation = 0;
        int gasCount = 0;
        for (int i = 0; i < gas.length; i++) {
            gasCount += gas[i] - cost[i];
            if (gasCount < 0) {
                startStation = i + 1;
                gasCount = 0;
            }
        }
        return startStation;
    }

    private static int gasStation3(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int startStation = 0;
        int gasCount = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            gasCount += gas[i] - cost[i];
            if (gasCount < 0) {
                startStation = i + 1;
                gasCount = 0;
            }
        }
        if (totalGas < totalCost) {
            return -1;
        }
        return startStation;
    }
}
