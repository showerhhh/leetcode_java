public class t剑指_Offer_6 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_6 {
    public int[] reversePrint(ListNode head) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }
        int[] res = new int[n];
        ListNode q = head;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = q.val;
            q = q.next;
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}