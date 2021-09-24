public class t208 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Trie {
    Trie[] children;
    boolean isWord;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        children = new Trie[26];
        isWord = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        // 向前缀树中插入字符串 word
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        // 字符串 word 是否为字典树中的单词。
        Trie curNode = this;  // 指向根节点
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            int index = curChar - 'a';
            if (curNode.children[index] == null) {
                return false;
            }
            curNode = curNode.children[index];
        }
        return curNode.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // 字符串 prefix 是否为字典树中单词的前缀。
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */