public class t剑指_Offer_26 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        return check(A, B);
    }

    boolean check(TreeNode A, TreeNode B) {
        // 已知B不为空，判断B是不是A的子结构。
        if (A == null) {
            return false;
        }

        boolean flag1 = check(A.left, B);
        boolean flag2 = check(A.right, B);
        boolean flag3 = pipei(A, B);
        return flag1 || flag2 || flag3;
    }

    boolean pipei(TreeNode A, TreeNode B) {
        // 检查B是否属于A（从根节点开始对应）
        if (B == null) {
            return true;
        } else if (A == null) {
            return false;
        } else {
            if (B.val != A.val) {
                return false;
            }
            return pipei(A.left, B.left) && pipei(A.right, B.right);
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