import java.util.ArrayList;

public class t173 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class BSTIterator {
    ArrayList<Integer> list;
    int i;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<Integer>();
        func(root);
        i = 0;
    }

    void func(TreeNode node) {
        if (node == null) {
            return;
        }
        func(node.left);
        list.add(node.val);
        func(node.right);
    }

    public int next() {
        int tmp = list.get(i);
        i++;
        return tmp;
    }

    public boolean hasNext() {
        if (i < list.size()) {
            return true;
        } else {
            return false;
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

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */