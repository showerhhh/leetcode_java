public class t面试题_1602 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class WordsFrequency {
    Node root;

    public WordsFrequency(String[] book) {
        root = new Node();
        for (String word : book) {
            insert(word);
        }
    }

    public int get(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int idx = ch - 'a';
            if (cur.children[idx] == null) {
                return 0;
            }
            cur = cur.children[idx];
        }
        return cur.count;
    }

    void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int idx = ch - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new Node();
            }
            cur = cur.children[idx];
        }
        cur.end = true;
        cur.count++;
    }

    class Node {
        Node[] children;
        boolean end;
        int count;

        Node() {
            children = new Node[26];
            end = false;
            count = 0;
        }
    }
}

/**
 * Your WordsFrequency object will be instantiated and called as such:
 * WordsFrequency obj = new WordsFrequency(book);
 * int param_1 = obj.get(word);
 */