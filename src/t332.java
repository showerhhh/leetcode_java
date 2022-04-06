import java.util.*;

public class t332 {
    public static void main(String[] args) {
        ArrayList<List<String>> tickets = new ArrayList<>();
        tickets.add(new ArrayList<>(Arrays.asList("JFK", "SFO")));
        tickets.add(new ArrayList<>(Arrays.asList("JFK", "ATL")));
        tickets.add(new ArrayList<>(Arrays.asList("SFO", "ATL")));
        tickets.add(new ArrayList<>(Arrays.asList("ATL", "JFK")));
        tickets.add(new ArrayList<>(Arrays.asList("ATL", "SFO")));
        Solution_t332 solution = new Solution_t332();
        solution.findItinerary(tickets);
    }
}

class Solution_t332 {
    ArrayList<String> res;
    boolean complete = false;

    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int x = o1.get(0).compareTo(o2.get(0));
                if (x != 0) {
                    return x;
                } else {
                    return o1.get(1).compareTo(o2.get(1));
                }
            }
        });  // 排序之后，只保存第一个结果就行
        backtracking(tickets, new boolean[tickets.size()], new ArrayList<>(Arrays.asList("JFK")));
        return res;
    }

    void backtracking(List<List<String>> tickets, boolean[] used, ArrayList<String> list) {
        if (!complete && list.size() == tickets.size() + 1) {
            res = new ArrayList<>(list);
            complete = true;
            return;
        }
        String curState = list.get(list.size() - 1);
        for (int i = 0; i < tickets.size(); i++) {
            if (!complete && tickets.get(i).get(0).equals(curState) && !used[i]) {
                used[i] = true;
                list.add(tickets.get(i).get(1));
                backtracking(tickets, used, list);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
}