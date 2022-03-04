public class t206 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t206 {
    public ListNode reverseList(ListNode head) {
        ListNode empty = new ListNode(-1);
        while (head != null) {
            ListNode p = head;
            head = head.next;
            p.next = empty.next;
            empty.next = p;
        }
        return empty.next;
    }

    public ListNode reverseList_2(ListNode head) {
        ListNode p = null, q = head, tmp;
        while (q != null) {
            tmp = q.next;
            q.next = p;
            p = q;
            q = tmp;
        }
        return p;
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