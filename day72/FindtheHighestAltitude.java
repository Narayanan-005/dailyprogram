import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindtheHighestAltitude {
    public static void main(String[] args) {
        System.out.println(findtheHighestAltitude1(new int[]{-5, 1, 5, 0, -7}));
        System.out.println(findtheHighestAltitude2(new int[]{-5, 1, 5, 0, -7}));
        System.out.println(findtheHighestAltitude3(new int[]{-5, 1, 5, 0, -7}));
    }

    private static int findtheHighestAltitude1(int[] gain) {
        List<Integer> list = new ArrayList();
        list.add(0);
        for (int i = 0; i < gain.length; i++) {
            list.add(gain[i] + list.get(list.size() - 1));
        }
        return Collections.max(list);
    }

    private static int findtheHighestAltitude2(int[] gain) {
        int[] sum = new int[gain.length];
        sum[0] = gain[0];
        for (int i = 1; i < gain.length; i++) {
            sum[i] = sum[i - 1] + gain[i];
        }
        int max = 0;
        for (int i = 0; i < gain.length; i++) {
            if (max < sum[i]) {
                max = sum[i];
            }
        }
        return max;
    }

    private static int findtheHighestAltitude3(int[] gain) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
