import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class t599 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }
        HashMap<String, Integer> map3 = new HashMap<>();
        int minIdx = list1.length + list2.length;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String k = entry.getKey();
            int v1 = entry.getValue();
            if (map2.containsKey(k)) {
                int v2 = map2.get(k);
                int idx = v1 + v2;
                map3.put(k, idx);
                if (idx < minIdx) {
                    minIdx = idx;
                }
            }
        }
        ArrayList<String> res_list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map3.entrySet()) {
            if (entry.getValue() == minIdx) {
                res_list.add(entry.getKey());
            }
        }
        return res_list.toArray(new String[0]);
    }
}