import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printPascal(pascalsTriangle1(n));
        printPascal(pascalsTriangle2(n));
    }

    private static void printPascal(List<List<Integer>> lists) {
        int space = lists.size() - 1;
        for (int i = 0; i < lists.size(); i++) {
            System.out.print(" ".repeat(space--));
            for (Integer li : lists.get(i)) {
                System.out.print(li + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> pascalsTriangle1(int n) {
        List<List<Integer>> result = new ArrayList();
        if (n == 1) {
            result.add(List.of(1));
            return result;
        }
        return task(pascalsTriangle1(n - 1), new ArrayList(), 0);
    }

    public static List<List<Integer>> task(List<List<Integer>> previous, List<Integer> current, int index) {
        if (previous.get(previous.size() - 1).size() == index) {
            current.add(1);
            previous.add(current);
            return previous;
        }
        if (index == 0) {
            current.add(1);
            return task(previous, current, index + 1);
        }
        current.add(previous.get(previous.size() - 1).get(index) + previous.get(previous.size() - 1).get(index - 1));
        return task(previous, current, index + 1);
    }

    public static List<List<Integer>> pascalsTriangle2(int n) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> pre = new ArrayList();
        pre.add(1);
        result.add(pre);
        while (n-- > 1) {
            pre = result.get(result.size() - 1);
            List<Integer> l = new ArrayList();
            l.add(1);
            for (int i = 1; i < pre.size(); i++) {
                l.add(pre.get(i) + pre.get(i - 1));
            }
            l.add(1);
            result.add(l);
        }
        return result;
    }
}