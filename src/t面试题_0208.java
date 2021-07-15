public class t面试题_0208 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_0208 {
    public ListNode detectCycle(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        while (q != null) {
            q = q.next;
            if (q != null) {
                q = q.next;
            } else {
                return null;
            }
            p = p.next;
            if (p == q) {
                break;
            }
        }
        if (q == null) {
            return null;
        } else {
            ListNode r = head;
            while (p != r) {
                p = p.next;
                r = r.next;
            }
            return r;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}