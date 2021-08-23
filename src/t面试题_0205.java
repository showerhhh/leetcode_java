public class t面试题_0205 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        ListNode p = l1;
        ListNode q = l2;
        int sum = 0, add = 0;
        while (p != null || q != null) {
            if (p != null && q != null) {
                sum = p.val + q.val + add;
                p = p.next;
                q = q.next;
            } else if (p != null) {
                sum = p.val + add;
                p = p.next;
            } else if (q != null) {
                sum = q.val + add;
                q = q.next;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            add = sum / 10;
        }
        if (add != 0) {
            cur.next = new ListNode(add);
        }
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}