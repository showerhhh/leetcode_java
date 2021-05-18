public class t211 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class WordDictionary {
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            int index = curChar - 'a';
            if (curNode.children[index] == null) {
                curNode.children[index] = new TrieNode();
            }
            curNode = curNode.children[index];
        }
        curNode.isWord = true;
    }

    public boolean search(String word) {
        return searchWord(word, root);
    }

    boolean searchWord(String word, TrieNode curNode) {
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            int index = curChar - 'a';
            if (curChar == '.') {
                // 是通配符
                for (int j = 0; j < 26; j++) {
                    if (curNode.children[j] != null) {
                        if (searchWord(word.substring(i + 1), curNode.children[j])) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                // 不是通配符
                if (curNode.children[index] == null) {
                    // 下一节点为空
                    return false;
                } else {
                    // 下一节点不为空
                    curNode = curNode.children[index];
                }
            }
        }
        return curNode.isWord;
    }

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */