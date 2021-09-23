import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class t面试题_1715 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_1715 {
    HashSet<String> words_set = new HashSet<>();

    public String longestWord(String[] words) {
        for (String word : words) {
            words_set.add(word);
        }
        // 对字符串数组排序
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    // o1排o2前面
                    return -1;
                } else if (o1.length() < o2.length()) {
                    return 1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

        for (int i = 0; i < words.length; i++) {
            boolean flag = backtrack(0, words[i]);
            if (flag) {
                return words[i];
            }
        }
        return "";
    }

    boolean backtrack(int start, String word) {
        // 判断字符串word从start开始，能否由其他单词组成
        if (start >= word.length()) {
            return true;
        }
        for (int end = start + 1; end <= word.length(); end++) {
            if (end - start == word.length()) {
                continue;
            }
            if (words_set.contains(word.substring(start, end))) {
                boolean flag = backtrack(end, word);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }
}