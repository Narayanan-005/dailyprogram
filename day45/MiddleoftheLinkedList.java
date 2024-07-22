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

public class MiddleoftheLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        System.out.println(middleoftheLinkedList1(head).val);
        System.out.println(middleoftheLinkedList2(head).val);
        System.out.println(middleoftheLinkedList3(head).val);
    }

    private static ListNode middleoftheLinkedList1(ListNode head) {
        List<ListNode> l = new ArrayList<>();
        while (head != null) {
            l.add(head);
            head = head.next;
        }
        return l.get(l.size() / 2);
    }

    private static ListNode middleoftheLinkedList2(ListNode head) {
        int l = 0;
        ListNode temp = head;
        while (temp != null) {
            l++;
            temp = temp.next;
        }
        l = l / 2;
        while (head != null) {
            if (l == 0) {
                return head;
            }
            l--;
            head = head.next;
        }
        return null;
    }

    private static ListNode middleoftheLinkedList3(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
