import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class t1002 {
    public static void main(String[] args) {
        String[] words = {"bella", "label", "roller"};
        Solution_t1002 solution = new Solution_t1002();
        solution.commonChars(words);
    }
}

class Solution_t1002 {
    public List<String> commonChars(String[] words) {
        HashMap<Character, Integer>[] count_map = new HashMap[words.length];
        for (int i = 0; i < words.length; i++) {
            count_map[i] = new HashMap<>();
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                count_map[i].put(ch, count_map[i].getOrDefault(ch, 0) + 1);
            }
        }

        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            int min_count = Integer.MAX_VALUE;
            for (int j = 0; j < count_map.length; j++) {
                int count = count_map[j].getOrDefault(ch, 0);
                if (count < min_count) {
                    min_count = count;
                }
            }
            for (int j = 0; j < min_count; j++) {
                res.add(String.valueOf(ch));
            }
        }
        return res;
    }
}