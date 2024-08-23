import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupthePeopleGiventheGroupSizeTheyBelongTo {
    public static void main(String[] args) {
        System.out.println(groupthePeopleGiventheGroupSizeTheyBelongTo1(new int[]{3, 3, 3, 3, 3, 1, 3}));
        System.out.println(groupthePeopleGiventheGroupSizeTheyBelongTo2(new int[]{3, 3, 3, 3, 3, 1, 3}));
    }

    private static List<List<Integer>> groupthePeopleGiventheGroupSizeTheyBelongTo1(int[] groupSizes) {
        int l = groupSizes.length;
        List<List<Integer>> list = new ArrayList();
        for (int i = 0; i < l; i++) {
            if (groupSizes[i] == 0) {
                continue;
            }
            List<Integer> li = new ArrayList();
            li.add(i);
            for (int j = i + 1; j < l && li.size() < groupSizes[i]; j++) {
                if (groupSizes[i] == groupSizes[j]) {
                    groupSizes[j] = 0;
                    li.add(j);
                }
            }
            list.add(li);
        }
        return list;
    }

    private static List<List<Integer>> groupthePeopleGiventheGroupSizeTheyBelongTo2(int[] groupSizes) {
        List<List<Integer>> list = new ArrayList();
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < groupSizes.length; i++) {
            if (!map.containsKey(groupSizes[i])) {
                map.put(groupSizes[i], new ArrayList());
            }
            map.get(groupSizes[i]).add(i);
            if (groupSizes[i] == map.get(groupSizes[i]).size()) {
                list.add(map.get(groupSizes[i]));
                map.put(groupSizes[i], new ArrayList());
            }
        }
        return list;
    }
}
