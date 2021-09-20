public class t面试题_0412 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_0412 {
    int count;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        count = 0;
        dfs(root, 0, sum);
        int tmp = count;
        return pathSum(root.left, sum) + pathSum(root.right, sum) + tmp;
    }

    void dfs(TreeNode root, int curSum, int sum) {
        if (root == null) {
            return;
        }
        curSum += root.val;
        if (curSum == sum) {
            count++;
        }
        dfs(root.left, curSum, sum);
        dfs(root.right, curSum, sum);
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