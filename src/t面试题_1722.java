import java.util.ArrayList;
import java.util.List;

public class t面试题_1722 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_1722 {
    boolean[] visited;
    ArrayList<String> list;

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        visited = new boolean[wordList.size()];
        list = new ArrayList<>();
        list.add(beginWord);
        boolean flag = backtrack(beginWord, endWord, wordList);
        if (flag) {
            return list;
        } else {
            return new ArrayList<>();
        }
    }

    boolean check(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n != m) {
            return false;
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }

    boolean backtrack(String curWord, String endWord, List<String> wordList) {
        if (curWord.equals(endWord)) {
            return true;
        }
        for (int i = 0; i < wordList.size(); i++) {
            if (visited[i] || !check(curWord, wordList.get(i))) {
                continue;
            }
            visited[i] = true;
            list.add(wordList.get(i));
            boolean flag = backtrack(wordList.get(i), endWord, wordList);
            if (flag) {
                return true;
            }
            list.remove(list.size() - 1);
            // 不能将visited[i]重置为false，因为有回路
        }
        return false;
    }
}