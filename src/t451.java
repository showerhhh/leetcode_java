import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class t451 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t451 {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        String[] list = new String[map.size()];
        int i = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            list[i] = "";
            char k = entry.getKey();
            int v = entry.getValue();
            for (int j = 0; j < v; j++) {
                list[i] += String.valueOf(k);
            }
            i++;
        }

        Arrays.sort(list, new Comp());
        String res = "";
        for (int j = 0; j < list.length; j++) {
            res += list[j];
        }
        return res;
    }

    public String frequencySort_2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFren = 0;
        for (int i = 0; i < s.length(); i++) {
            char k = s.charAt(i);
            int v = map.getOrDefault(k, 0) + 1;
            map.put(k, v);
            if (v > maxFren) {
                maxFren = v;
            }
        }

        // 桶排序
        StringBuilder[] buckets = new StringBuilder[maxFren + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new StringBuilder();
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char k = entry.getKey();
            int v = entry.getValue();
            buckets[v].append(k);
        }
        // 构建字符串
        StringBuilder res = new StringBuilder();
        for (int i = maxFren; i >= 1; i--) {
            for (int j = 0; j < buckets[i].length(); j++) {
                char ch = buckets[i].charAt(j);
                for (int k = 0; k < i; k++) {
                    res.append(ch);
                }
            }
        }
        return res.toString();
    }

    class Comp implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length() > o2.length()) {
                // o1排前面
                return -1;
            } else if (o1.length() < o2.length()) {
                // o2排前面
                return 1;
            } else {
                return 0;
            }
        }
    }
}