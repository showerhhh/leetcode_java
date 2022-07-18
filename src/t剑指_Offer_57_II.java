import java.util.ArrayList;

public class t剑指_Offer_57_II {
    public static void main(String[] args) {
        Solution_t剑指_Offer_57_II solution = new Solution_t剑指_Offer_57_II();
        solution.findContinuousSequence(9);
    }
}

class Solution_t剑指_Offer_57_II {
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int l = 1, r = 1;
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        while (r < target / 2 + 2) {
            list.add(r);
            sum += r;
            r++;
            if (sum == target) {
                res.add(new ArrayList<>(list));
            }
            while (sum > target) {
                list.remove(0);
                sum -= l;
                l++;
            }
            if (sum == target) {
                res.add(new ArrayList<>(list));
            }
        }
        return res;
    }
}