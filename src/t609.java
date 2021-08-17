import java.util.*;

public class t609 {
    public static void main(String[] args) {
        Solution_t609 solution = new Solution_t609();
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        solution.findDuplicate(paths);
    }
}

class Solution_t609 {
    public List<List<String>> findDuplicate(String[] paths) {
        ArrayList<Node> files = process(paths);

        HashMap<String, HashSet<String>> map = new HashMap<>();
        for (Node file : files) {
            if (map.containsKey(file.data)) {
                map.get(file.data).add(file.path);
            } else {
                HashSet<String> t = new HashSet<>();
                t.add(file.path);
                map.put(file.data, t);
            }
        }

        ArrayList<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, HashSet<String>> entry : map.entrySet()) {
            HashSet<String> set = entry.getValue();
            if (set.size() > 1) {
                ArrayList<String> t = new ArrayList<>(set);
                res.add(t);
            }
        }
        return res;
    }

    ArrayList<Node> process(String[] paths) {
        ArrayList<Node> res = new ArrayList<>();
        for (String path : paths) {
            String[] path_list = path.split(" ");
            String path_name = path_list[0] + "/";
            for (int i = 1; i < path_list.length; i++) {
                String[] file = path_list[i].split("\\(|\\)");
                String file_name = file[0];
                String file_data = file[1];
                Node t = new Node(path_name + file_name, file_data);
                res.add(t);
            }
        }
        return res;
    }

    class Node {
        String path;
        String data;

        public Node(String path, String data) {
            this.path = path;
            this.data = data;
        }
    }
}