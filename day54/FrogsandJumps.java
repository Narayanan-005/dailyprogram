public class FrogsandJumps {
    public static void main(String[] args) {
        System.out.println(frogsandJumps1(3, 4, new int[]{3, 2, 4}));
        System.out.println(frogsandJumps2(3, 4, new int[]{3, 2, 4}));
    }

    private static int frogsandJumps1(int N, int leaves, int frogs[]) {
        boolean arr[] = new boolean[leaves + 1];
        for (int i = 0; i < N; i++) {
            if (frogs[i] <= leaves && !arr[frogs[i]])
                for (int j = frogs[i]; j <= leaves; j += frogs[i]) {
                    if (!arr[j]) {
                        arr[j] = true;
                    }
                }
        }
        int count = 0;
        for (int i = 1; i <= leaves; i++) {
            if (!arr[i]) {
                count++;
            }
        }
        return count;
    }

    private static int frogsandJumps2(int N, int leaves, int frogs[]) {
        int count = leaves;
        boolean arr[] = new boolean[leaves + 1];
        for (int i = 0; i < N; i++) {
            if (frogs[i] <= leaves && !arr[frogs[i]])
                for (int j = frogs[i]; j <= leaves; j += frogs[i]) {
                    if (!arr[j]) {
                        arr[j] = true;
                        count--;
                    }
                }
        }
        return count;
    }
}
