import java.util.ArrayList;

public class t99 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t99 {
    TreeNode x;
    TreeNode y;
    TreeNode pre;

    public void recoverTree(TreeNode root) {
        inorder(root);
        // 交换
        if (x != null && y != null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (pre == null) {
            pre = root;
        } else {
            // 对于x.val>y.val的一对数据，记录第一对中的x，最后一对中的y
            if (pre.val > root.val) {
                y = root;
                if (x == null) {
                    x = pre;
                }
            }
            // 更新pre
            pre = root;
        }
        inorder(root.right);
    }

    public void recoverTree_2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inoder_2(list, root);
        int[] x_y = find_two_swap(list);
        recover(root, x_y[0], x_y[1]);
    }

    void inoder_2(ArrayList<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inoder_2(list, root.left);
        list.add(root.val);
        inoder_2(list, root.right);
    }

    int[] find_two_swap(ArrayList<Integer> list) {
        int x = -1, y = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            // 对于x.val>y.val的一对数据，记录第一对中的x，最后一对中的y
            if (list.get(i) > list.get(i + 1)) {
                y = list.get(i + 1);
                if (x == -1) {
                    x = list.get(i);
                }
            }
        }
        return new int[]{x, y};
    }

    void recover(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }
        if (root.val == x) {
            root.val = y;
        } else if (root.val == y) {
            root.val = x;
        }
        recover(root.left, x, y);
        recover(root.right, x, y);
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