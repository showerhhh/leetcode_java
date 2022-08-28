public class t75 {
}

class Solution_t75 {
    public void sortColors(int[] nums) {
        // 计数，两遍扫描
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
                default:
                    break;
            }
        }
        int k = 0;
        for (int i = 0; i < count0; i++) {
            nums[k++] = 0;
        }
        for (int i = 0; i < count1; i++) {
            nums[k++] = 1;
        }
        for (int i = 0; i < count2; i++) {
            nums[k++] = 2;
        }
    }

    public void sortColors_2(int[] nums) {
        // 两遍扫描
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, p, i);  // 换出来到i位置上的，一定非0
                p++;
            }
        }
        for (int i = p; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, p, i);
                p++;
            }
        }
    }

    public void sortColors_3(int[] nums) {
        // 一遍扫描
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        int i = 0;
        while (i <= p2) {
            while (i <= p2 && nums[i] == 2) {
                swap(nums, p2, i);  // 换出来到i位置上的，有可能为0、1、2，为2要继续换，为零要用下面的if代码
                p2--;
            }
            if (nums[i] == 0) {
                swap(nums, p0, i);  // 换出来到i位置上的，一定非0，又因为2已经被换走了，所以一定不是2，那就是1
                p0++;
            }
            i++;
        }
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}