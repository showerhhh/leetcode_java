import java.util.Arrays;
import java.util.Comparator;

public class t179 {
    public static void main(String[] args) {
        int[] nums = {45, 23};
        Solution_t179 solution = new Solution_t179();
        System.out.println(solution.largestNumber(nums));
    }
}

class Solution_t179 {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        Integer[] tmp = new Integer[len];
        for (int i = 0; i < len; i++) {
            tmp[i] = nums[i];
        }
        MyComparator cmp = new MyComparator();
        Arrays.sort(tmp, cmp);

        if(tmp[0] == 0){
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            result.append(tmp[i]);
        }
        return result.toString();
    }
}

class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        String s1 = o1.toString() + o2.toString();
        String s2 = o2.toString() + o1.toString();
        long t1 = Long.parseLong(s1);
        long t2 = Long.parseLong(s2);
        if (t1 > t2) {
            return -1;
        } else if (t1 < t2) {
            return 1;
        } else {
            return 0;
        }
    }
}