public class t876 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

/**
 * Definition for singly-linked list.
 */
class Solution_t876 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null) {
            if (quick.next != null) {
                quick = quick.next.next;
            } else {
                break;
            }
            slow = slow.next;
        }
        return slow;
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