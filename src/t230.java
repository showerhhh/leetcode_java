public class t230 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t230 {
    int count = 0;
    int kMinNum = -1;

    public int kthSmallest(TreeNode root, int k) {
        f(root, k);
        return kMinNum;
    }

    void f(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        f(node.left, k);
        count++;
        if (count > k) {
            return;
        } else if (count == k) {
            kMinNum = node.val;
            return;
        } else {
            f(node.right, k);
            return;
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