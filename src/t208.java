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
        Trie node = searchPrefix(word);
        if (node != null && node.isWord) {
            return true;
        } else {
            return false;
        }
    }

    public boolean search_2(String word) {
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
        Trie node = searchPrefix(prefix);
        if (node != null) {
            return true;
        } else {
            return false;
        }
    }

    Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */