import java.util.Arrays;
import java.util.Comparator;

public class t剑指_Offer_45 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_45 {
    public String minNumber(int[] nums) {
        String[] s_list = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s_list[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(s_list, new Comp());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s_list.length; i++) {
            builder.append(s_list[i]);
        }
        return builder.toString();
    }

    class Comp implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int i = (o1 + o2).compareTo(o2 + o1);
            if (i < 0) {
                // o1在前
                return -1;
            } else if (i > 0) {
                // o2在前
                return 1;
            } else {
                return 0;
            }
        }
    }
}