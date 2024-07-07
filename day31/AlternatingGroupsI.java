public class AlternatingGroupsI {
    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 0, 1};
        System.out.println(alternatingGroupsI1(arr));
        System.out.println(alternatingGroupsI2(arr));
        System.out.println(alternatingGroupsI3(arr));
    }

    private static int alternatingGroupsI1(int[] colors) {
        int count = 0;
        int l = colors.length;
        int a, b, c;
        for (int i = 0; i < l; i++) {
            a = colors[i];
            if (i == l - 2) {
                b = colors[i + 1];
                c = colors[0];
            } else if (i == l - 1) {
                b = colors[0];
                c = colors[1];
            } else {
                b = colors[i + 1];
                c = colors[i + 2];
            }
            if (a == c && a != b) {
                count++;
            }
        }
        return count;
    }

    private static int alternatingGroupsI2(int[] colors) {
        int count = 0;
        int l = colors.length;
        if (colors[l - 1] == colors[1] && colors[0] != colors[1]) {
            count++;
        }
        if (colors[l - 2] == colors[0] && colors[l - 1] != colors[l - 2]) {
            count++;
        }
        for (int i = 1; i < l - 1; i++) {
            if (colors[i - 1] == colors[i + 1] && colors[i] != colors[i - 1]) {
                count++;
            }
        }
        return count;
    }

    private static int alternatingGroupsI3(int[] colors) {
        int count = 0;
        int l = colors.length;
        for (int i = 0; i < l; i++) {
            if (colors[i] == colors[(i + 2) % l] && colors[i] != colors[(i + 1) % l]) {
                count++;
            }
        }
        return count;
    }
}
