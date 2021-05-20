import java.util.*;

public class t692 {
    public static void main(String[] args) {
        Solution_t692 solution = new Solution_t692();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        solution.topKFrequent(words, k);
    }
}

class Solution_t692 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        ArrayList<String> t = new ArrayList<>();
        for (String s : map.keySet()) {
            t.add(s);
        }

        class Comp implements Comparator<String> {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1) > map.get(o2)) {
                    return -1;
                } else if (map.get(o1) < map.get(o2)) {
                    return 1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        }

        Collections.sort(t, new Comp());
        return t.subList(0, k);
    }
}