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