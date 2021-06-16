import java.util.LinkedList;
import java.util.Queue;

public class t剑指_Offer_37 {
    public static void main(String[] args) {
        Codec codec = new Codec();
        String data = "[1,2,3,null,null,4,5]";
        Codec.TreeNode root = codec.deserialize(data);
        System.out.println(codec.serialize(root));
    }
}

class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 每个叶子节点会有两个子节点null被加入字符串中
        if (root == null) {
            return "[]";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                Integer tmp = node.val;
                builder.append(tmp.toString());
                builder.append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                builder.append("null,");
            }
        }

        builder.delete(builder.length() - 1, builder.length());
        builder.append("]");
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 输入的字符串所表示的树中，每个叶子节点必须要有两个子节点null
        if (data.equals("[]")) {
            return null;
        }
        String[] val_list = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(val_list[0]));
        int i = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (!val_list[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(val_list[i]));
                node.left = left;
                queue.offer(left);
            }
            i++;
            if (!val_list[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(val_list[i]));
                node.right = right;
                queue.offer(right);
            }
            i++;
        }

        return root;
    }

    //    这是超出时间或空间限制的算法
    //    int nullVal = Integer.MIN_VALUE;
    //
    //    // Encodes a tree to a single string.
    //    public String serialize(TreeNode root) {
    //        if (root == null) {
    //            return "[]";
    //        }
    //
    //        Queue<TreeNode> queue = new LinkedList<>();
    //        ArrayList<String> result = new ArrayList<>();
    //        queue.offer(root);
    //
    //        while (!queue.isEmpty()) {
    //            if (breakCheck(queue)) {
    //                // 如果当前队中所有节点值均为-1（空节点），则结束
    //                break;
    //            }
    //            int size = queue.size();
    //            for (int i = 0; i < size; i++) {
    //                TreeNode node = queue.poll();
    //                if (node.val == nullVal) {
    //                    result.add("null");
    //                } else {
    //                    Integer tmp = node.val;
    //                    result.add(tmp.toString());
    //                }
    //                if (node.left == null) {
    //                    queue.offer(new TreeNode(nullVal));
    //                } else {
    //                    queue.offer(node.left);
    //                }
    //                if (node.right == null) {
    //                    queue.offer(new TreeNode(nullVal));
    //                } else {
    //                    queue.offer(node.right);
    //                }
    //            }
    //        }
    //
    //        // 将result转化为队列
    //        StringBuilder builder = new StringBuilder();
    //        builder.append("[");
    //        for (int i = 0; i < result.size(); i++) {
    //            builder.append(result.get(i));
    //            builder.append(",");
    //        }
    //        builder.delete(builder.length() - 1, builder.length());
    //        builder.append("]");
    //        return builder.toString();
    //    }
    //
    //    boolean breakCheck(Queue<TreeNode> queue) {
    //        // 如果当前队中所有节点值均为-1（空节点），则返回true
    //        for (TreeNode node : queue) {
    //            if (node.val != nullVal) {
    //                return false;
    //            }
    //        }
    //        return true;
    //    }
    //
    //    // Decodes your encoded data to tree.
    //    public TreeNode deserialize(String data) {
    //        if (data.equals("[]")) {
    //            return null;
    //        }
    //        String[] val_list = data.substring(1, data.length() - 1).split(",");
    //        TreeNode root = func(val_list, 1);
    //        return root;
    //    }
    //
    //    TreeNode func(String[] val_list, int i) {
    //        if (i - 1 >= val_list.length || val_list[i - 1].equals("null")) {
    //            return null;
    //        }
    //        int val = Integer.parseInt(val_list[i - 1]);
    //        TreeNode node = new TreeNode(val);
    //        node.left = func(val_list, 2 * i);
    //        node.right = func(val_list, 2 * i + 1);
    //        return node;
    //    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));