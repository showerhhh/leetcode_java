import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class t102 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t102 {
    // 树的层次遍历模板1
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

    // 树的层次遍历模板2
    public List<List<Integer>> levelOrder_2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> tmp = new LinkedList<>();
            ArrayList<Integer> one_level = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                one_level.add(node.val);
                if (node.left != null) {
                    tmp.offer(node.left);
                }
                if (node.right != null) {
                    tmp.offer(node.right);
                }
            }
            queue = tmp;
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