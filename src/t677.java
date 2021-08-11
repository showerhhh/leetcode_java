public class t677 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class MapSum {
    Node root;
    int sumVal;

    public MapSum() {
        root = new Node();
        sumVal = 0;
    }

    public void insert(String key, int val) {
        Node curNode = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            int idx = (int) (ch - 'a');
            if (curNode.children[idx] == null) {
                curNode.children[idx] = new Node();
            }
            curNode = curNode.children[idx];
        }
        curNode.end = true;
        curNode.val = val;
    }

    public int sum(String prefix) {
        Node curNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int idx = (int) (ch - 'a');
            curNode = curNode.children[idx];
            // 没有以prefix为前缀的单词
            if (curNode == null) {
                return 0;
            }
        }
        sumVal = 0;
        dfs(curNode);
        return sumVal;
    }

    void dfs(Node node) {
        if (node == null) {
            return;
        }
        if (node.end) {
            sumVal += node.val;
        }
        for (int i = 0; i < node.children.length; i++) {
            dfs(node.children[i]);
        }
    }

    class Node {
        Node[] children;
        boolean end;
        int val;

        public Node() {
            children = new Node[26];
            end = false;
            val = 0;
        }
    }
}
