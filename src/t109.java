public class t109 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode middle = middleNode(head);
        ListNode left = head;
        ListNode right = middle.next;
        // 断开后半部链表
        middle.next = null;
        // 断开前半部链表
        ListNode tmp = head;
        while (tmp.next != middle) {
            tmp = tmp.next;
        }
        tmp.next = null;

        TreeNode root = new TreeNode(middle.val);
        root.left = sortedListToBST(left);
        root.right = sortedListToBST(right);
        return root;
    }

    ListNode middleNode(ListNode head) {
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}