import java.util.ArrayList;
import java.util.List;

public class t102 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t102 {
    // 树的层次遍历模板
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> one_level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove(0);
                one_level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(one_level);
        }
        return result;
    }

    //    // 广度优先遍历模板
    //    void bfs(Node root) {
    //        ArrayList<Node> queue = new ArrayList<>();
    //        queue.add(root);
    //
    //        while (!queue.isEmpty()) {
    //            Node node = queue.remove(0);
    //            访问node;
    //            for (Node neighbor : node的所有邻居节点) {
    //                if (neighbor未被访问) {
    //                    queue.add(neighbor);
    //                }
    //            }
    //        }
    //    }

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