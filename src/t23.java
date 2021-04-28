public class t23 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return func(lists, 0, lists.length - 1);
    }

    ListNode func(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }

        int m = (r - l) / 2 + l;
        ListNode left = func(lists, l, m);
        ListNode right = func(lists, m + 1, r);

        return mergeTwoLists(left, right);
    }

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1, null);  //头节点
        ListNode p = head;  //尾指针
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
                p.next = null;
            } else {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
                p.next = null;
            }
        }
        while (l1 != null) {
            p.next = l1;
            l1 = l1.next;
            p = p.next;
            p.next = null;
        }
        while (l2 != null) {
            p.next = l2;
            l2 = l2.next;
            p = p.next;
            p.next = null;
        }
        return head.next;
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