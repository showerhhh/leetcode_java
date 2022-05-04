public class t236 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t236 {
    TreeNode target = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        f(root, p, q);
        return target;
    }

    boolean[] f(TreeNode node, TreeNode p, TreeNode q) {
        // 判断以node为根节点的树中，是否包含p、q
        if (node == null) {
            return new boolean[]{false, false};
        }
        boolean[] left = f(node.left, p, q);
        boolean[] right = f(node.right, p, q);
        boolean[] res = new boolean[2];
        res[0] = left[0] || right[0] || node == p;
        res[1] = left[1] || right[1] || node == q;
        if (res[0] && res[1] && target == null) {
            target = node;  // 后续遍历使得pq的最近公共祖先先被赋给target
        }
        return res;
    }

    public TreeNode lowestCommonAncestor_v2(TreeNode root, TreeNode p, TreeNode q) {
        // 返回值指向p或q或pq的最近公共祖先，否则为null
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor_v2(root.left, p, q);
        TreeNode right = lowestCommonAncestor_v2(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }
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