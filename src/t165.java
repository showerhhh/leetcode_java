public class t165 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t165 {
    public int compareVersion(String version1, String version2) {
        String[] list1 = version1.split("\\.");
        String[] list2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < list1.length && j < list2.length) {
            int t = compare(list1[i], list2[j]);
            if (t != 0) {
                return t;
            } else {
                i++;
                j++;
            }
        }
        while (i < list1.length) {
            if (Integer.parseInt(list1[i]) > 0) {
                return 1;
            } else {
                i++;
            }
        }
        while (j < list2.length) {
            if (Integer.parseInt(list2[j]) > 0) {
                return -1;
            } else {
                j++;
            }
        }
        return 0;
    }

    int compare(String s1, String s2) {
        //s1大于s2,返回1；s1小于s2,返回-1；s1等于s2,返回0。
        int x = Integer.parseInt(s1);
        int y = Integer.parseInt(s2);
        if (x > y) {
            return 1;
        } else if (x < y) {
            return -1;
        } else {
            return 0;
        }
    }
}