public class t剑指_Offer_33 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_33 {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder_v2(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder_v2(int[] postorder, int l, int r) {
        if (l >= r) {
            return true;
        }
        int root = postorder[r];
        // 查找第一个比root大的数字的位置
        int idx = 0;
        while (postorder[idx] < root) {
            idx++;
        }
        // 检查idx~r-1位置的数字是否都比root大
        boolean flag = true;
        for (int i = idx; i <= r - 1; i++) {
            if (postorder[i] < root) {
                flag = false;
            }
        }
        boolean flag1 = verifyPostorder_v2(postorder, l, idx - 1);
        boolean flag2 = verifyPostorder_v2(postorder, idx, r - 1);
        return flag && flag1 && flag2;
    }
}