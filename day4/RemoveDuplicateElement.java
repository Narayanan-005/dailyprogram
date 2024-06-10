import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateElement {
    public static void main(String[] args) {
        int arr1[] = {2, 7, 5, 7, 7, 2, 2, 0, 5, 11};
        int arr2[] = {2, 7, 5, 7, 7, 2, 2, 0, 5, 11};
        int arr3[] = {2, 7, 5, 7, 7, 2, 2, 0, 5, 11};
        System.out.println(Arrays.toString(removeDuplicate1(arr1)));
        System.out.println(Arrays.toString(removeDuplicate2(arr2)));
        System.out.println(Arrays.toString(removeDuplicate3(arr3)));
    }

    private static int[] removeDuplicate1(int[] arr) {
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                continue;
            }
            length++;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] != -1 && arr[i] == arr[j]) {
                    arr[j] = -1;
                }
            }
        }
        int[] res = new int[length];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                res[j++] = arr[i];
            }
        }
        return res;
    }

    private static int[] removeDuplicate2(int[] arr) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int res[] = new int[set.size()];
        int j = 0;
        for (Integer i : set) {
            res[j++] = i;
        }
        return res;
    }

    private static int[] removeDuplicate3(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int l = 0;
        boolean[] unique = new boolean[max + 1];
        for (int i = 0; i < arr.length; i++) {
            if (!unique[arr[i]]) {
                unique[arr[i]] = true;
                arr[l++] = arr[i];
            }
        }
        int res[] = new int[l];
        for (int i = 0; i < l; i++) {
            res[i] = arr[i];
        }
        return res;

    }
}
