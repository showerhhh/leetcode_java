import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class t229 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t229 {
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        int count = 1;
        int k = nums.length / 3;
        if (count > k) {
            set.add(nums[0]);
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > k) {
                set.add(nums[i]);
            }
        }
        return new ArrayList<>(set);
    }

    public List<Integer> majorityElement_2(int[] nums) {
        // 摩尔投票找出两个出现次数最多的元素
        int candidate1 = nums[0];
        int count1 = 0;
        int candidate2 = nums[0];
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate1) {
                count1++;
            } else if (nums[i] == candidate2) {
                count2++;
            } else {
                if (count1 == 0) {
                    candidate1 = nums[i];
                    count1 = 1;
                } else if (count2 == 0) {
                    candidate2 = nums[i];
                    count2 = 1;
                } else {
                    count1--;
                    count2--;
                }
            }
        }

        // 判断这两个元素的出现次数是否超过了n/3
        int k1 = 0;
        int k2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate1) {
                k1++;
            } else if (nums[i] == candidate2) {
                k2++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        if (k1 > nums.length / 3) {
            list.add(candidate1);
        }
        if (k2 > nums.length / 3) {
            list.add(candidate2);
        }
        return list;
    }

    public int moore(int[] nums) {
        // 分为抵消阶段和计数阶段
        // 抵消阶段可以得到票数最多的一个候选人（或有其他人和该候选人的票数一样多）
        // 计数阶段看该候选人的票数是否超出一半

        // 抵消阶段
        int candidate = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                } else {
                    count--;
                }

            }
        }
        // 计数阶段
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate) {
                k++;
            }
        }
        if (k > nums.length / 2) {
            return candidate;
        } else {
            return -1;
        }
    }
}