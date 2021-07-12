import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class t187 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t187 {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        int window_size = 10;
        for (int i = 0; i + window_size <= s.length(); i++) {
            String tmp = s.substring(i, i + window_size);
            int count = map.getOrDefault(tmp, 0);
            count += 1;
            map.put(tmp, count);
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}