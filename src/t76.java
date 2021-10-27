import java.util.HashMap;

public class t76 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> count = new HashMap<>();  // count记录每一字符还需要被覆盖多少次
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        int i = 0, minLength = s.length() + 1, min_i = 0, min_j = 0;
        for (int j = 0; j < s.length(); j++) {
            char ch_j = s.charAt(j);
            if (count.containsKey(ch_j)) {
                count.put(ch_j, count.get(ch_j) - 1);
            }
            while (check(count)) {
                int length = j - i + 1;
                if (length < minLength) {
                    minLength = length;
                    min_i = i;
                    min_j = j;
                }
                char ch_i = s.charAt(i);
                if (count.containsKey(ch_i)) {
                    count.put(ch_i, count.get(ch_i) + 1);
                }
                i++;
            }
        }
        if (minLength == s.length() + 1) {
            return "";
        } else {
            return s.substring(min_i, min_j + 1);
        }
    }

    boolean check(HashMap<Character, Integer> count) {
        // 检查count中的value均<=0
        for (int v : count.values()) {
            if (v > 0) {
                return false;
            }
        }
        return true;
    }
}