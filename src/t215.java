public class t215 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        Solution_t215 solution = new Solution_t215();
        System.out.println(solution.findKthLargest(nums, k));
    }
}

class Solution_t215 {
    public int findKthLargest(int[] nums, int k) {
        //        Arrays.sort(nums);
        quickSort(nums, 0, nums.length - 1);
        //        mergeSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pos = partition(nums, low, high);
            quickSort(nums, low, pos - 1);
            quickSort(nums, pos + 1, high);
        }
    }

    int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot)
                high--;
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot)
                low++;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
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
            if (nums[i] < nums[j]) {
                T[k++] = nums[i++];
            } else {
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
        for (int l = 0; l < T.length; l++) {
            nums[low + l] = T[l];
        }
    }
}