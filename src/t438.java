import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class t438 {
}

class Solution_t438 {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < p.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            if (map.get(ch) == 0) {
                map.remove(ch);
            }
        }
        if (map.isEmpty()) {
            res.add(0);
        }
        int start = 0, end = p.length() - 1;
        while (end + 1 < s.length()) {
            end++;
            char endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) - 1);
            if (map.get(endChar) == 0) {
                map.remove(endChar);
            }
            char startChar = s.charAt(start);
            map.put(startChar, map.getOrDefault(startChar, 0) + 1);
            if (map.get(startChar) == 0) {
                map.remove(startChar);
            }
            start++;
            if (map.isEmpty()) {
                res.add(start);
            }
        }
        return res;
    }
}