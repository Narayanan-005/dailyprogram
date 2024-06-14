import java.util.HashSet;
import java.util.Set;

public class SubSetArray {
    public static void main(String[] args) {
        int[] arr1 = {11, 1, 13, 21, 3, 7};
        int[] arr2 = {11, 3, 7, 1};
        printResult(subSet1(arr1, arr2));
        printResult(subSet2(arr1, arr2));
        printResult(subSet3(arr1, arr2));
    }

    private static void printResult(boolean status) {
        if (status) {
            System.out.println("Array 2 subset of Array 1");
        } else {
            System.out.println("Array 2 not a subset of Array 1");
        }
    }

    private static boolean subSet1(int arr1[], int arr2[]) {
        boolean isPresent = false;
        for (int i = 0; i < arr2.length; i++) {
            isPresent = false;
            for (int j = 0; j < arr1.length; j++) {
                if (arr2[i] == arr1[j]) {
                    isPresent = true;
                }
            }
            if (!isPresent) {
                return false;
            }
        }
        return true;
    }

    private static boolean subSet2(int arr1[], int arr2[]) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (!set.contains(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean subSet3(int arr1[], int arr2[]) {
        int l = arr1[0];
        for (int i = 1; i < arr1.length; i++) {
            if (l < arr1[i]) {
                l = arr1[i];
            }
        }
        boolean[] occurence = new boolean[l + 1];
        for (int i = 0; i < arr1.length; i++) {
            occurence[arr1[i]] = true;
        }
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] >= occurence.length) {
                return false;
            } else if (!occurence[arr2[i]]) {
                return false;
            }
        }
        return true;
    }
}
