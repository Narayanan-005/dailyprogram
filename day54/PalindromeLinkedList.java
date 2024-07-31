import java.util.Stack;

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

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(palindromeLinkedList1(head));
        System.out.println(palindromeLinkedList2(head));
        System.out.println(palindromeLinkedList3(head));
    }

    private static boolean palindromeLinkedList1(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        if (sb.toString().equals(sb.reverse().toString())) {
            return true;
        }
        return false;
    }

    private static boolean palindromeLinkedList2(ListNode head) {
        Stack<Integer> stack = new Stack();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    private static boolean palindromeLinkedList3(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        ListNode pre = null;
        ListNode curr = null;
        while (slow != null) {
            curr = slow;
            slow = slow.next;
            curr.next = pre;
            pre = curr;
        }
        while (pre != null) {
            if (pre.val != head.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
    }

}
