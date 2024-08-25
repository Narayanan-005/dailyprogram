public class ZigzagConversion {
    public static void main(String[] args) {
        System.out.println(zigzagConversion1("PAYPALISHIRING", 3));
        System.out.println(zigzagConversion2("PAYPALISHIRING", 3));
    }

    private static String zigzagConversion1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int l = s.length();
        int add = numRows + numRows - 2;
        int f = add, se = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int j = i;
            boolean status = true;
            while (j < l) {
                if (i == 0 || i == numRows - 1) {
                    sb.append(s.charAt(j));
                    j += add;
                    continue;
                }
                sb.append(s.charAt(j));
                j += (status ? f : se);
                status = (status ? false : true);
            }
            f -= 2;
            se += 2;
        }
        return sb.toString();
    }

    private static String zigzagConversion2(String s, int numRows) {
        int n = s.length();
        StringBuffer[] arr = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) arr[i] = new StringBuffer();
        int i = 0;
        while (i < n) {
            for (int ind = 0; ind < numRows && i < n; ind++) {
                arr[ind].append(s.charAt(i++));
            }
            for (int ind = numRows - 2; ind > 0 && i < n; ind--) {
                arr[ind].append(s.charAt(i++));
            }
        }
        StringBuffer ans = new StringBuffer();
        for (StringBuffer el : arr) {
            ans.append(el);
        }
        return ans.toString();
    }
}
