import java.util.Arrays;

public class t面试题_1011 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_1011 {
    public void wiggleSort(int[] nums) {
        int[] nums2 = nums.clone();
        Arrays.sort(nums2);
        int i = 0, j = nums2.length - 1, k = 0;
        while (i < j) {
            nums[k++] = nums2[j--];
            nums[k++] = nums2[i++];
        }
        if (i == j) {
            nums[k] = nums2[i];
        }
    }
}