public class t208 {
}

class Trie {
    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {

    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {

    }

    class TreeNode {
        int[] children;
        boolean isEnd;

        public TreeNode() {
            children = new int[26];
            for (int i = 0; i < children.length; i++) {
                children[i] = 0;
            }
            isEnd = false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */