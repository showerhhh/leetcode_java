import java.util.ArrayList;
import java.util.List;

public class t95 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t95 {
    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    List<TreeNode> dfs(int start, int end) {
        // 构建由start~end所组成的所有二叉搜索树，并返回
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = dfs(start, i - 1);
            List<TreeNode> right = dfs(i + 1, end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    result.add(node);
                }
            }
        }
        return result;
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