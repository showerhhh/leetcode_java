public class t4 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if ((m + n) % 2 == 1) {
            return getKth(nums1, 0, nums2, 0, (m + n + 1) / 2);
        } else {
            double t1 = getKth(nums1, 0, nums2, 0, (m + n) / 2);
            double t2 = getKth(nums1, 0, nums2, 0, (m + n + 2) / 2);
            return (t1 + t2) / 2;
        }
    }

    double getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        int len1 = nums1.length - start1;
        int len2 = nums2.length - start2;
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (len2 == 0) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] < nums2[j]) {
            return getKth(nums1, i + 1, nums2, start2, k - (i + 1 - start1));
        } else {
            return getKth(nums1, start1, nums2, j + 1, k - (j + 1 - start2));
        }
    }

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