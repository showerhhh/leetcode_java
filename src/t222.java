public class t222 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int dl = getDepth(root.left);
        int dr = getDepth(root.right);
        if (dl == dr) {
            // 左右子树深度相等时，左子树为满二叉树，右子树为完全二叉树。
            // 根节点（1）+左子树节点数（2的dl次幂-1）+右子树节点数（递归函数求得）
            return (int) Math.pow(2, dl) + countNodes(root.right);
        } else {
            // 左右子树深度不相等时，左子树为完全二叉树，右子树为满二叉树。
            return (int) Math.pow(2, dr) + countNodes(root.left);
        }
    }

    int getDepth(TreeNode root) {
        // 求完全二叉树的深度，不用分治，指针不断进入左字数就行
        int d = 0;
        TreeNode p = root;
        while (p != null) {
            d++;
            p = p.left;
        }
        return d;
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