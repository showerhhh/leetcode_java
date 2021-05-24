import java.util.ArrayList;
import java.util.List;

public class t剑指_Offer_34 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_34 {
    ArrayList<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> t = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        dfs(root, target);
        return result;
    }

    void dfs(TreeNode root, int target) {
        if (root.left == null && root.right == null && root.val == target) {
            t.add(root.val);
            // 复制t
            ArrayList<Integer> copy_t = new ArrayList<>(t);
            result.add(copy_t);
            t.remove(t.size() - 1);
            return;
        }

        t.add(root.val);
        target -= root.val;
        if (root.left != null) {
            dfs(root.left, target);
        }
        if (root.right != null) {
            dfs(root.right, target);
        }
        target += root.val;
        t.remove(t.size() - 1);
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