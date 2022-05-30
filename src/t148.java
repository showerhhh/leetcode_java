public class t148 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t148 {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode[] q = divide(head);
        ListNode p0 = sortList(q[0]);
        ListNode p1 = sortList(q[1]);
        ListNode p2 = merge(p0, p1);
        return p2;
    }

    ListNode[] divide(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode p = slow.next;
        slow.next = null;
        return new ListNode[]{head, p};
    }

    ListNode merge(ListNode p1, ListNode p2) {
        ListNode empty = new ListNode(), tail = empty;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = p1;
                p1 = p1.next;
                tail = tail.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
                tail = tail.next;
            }
        }
        if (p1 != null) {
            tail.next = p1;
        }
        if (p2 != null) {
            tail.next = p2;
        }
        return empty.next;
    }

    public class ListNode {
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
}