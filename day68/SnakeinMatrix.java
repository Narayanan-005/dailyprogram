import java.util.ArrayList;
import java.util.List;

public class SnakeinMatrix {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("RIGHT");
        list.add("DOWN");
        System.out.println(snakeinMatrix1(2, list));
        System.out.println(snakeinMatrix2(2, list));
    }

    private static int snakeinMatrix1(int n, List<String> commands) {
        int i = 0, j = 0;
        for (String s : commands) {
            switch (s) {
                case "UP":
                    i--;
                    break;
                case "RIGHT":
                    j++;
                    break;
                case "DOWN":
                    i++;
                    break;
                case "LEFT":
                    j--;
                    break;
            }
        }
        return (i * n) + j;
    }

    private static int snakeinMatrix2(int n, List<String> commands) {
        int position = 0;
        for (String s : commands) {
            if (s.equals("UP")) {
                position -= n;
            } else if (s.equals("DOWN")) {
                position += n;
            } else if (s.equals("LEFT")) {
                position--;
            } else {
                position++;
            }
        }
        return position;
    }

}
