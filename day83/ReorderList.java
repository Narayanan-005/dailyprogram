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

public class ReorderList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode node2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reorderList1(node1);
        reorderList2(node2);
        printResult(node1);
        printResult(node2);
    }

    private static void printResult(ListNode node1) {
        while (node1 != null) {
            System.out.print(node1.val + " ");
            node1 = node1.next;
        }
        System.out.println();
    }

    private static void reorderList1(ListNode head) {
        List<Integer> list = new ArrayList();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        for (int i = 0, j = list.size() - 1; i <= j; i++, j--) {
            head.val = list.get(i);
            head = head.next;
            if (head != null) {
                head.val = list.get(j);
                head = head.next;
            }
        }
    }

    private static void reorderList2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev = reverse(slow.next);
        slow.next = null;
        ListNode node = head;
        ListNode curr = null;
        while (rev != null) {
            curr = node.next;
            node.next = rev;
            rev = rev.next;
            node = node.next;
            node.next = curr;
            node = node.next;
        }
    }

    private static ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode curr = null;
        while (node != null) {
            curr = node.next;
            node.next = pre;
            pre = node;
            node = curr;
        }
        return pre;
    }
}
