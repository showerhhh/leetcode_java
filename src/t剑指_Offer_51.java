public class t剑指_Offer_51 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_51 {
    int count = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (high - low) / 2 + low;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    void merge(int[] nums, int low, int mid, int high) {
        int[] T = new int[high - low + 1];  //临时数组
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                T[k++] = nums[i++];
            } else {
                count += mid - i + 1;
                T[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            T[k++] = nums[i++];
        }
        while (j <= high) {
            T[k++] = nums[j++];
        }
        //复制
        System.arraycopy(T, 0, nums, low, T.length);
    }
}