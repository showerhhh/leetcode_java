public class t面试题_1705 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_1705 {
    public String[] findLongestSubarray(String[] array) {
        int[] p = new int[array.length + 1];
        p[0] = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            char ch = array[i].charAt(0);
            if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
                count++;
            }
            p[i + 1] = count;
        }

        int recordi = 0, recordj = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (j - i + 1 == (p[j + 1] - p[i]) * 2 && j - i + 1 > recordj - recordi + 1) {
                    recordi = i;
                    recordj = j;
                }
            }
        }
        if (recordi == recordj) {
            return new String[0];
        }
        String[] res = new String[recordj - recordi + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = array[recordi + i];
        }
        return res;
    }
}