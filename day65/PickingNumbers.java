import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PickingNumbers {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(6);
        list.add(5);
        list.add(3);
        list.add(3);
        list.add(1);
        System.out.println(pickingNumbers1(list));
        System.out.println(pickingNumbers3(list));
        System.out.println(pickingNumbers2(list));
    }

    private static int pickingNumbers1(List<Integer> a) {
        int l = a.size();
        int max = 0;
        for (int i = 0; i < l; i++) {
            int count = 0;
            int n = a.get(i);
            for (int j = 0; j < l; j++) {
                int curr = a.get(j);
                if (n == curr || n + 1 == curr) {
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

    private static int pickingNumbers2(List<Integer> a) {
        Collections.sort(a);
        int max = 0;
        int pre = 0;
        int preEle = a.get(0);
        int currEle = a.get(0);
        int curr = 1;
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) == a.get(i - 1)) {
                curr++;
            } else {
                if (currEle - preEle <= 1)
                    max = Math.max(max, curr + pre);
                else
                    max = Math.max(max, Math.max(pre, curr));
                pre = curr;
                curr = 1;
                preEle = currEle;
                currEle = a.get(i);
            }
        }
        if (currEle - preEle <= 1)
            max = Math.max(max, curr + pre);
        else
            max = Math.max(max, Math.max(pre, curr));
        return max;
    }

    private static int pickingNumbers3(List<Integer> a) {
        int[] count = new int[101];
        for (int i = 0; i < a.size(); i++) {
            count[a.get(i)]++;
        }
        int max = 0;
        for (int i = 2; i < 101; i++) {
            max = Math.max(max, count[i] + count[i - 1]);
        }
        return max;
    }
}
