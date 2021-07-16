public class t面试题_0406 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_0406 {
    TreeNode successor = null;  // 保存最后结果，p的后继节点
    TreeNode pre = null;  // 保存上一个被访问的节点
    boolean flag = false;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inoder(root, p);
        return successor;
    }

    void inoder(TreeNode node, TreeNode p) {
        if (node == null || flag) {
            return;
        }
        inoder(node.right, p);
        if (node == p) {
            successor = pre;
            flag = true;
        } else {
            pre = node;
        }
        inoder(node.left, p);
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