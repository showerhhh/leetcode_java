package NC面试高频榜单;

public class NC50 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_NC50 {
    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        ListNode empty = new ListNode(), tail = empty;
        int n = 0;
        for (ListNode p = head; p != null; p = p.next) {
            n++;
        }
        ListNode p = head;
        for (int i = 0; i < n / k; i++) {
            for (int j = 0; j < k; j++) {
                p = head.next;
                head.next = tail.next;
                tail.next = head;
                head = p;
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
        ListNode next = null;
    }
}