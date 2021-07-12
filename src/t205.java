import java.util.HashMap;

public class t205 {
    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        Solution_t205 solution = new Solution_t205();
        System.out.println(solution.isIsomorphic(s, t));
    }
}

class Solution_t205 {
    public boolean isIsomorphic(String s, String t) {
        return f(s, t) && f(t, s);
    }

    boolean f(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char value = t.charAt(i);
            char tmp = map.getOrDefault(key, ' ');
            if (tmp != ' ') {
                if (tmp != value) {
                    return false;
                }
            } else {
                map.put(key, value);
            }
        }
        return true;
    }
}