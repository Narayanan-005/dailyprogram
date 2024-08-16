import java.util.ArrayList;
import java.util.List;

public class KidsWiththeGreatestNumberofCandies {
    public static void main(String[] args) {
        System.out.println(kidsWiththeGreatestNumberofCandies1(new int[]{2, 3, 5, 1, 3}, 3));
        System.out.println(kidsWiththeGreatestNumberofCandies2(new int[]{2, 3, 5, 1, 3}, 3));
    }

    private static List<Boolean> kidsWiththeGreatestNumberofCandies1(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList();
        for (int i = 0; i < candies.length; i++) {
            list.add(maxCheck(candies, candies[i] + extraCandies));
        }
        return list;
    }

    private static boolean maxCheck(int arr[], int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > num) {
                return false;
            }
        }
        return true;
    }

    private static List<Boolean> kidsWiththeGreatestNumberofCandies2(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList();
        int large = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if (large < candies[i])
                large = candies[i];
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= large) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }
}
