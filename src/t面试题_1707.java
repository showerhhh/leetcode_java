import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class t面试题_1707 {
    public static void main(String[] args) {
        String[] names = {"John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)"};
        String[] synonyms = {"(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)"};
        Solution_t面试题_1707 solution = new Solution_t面试题_1707();
        solution.trulyMostPopular_2(names, synonyms);
    }

}

class Solution_t面试题_1707 {
    HashMap<String, String> map = new HashMap<>();  // 并查集，key为元素，value为该元素的根元素

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        // 同义词放在一个set中
        ArrayList<HashSet<String>> set_list = new ArrayList<>();
        for (String s : synonyms) {
            String[] t = s.split(",");
            String name1 = t[0].substring(1);
            String name2 = t[1].substring(0, t[1].length() - 1);
            boolean flag = false;
            for (HashSet<String> set : set_list) {
                if (set.contains(name1) || set.contains(name2)) {
                    set.add(name1);
                    set.add(name2);
                    flag = true;
                }
            }
            if (!flag) {
                HashSet<String> new_set = new HashSet<>();
                new_set.add(name1);
                new_set.add(name2);
                set_list.add(new_set);
            }
        }

        // 用HashMap，方便查找
        HashMap<String, Integer> name_count = new HashMap<>();
        for (String s : names) {
            String[] t = s.split("\\(");
            String name = t[0];
            int count = Integer.parseInt(t[1].substring(0, t[1].length() - 1));
            name_count.put(name, count);
        }

        // 开始组建结果
        String[] res = new String[set_list.size()];
        int i = 0;
        for (HashSet<String> name_set : set_list) {
            String key_name = "ZZZZZZZZZZZZ";
            int count = 0;
            for (String name : name_set) {
                if (name.compareTo(key_name) < 0) {
                    key_name = name;
                }
                if (name_count.containsKey(name)) {
                    count += name_count.get(name);
                }
            }
            res[i] = key_name + "(" + count + ")";
            i++;
        }
        return res;
    }

    public String[] trulyMostPopular_2(String[] names, String[] synonyms) {
        // 初始化并查集中的元素，每个元素的根元素为其自身
        for (String s : names) {
            String[] t = s.split("\\(");
            String name = t[0];
            map.put(name, name);
        }

        for (String s : synonyms) {
            String[] t = s.split(",");
            String name1 = t[0].substring(1);
            String name2 = t[1].substring(0, t[1].length() - 1);
            // 并查集中没有的元素，初始化
            if (!map.containsKey(name1)) {
                map.put(name1, name1);
            }
            if (!map.containsKey(name2)) {
                map.put(name2, name2);
            }

            // 查找根元素，并将其合并
            String f1 = find(name1);
            String f2 = find(name2);
            // 将字典序小的根元素作为新的根元素
            if (f1.compareTo(f2) < 0) {
                map.put(f2, f1);
            } else {
                map.put(f1, f2);
            }
        }

        // 将所有元素的count累加到根元素上（列表中只存储根元素的count）
        HashMap<String, Integer> root_count = new HashMap<>();
        for (String s : names) {
            String[] t = s.split("\\(");
            String name = t[0];
            String root = find(name);
            int count = Integer.parseInt(t[1].substring(0, t[1].length() - 1));
            root_count.put(root, root_count.getOrDefault(root, 0) + count);
        }

        // 将root_count输出成指定格式
        String[] res = new String[root_count.size()];
        int i = 0;
        for (Map.Entry<String, Integer> entry : root_count.entrySet()) {
            String root = entry.getKey();
            int count = entry.getValue();
            res[i] = root + "(" + count + ")";
            i++;
        }
        return res;
    }

    String find(String s) {
        if (map.get(s).equals(s)) {
            return s;
        } else {
            String root = find(map.get(s));
            map.put(s, root);
            return root;
        }
    }
}