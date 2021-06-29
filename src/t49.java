import java.util.*;

public class t49 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] str_array = str.toCharArray();
            Arrays.sort(str_array);
            String sorted_str = new String(str_array);
            List<String> value = map.getOrDefault(sorted_str, new ArrayList<>());
            value.add(str);
            map.put(sorted_str, value);
        }

        ArrayList<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}