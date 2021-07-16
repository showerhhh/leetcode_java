import java.util.LinkedList;
import java.util.Queue;

public class t面试题_0403 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_0403 {
    public ListNode[] listOfDepth(TreeNode tree) {
        int depth = f(tree);
        ListNode[] result = new ListNode[depth];

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        int idx = 0;
        while (!queue.isEmpty()) {
            ListNode head = new ListNode(-1);
            ListNode p = head;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode t = queue.poll();
                p.next = new ListNode(t.val);
                p = p.next;
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
            result[idx] = head.next;
            idx++;
        }
        return result;
    }

    int f(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = f(root.left);
        int right = f(root.right);
        return Math.max(left, right) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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