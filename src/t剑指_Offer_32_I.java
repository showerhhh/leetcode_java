import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class t剑指_Offer_32_I {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_32_I {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                result.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        int[] t = new int[result.size()];
        for (int i = 0; i < t.length; i++) {
            t[i] = result.get(i);
        }
        return t;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}