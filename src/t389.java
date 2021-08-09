import java.util.HashMap;
import java.util.Map;

public class t389 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t389 {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> s_map = new HashMap<>();
        HashMap<Character, Integer> t_map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char s_ch = s.charAt(i);
            s_map.put(s_ch, s_map.getOrDefault(s_ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char t_ch = t.charAt(i);
            t_map.put(t_ch, t_map.getOrDefault(t_ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : t_map.entrySet()) {
            char k = entry.getKey();
            int v = entry.getValue();
            if (v != s_map.getOrDefault(k, 0)) {
                return k;
            }
        }
        return ' ';
    }
}