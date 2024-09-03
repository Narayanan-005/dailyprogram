import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode node2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        printResult(oddEvenLinkedList1(node1));
        printResult(oddEvenLinkedList2(node2));
    }

    private static void printResult(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }

    private static ListNode oddEvenLinkedList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> list = new ArrayList();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        ListNode res = list.get(0);
        ListNode temp = res;
        for (int i = 2; i < list.size(); i += 2) {
            temp.next = list.get(i);
            temp = temp.next;
        }
        for (int i = 1; i < list.size(); i += 2) {
            temp.next = list.get(i);
            temp = temp.next;
        }
        temp.next = null;
        return res;
    }

    private static ListNode oddEvenLinkedList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode f = head;
        ListNode s = head.next;
        ListNode f1 = f;
        ListNode s1 = s;
        ListNode curr = null;
        head = head.next.next;
        while (head != null && head.next != null) {
            curr = head.next.next;
            f1.next = head;
            f1 = f1.next;
            s1.next = head.next;
            s1 = s1.next;
            head = curr;
        }
        if (head != null) {
            f1.next = head;
            f1 = f1.next;
        }
        s1.next = null;
        f1.next = s;
        return f;
    }
}
