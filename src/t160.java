import java.util.HashSet;

public class t160 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode p = headA;
        while (p != null) {
            set.add(p);
            p = p.next;
        }
        ListNode q = headB;
        while (q != null) {
            if (set.contains(q)) {
                return q;
            }
            q = q.next;
        }
        return null;
    }

    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            if (p != null) {
                p = p.next;
            } else {
                p = headB;
            }
            if (q != null) {
                q = q.next;
            } else {
                q = headA;
            }
        }
        return p;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}