import java.util.Arrays;

public class t剑指_Offer_33 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 1 || postorder.length == 0) {
            return true;
        }

        // 对后序遍历排序得到中序遍历
        int[] tmp = Arrays.copyOfRange(postorder, 0, postorder.length);
        Arrays.sort(tmp);
        int[] inorder = Arrays.copyOfRange(tmp, 0, tmp.length);
        // 查找根节点在中序遍历中的index
        int val = postorder[postorder.length - 1];
        int index = Arrays.binarySearch(inorder, val);
        // 获取左右子树的postorder
        int[] left = Arrays.copyOfRange(postorder, 0, index);
        int[] right = Arrays.copyOfRange(postorder, index, postorder.length - 1);

        for (int i = 0; i < left.length; i++) {
            if (left[i] > val) {
                return false;
            }
        }
        for (int i = 0; i < right.length; i++) {
            if (right[i] < val) {
                return false;
            }
        }

        boolean flag1 = verifyPostorder(left);
        boolean flag2 = verifyPostorder(right);
        return flag1 && flag2;
    }
}