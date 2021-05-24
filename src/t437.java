import java.util.HashMap;

public class t437 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t437 {
    int count = 0;
    HashMap<Integer, Integer> prefixSumCount = new HashMap<>();  // key是前缀和，value是大小为key的前缀和出现的次数

    public int pathSum(TreeNode root, int targetSum) {
        prefixSumCount.put(0, 1);  // 前缀和为0的个数至少有一个
        dfs(root, targetSum, 0);
        return count;
    }

    void dfs(TreeNode node, int targetSum, int cur) {
        if (node == null) {
            return;
        }

        cur += node.val;
        count += prefixSumCount.getOrDefault(cur - targetSum, 0);

        prefixSumCount.put(cur, prefixSumCount.getOrDefault(cur, 0) + 1);
        dfs(node.left, targetSum, cur);
        dfs(node.right, targetSum, cur);
        prefixSumCount.put(cur, prefixSumCount.getOrDefault(cur, 0) - 1);

        cur -= node.val;  // 只是为了回溯代码的对称性，可省略
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