import java.util.Scanner;

class Node {
    int val;
    Node next;

    Node() {

    }

    Node(int val) {
        this.val = val;
    }
}

public class Findthelengthofthelinkedlist {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        Node head = new Node();
        input(head);
        System.out.println(findthelengthofthelinkedlist1(head.next));
        System.out.println(findthelengthofthelinkedlist2(head.next));
    }

    private static void input(Node node) {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            Node node1 = new Node(scanner.nextInt());
            node.next = node1;
            node = node.next;
        }
    }

    private static int findthelengthofthelinkedlist1(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    private static int findthelengthofthelinkedlist2(Node head) {
        if (head == null) {
            return 0;
        }
        return 1 + findthelengthofthelinkedlist2(head.next);
    }
}
