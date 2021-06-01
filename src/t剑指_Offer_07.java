public class t剑指_Offer_07 {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        Solution_t剑指_Offer_07 solution = new Solution_t剑指_Offer_07();
        solution.buildTree(preorder, inorder);
    }
}

class Solution_t剑指_Offer_07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int node_val = preorder[0];
        TreeNode node = new TreeNode(node_val);
        // 找node_val在inorder中的位置
        int index;
        for (index = 0; index < inorder.length; index++) {
            if (inorder[index] == node_val) {
                break;
            }
        }

        int i;

        int[] inorder_left = new int[index];
        i = 0;
        for (int j = 0; j <= index - 1; j++) {
            inorder_left[i] = inorder[j];
            i++;
        }

        int[] inorder_right = new int[inorder.length - index - 1];
        i = 0;
        for (int j = index + 1; j <= inorder.length - 1; j++) {
            inorder_right[i] = inorder[j];
            i++;
        }

        int[] preorder_left = new int[index];
        i = 0;
        for (int j = 1; j <= index; j++) {
            preorder_left[i] = preorder[j];
            i++;
        }

        int[] preorder_right = new int[preorder.length - index - 1];
        i = 0;
        for (int j = index + 1; j <= preorder.length - 1; j++) {
            preorder_right[i] = preorder[j];
            i++;
        }

        node.left = buildTree(preorder_left, inorder_left);
        node.right = buildTree(preorder_right, inorder_right);
        return node;
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