public class t203 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode empty = new ListNode(-1, head);
        ListNode p = empty;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
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