public class t24 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t24 {
    public ListNode swapPairs(ListNode head) {
        ListNode empty = new ListNode(-1, head);
        ListNode p = empty, first, second;
        while (p.next != null && p.next.next != null) {
            first = p.next;
            second = p.next.next;
            first.next = second.next;
            second.next = first;
            p.next = second;

            p = p.next.next;
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