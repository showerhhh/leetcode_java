public class t面试题_0204 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_0204 {
    public ListNode partition(ListNode head, int x) {
        ListNode L1 = new ListNode(-1), L1_tail = L1;  // 小于x的链表
        ListNode L2 = new ListNode(-1), L2_tail = L2;  // 大于x的链表
        ListNode p = head, q;
        while (p != null) {
            q = p.next;
            if (p.val < x) {
                L1_tail.next = p;
                L1_tail = L1_tail.next;
                L1_tail.next = null;
            } else {
                L2_tail.next = p;
                L2_tail = L2_tail.next;
                L2_tail.next = null;
            }
            p = q;
        }
        L1_tail.next = L2.next;
        return L1.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}