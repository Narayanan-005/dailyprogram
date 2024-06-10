import java.util.*;

public class Union {
    public static void main(String[] args) {
        int arr1[] = {2, 5, 6, 10};
        int arr2[] = {2, 4, 5, 5, 7, 9};
        System.out.println(Arrays.toString(union1(arr1, arr2)));
        System.out.println(Arrays.toString(union2(arr1, arr2)));
        System.out.println(Arrays.toString(union3(arr1, arr2)));
    }

    public static int[] union1(int[] arr1, int[] arr2) {
        int[] temp = new int[arr1.length + arr2.length];
        int i = 0;
        for (int j = 0; j < arr1.length; j++) {
            temp[i++] = arr1[j];
        }
        for (int k = 0; k < arr2.length; k++) {
            temp[i++] = arr2[k];
        }
        Arrays.sort(temp);
        int l = 1;
        for (int j = 0; j < temp.length - 1; j++) {
            if (temp[j] == temp[j + 1]) {
                temp[j] = -1;
            } else {
                l++;
            }
        }
        int[] res = new int[l];
        l = 0;
        for (int j = 0; j < temp.length; j++) {
            if (temp[j] != -1) {
                res[l++] = temp[j];
            }
        }
        return res;
    }

    public static int[] union2(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        int res[] = new int[set.size()];
        int j = 0;
        for (Integer i : set) {
            res[j++] = i;
        }
        return res;
    }

    public static Integer[] union3(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        int prev = -1;
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                if (prev != arr1[i]) {
                    list.add(arr1[i]);
                    prev = arr1[i];
                } else {
                    i++;
                }
            } else {
                if (prev != arr2[j]) {
                    list.add(arr2[j]);
                    prev = arr2[j];
                } else {
                    j++;
                }
            }
        }
        while (j < arr2.length) {
            if (prev != arr2[j]) {
                list.add(arr2[j]);
                prev = arr2[j];
            }
            j++;
        }
        while (i < arr1.length) {
            if (prev != arr1[i]) {
                list.add(arr1[i]);
                prev = arr1[i];
            }
            i++;
        }
        return list.toArray(new Integer[0]);
    }
}
