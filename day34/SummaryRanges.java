import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int arr[] = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(summaryRanges1(arr));
        System.out.println(summaryRanges2(arr));
        System.out.println(summaryRanges3(arr));
    }

    private static List<String> summaryRanges1(int nums[]) {
        int l = nums.length;
        List<String> list = new ArrayList<>();
        if (l == 0) {
            return list;
        }
        int start = 0;
        for (int i = 1; i <= l; i++) {
            if (i == l || nums[i] - nums[i - 1] != 1) {
                if (start == i - 1) {
                    list.add("" + nums[i - 1]);
                } else {
                    list.add(nums[start] + "->" + nums[i - 1]);
                }
                start = i;
            }
        }
        return list;
    }

    private static List<String> summaryRanges2(int nums[]) {
        int l = nums.length;
        List<String> list = new ArrayList();
        if (l == 0) {
            return list;
        }
        int start = 0;
        for (int i = 0; i < l; i++) {
            if (i < l - 1 && nums[i] + 1 == nums[i + 1]) {
                while (i < l - 1 && nums[i] + 1 == nums[i + 1]) {
                    i++;
                }
                list.add(get(nums, start, i));
                start = i + 1;
            } else {
                list.add(get(nums, start, i));
                start = i + 1;
            }
        }
        return list;
    }

    private static String get(int nums[], int start, int end) {
        StringBuilder sb = new StringBuilder();
        sb.append(nums[start]);
        if (start != end) {
            sb.append("->").append(nums[end]);
        }
        return sb.toString();
    }

    private static List<String> summaryRanges3(int nums[]) {
        int l = nums.length;
        List<String> list = new ArrayList();
        if (l == 0) {
            return list;
        }
        int start = 0;
        for (int i = 1; i <= l; i++) {
            if (i == l || nums[i] - nums[i - 1] != 1) {
                list.add(get(nums, start, i - 1));
                start = i;
            }
        }
        return list;
    }
}
