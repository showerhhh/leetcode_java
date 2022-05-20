public class t4 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t4 {
    public double findMedianSortedArrays_2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int i = 0, j = 0, k = 0;
        int[] merge = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merge[k++] = nums1[i++];
            } else {
                merge[k++] = nums2[j++];
            }
        }
        while (i < m) {
            merge[k++] = nums1[i++];
        }
        while (j < n) {
            merge[k++] = nums2[j++];
        }
        int mid = (m + n) / 2;
        if ((m + n) % 2 == 1) {
            return merge[mid];
        } else {
            return (merge[mid] + merge[mid - 1]) / 2.0;
        }
    }
}