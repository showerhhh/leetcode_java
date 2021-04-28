public class t剑指_Offer_25 {
    public static void main(String[] args) {
        Solution_t剑指_Offer_25 solution = new Solution_t剑指_Offer_25();
        solution.testMergeTwoArrays();
    }
}

class Solution_t剑指_Offer_25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);  //头节点
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

    int[] mergeTwoArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0, k = 0;
        int[] result = new int[m + n];

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }
        while (i < m) {
            result[k++] = nums1[i++];
        }
        while (j < n) {
            result[k++] = nums2[j++];
        }
        return result;
    }

    void testMergeTwoArrays() {
        int[] nums1 = {3, 6, 8, 10};
        int[] nums2 = {1, 2, 3, 5, 7, 11, 20};
        int[] result = mergeTwoArrays(nums1, nums2);
        for (int t : result) {
            System.out.print(t);
            System.out.print(" ");
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}