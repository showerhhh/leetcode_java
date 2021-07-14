import java.util.HashMap;
import java.util.Map;

public class t299 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t299 {
    public String getHint(String secret, String guess) {
        int countA = 0;
        HashMap<Character, Integer> map_gue = new HashMap<>();
        HashMap<Character, Integer> map_sec = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                countA++;
            }
            char gue = guess.charAt(i);
            map_gue.put(gue, map_gue.getOrDefault(gue, 0) + 1);
            char sec = secret.charAt(i);
            map_sec.put(sec, map_sec.getOrDefault(sec, 0) + 1);
        }
        int countB = 0;
        for (Map.Entry<Character, Integer> entry : map_sec.entrySet()) {
            char k = entry.getKey();
            int v_sec = entry.getValue();
            int v_gue = map_gue.getOrDefault(k, 0);
            countB += Math.min(v_sec, v_gue);
        }
        countB -= countA;
        return countA + "A" + countB + "B";
    }
}