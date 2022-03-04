import java.util.HashMap;

public class t454 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums1[i] + nums2[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int target = -(nums3[i] + nums4[j]);
                count += map.getOrDefault(target, 0);
            }
        }
        return count;
    }
}