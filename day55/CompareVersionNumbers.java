public class CompareVersionNumbers {
    public static void main(String[] args) {
        System.out.println(compareVersionNumbers1("1.2", "1.10"));
        System.out.println(compareVersionNumbers2("1.2", "1.10"));
    }

    private static int compareVersionNumbers1(String version1, String version2) {
        String ver1[] = version1.split("[.]");
        String ver2[] = version2.split("[.]");
        int i = 0, j = 0;
        while (i < ver1.length || j < ver2.length) {
            if (i == ver1.length) {
                if (Integer.parseInt(ver2[j]) != 0) {
                    return -1;
                }
                j++;
            } else if (j == ver2.length) {
                if (Integer.parseInt(ver1[i]) != 0) {
                    return 1;
                }
                i++;
            } else if (Integer.parseInt(ver1[i]) == Integer.parseInt(ver2[j])) {
                i++;
                j++;
            } else if (Integer.parseInt(ver1[i]) > Integer.parseInt(ver2[j])) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }

    private static int compareVersionNumbers2(String version1, String version2) {
        int l1 = version1.length();
        int l2 = version2.length();
        int i = 0, j = 0;
        while (i < l1 || j < l2) {
            int num1 = 0;
            int num2 = 0;
            while (i < l1 && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i++) - '0');
            }
            while (j < l2 && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j++) - '0');
            }
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
            i++;
            j++;
        }
        return 0;
    }
}
