import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }

    Node(int x, Node next) {
        data = x;
        this.next = next;
    }
}

public class Add1toaLinkedListNumber {
    public static void main(String[] args) {
        Node head1 = new Node(4, new Node(5, new Node(6)));
        Node head2 = new Node(4, new Node(5, new Node(6)));
        printNode(add1toaLinkedListNumber1(head1));
        printNode(add1toaLinkedListNumber2(head2));
    }

    private static void printNode(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }


    private static Node add1toaLinkedListNumber1(Node head) {
        List<Node> list = new ArrayList();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int carry = 1;
        for (int i = list.size() - 1; i >= 0; i--) {
            Node n = list.get(i);
            int num = n.data + carry;
            n.data = num % 10;
            carry = num / 10;
            if (carry == 0) {
                break;
            }
        }
        if (carry == 1) {
            Node n = new Node(1);
            n.next = list.get(0);
            return n;
        }
        return list.get(0);
    }

    private static Node add1toaLinkedListNumber2(Node head) {
        head = reverse(head);
        Node curr = head;
        int carry = 1;
        while (carry != 0) {
            if (head.data > 8) {
                head.data = 0;
            } else {
                head.data++;
                carry = 0;
            }
            if (head.next == null && carry == 1) {
                carry = 0;
                head.next = new Node(1);
            }
            head = head.next;
        }
        return reverse(curr);
    }

    private static Node reverse(Node head) {
        Node pre = null;
        Node curr = null;
        while (head != null) {
            curr = head;
            head = head.next;
            curr.next = pre;
            pre = curr;
        }
        return pre;
    }
}
