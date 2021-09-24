import java.util.ArrayList;

public class t面试题_1717 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_1717 {
    Node root = new Node();
    ArrayList<Integer>[] res_list;

    public int[][] multiSearch(String big, String[] smalls) {
        res_list = new ArrayList[smalls.length];
        for (int i = 0; i < smalls.length; i++) {
            if (smalls[i].length() == 0) {
                // 空字符串不插入字典树中
                continue;
            }
            insert(smalls[i], i);
            res_list[i] = new ArrayList();
        }
        for (int i = 0; i < big.length(); i++) {
            func(big.substring(i), i);
        }

        int[][] res = new int[smalls.length][];
        for (int i = 0; i < smalls.length; i++) {
            ArrayList<Integer> list = res_list[i];
            if (list == null) {
                res[i] = new int[0];
                continue;
            }
            int size = list.size();
            res[i] = new int[size];
            for (int j = 0; j < size; j++) {
                res[i][j] = list.get(j);
            }
        }
        return res;
    }

    void func(String s, int bid) {
        // 字典树中单词是否为字符串s的前缀
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            if (cur.sid != -1) {
                // s的前缀在字典树中
                res_list[cur.sid].add(bid);
            }
            char ch = s.charAt(i);
            int idx = ch - 'a';
            if (cur.children[idx] == null) {
                return;
            }
            cur = cur.children[idx];
        }
        if (cur.sid != -1) {
            // s的前缀在字典树中
            res_list[cur.sid].add(bid);
        }
    }

    void insert(String s, int sid) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new Node();
            }
            cur = cur.children[idx];
        }
        cur.sid = sid;
    }

    class Node {
        Node[] children;
        int sid;

        Node() {
            children = new Node[26];
            sid = -1;
        }
    }
}