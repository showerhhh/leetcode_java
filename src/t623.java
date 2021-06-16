import java.util.LinkedList;
import java.util.Queue;

public class t623 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode addNode = new TreeNode(val);
            addNode.left = root;
            return addNode;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 0; i < depth - 2; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        TreeNode tmp;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode addNodeLeft = new TreeNode(val);
            tmp = node.left;
            node.left = addNodeLeft;
            addNodeLeft.left = tmp;
            TreeNode addNodeRight = new TreeNode(val);
            tmp = node.right;
            node.right = addNodeRight;
            addNodeRight.right = tmp;
        }
        return root;
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