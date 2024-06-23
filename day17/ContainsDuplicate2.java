import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate2 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 2, 3};
        printResult(containsDuplicate21(arr, 2));
        printResult(containsDuplicate22(arr, 2));
        printResult(containsDuplicate23(arr, 2));
    }

    private static void printResult(boolean b) {
        if (b) {
            System.out.println("The given array contains duplicate elements");
        } else {
            System.out.println("The given array not contains duplicate elements");
        }
    }

    private static boolean containsDuplicate21(int arr[], int k) {
        for (int i = 0; i < arr.length; i++) {
            if (i <= k) {
                if (find(arr, 0, i - 1, arr[i])) {
                    return true;
                }
            } else {
                if (find(arr, i - k, i - 1, arr[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean find(int arr[], int start, int end, int val) {
        for (; start <= end; start++) {
            if (arr[start] == val) {
                return true;
            }
        }
        return false;
    }


    private static boolean containsDuplicate22(int arr[], int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                if (i - map.get(arr[i]) <= k) {
                    return true;
                }
            }
            map.put(arr[i], i);
        }
        return false;
    }


    private static boolean containsDuplicate23(int arr[], int k) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            if (i <= k) {
                if (!set.add(arr[i])) {
                    return true;
                }
            } else {
                set.remove(arr[i - 1 - k]);
                if (!set.add(arr[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}
