import java.util.ArrayList;
import java.util.List;

public class t637 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t637 {
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> result = new ArrayList<Double>();

        if (root == null) {
            return result;
        }

        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> one_level = new ArrayList<Integer>();
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
            result.add(mean(one_level));
        }
        return result;
    }

    double mean(List<Integer> t) {
        double sum = 0;
        for (int i = 0; i < t.size(); i++) {
            sum += t.get(i);
        }
        return sum / t.size();
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