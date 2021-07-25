import java.util.HashMap;
import java.util.Map;

public class t387 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t387 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, i);
            } else {
                map.put(ch, -1);  // -1表示该字符已经重复出现
            }
        }

        int idx = s.length();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int v = entry.getValue();
            if (v != -1 && v < idx) {
                idx = v;
            }
        }
        return idx == s.length() ? -1 : idx;
    }
}