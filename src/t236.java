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

    Flag f(TreeNode node, TreeNode p, TreeNode q) {
        // 判断以node为根节点的树中，是否包含p、q
        if (node == null) {
            return new Flag();
        }
        Flag flag_left = f(node.left, p, q);
        Flag flag_right = f(node.right, p, q);
        Flag flag = new Flag();
        flag.p = flag_left.p || node == p || flag_right.p;
        flag.q = flag_left.q || node == q || flag_right.q;
        if (flag.p && flag.q && target == null) {
            target = node;
        }
        return flag;
    }

    class Flag {
        boolean p;
        boolean q;

        Flag() {
            p = false;
            q = false;
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