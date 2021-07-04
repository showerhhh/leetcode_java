public class t450 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        // 在以root为根节点的树中删除key，返回root
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            // 关键字小于根节点，在左子树中删除
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            // 关键字大于根节点，在右子树中删除
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            // 根节点就是要删除的节点
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.val = predecessor(root);  // 找root的前驱节点，将前驱结点的值赋给root
                root.left = deleteNode(root.left, root.val);  // 在root的左子树中删除该前驱节点
                return root;
            }
        }
    }

    int successor(TreeNode root) {
        // 求root节点的后继节点
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    int predecessor(TreeNode root) {
        // 求root节点的前驱节点
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
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