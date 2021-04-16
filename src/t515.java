import java.util.ArrayList;
import java.util.List;

public class t515 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t515 {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

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
            result.add(max(one_level));
        }
        return result;
    }

    int max(ArrayList<Integer> t) {
        int tmp = Integer.MIN_VALUE;
        for (int i = 0; i < t.size(); i++) {
            if (t.get(i) > tmp) {
                tmp = t.get(i);
            }
        }
        return tmp;
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