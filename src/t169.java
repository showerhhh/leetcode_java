import java.util.HashMap;

public class t169 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        Solution_t169 solution = new Solution_t169();
        System.out.println(solution.majorityElement(nums));
    }
}

class Solution_t169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > n / 2) {
                return key;
            }
        }
        return -1;
    }

    public int majorityElement_2(int[] nums) {
        return func(nums, 0, nums.length - 1);
    }

    int func(int[] nums, int left, int right) {
        //返回nums数组中从下标left到下标right中的众数
        if (left == right) {
            return nums[left];
        }

        int mid = (right - left) / 2 + left;  //防止right+left超过int的表示范围
        int num1 = func(nums, left, mid);
        int num2 = func(nums, mid + 1, right);

        if (num1 == num2) {
            return num1;
        } else {
            int count1 = count(nums, num1, left, mid);
            int count2 = count(nums, num2, mid + 1, right);
            return count1 > count2 ? num1 : num2;
        }
    }

    int count(int[] nums, int digit, int left, int right) {
        int c = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == digit) {
                c++;
            }
        }
        return c;
    }

    public int majorityElement_3(int[] nums) {
        int candidate = 0, count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            } else {
                if (count == 0) {
                    candidate = num;
                    count = 1;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }

}