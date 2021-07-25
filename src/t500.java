import java.util.ArrayList;
import java.util.HashSet;

public class t500 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t500 {
    public String[] findWords(String[] words) {
        ArrayList<String> res = new ArrayList<>();
        HashSet<Character>[] sets = new HashSet[3];
        for (int i = 0; i < sets.length; i++) {
            sets[i] = new HashSet<>();
        }
        for (char ch : "qwertyuiop".toCharArray()) {
            sets[0].add(ch);
        }
        for (char ch : "asdfghjkl".toCharArray()) {
            sets[1].add(ch);
        }
        for (char ch : "zxcvbnm".toCharArray()) {
            sets[2].add(ch);
        }

        for (String word : words) {
            // 确定word首字母所在的集合targetSet
            String word_lower = word.toLowerCase();
            char ch = word_lower.charAt(0);
            HashSet<Character> targetSet = new HashSet<>();
            for (HashSet<Character> set : sets) {
                if (set.contains(ch)) {
                    targetSet = set;
                    break;
                }
            }
            // 判断其他字母是否在targetSet中
            boolean flag = true;
            for (int i = 1; i < word.length(); i++) {
                ch = word_lower.charAt(i);
                if (!targetSet.contains(ch)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }
}