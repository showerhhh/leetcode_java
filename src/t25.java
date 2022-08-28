public class t25 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        int n = 0;
        while (p != null) {
            p = p.next;
            n++;
        }
        ListNode empty = new ListNode(-1, null);
        ListNode tail = empty;
        p = head;
        for (int i = 0; i < n / k; i++) {
            for (int j = 0; j < k; j++) {
                ListNode tmp = p.next;
                p.next = tail.next;
                tail.next = p;
                p = tmp;
            }
            while (tail.next != null) {
                tail = tail.next;
            }
        }
        if (p != null) {
            tail.next = p;
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