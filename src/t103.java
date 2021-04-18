import java.util.ArrayList;
import java.util.List;

public class t103 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean flag = false;

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
            reverse(one_level, flag);
            result.add(one_level);
            flag = !flag;
        }
        return result;
    }

    void reverse(ArrayList<Integer> t, boolean flag) {
        if (!flag) {
            return;
        }
        int n = t.size();
        for (int i = 0; i < n / 2; i++) {
            int tmp = t.get(i);
            t.set(i, t.get(n - 1 - i));
            t.set(n - 1 - i, tmp);
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