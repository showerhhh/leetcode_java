public class t1310 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int tmp = 0;
            for (int j = start; j <= end; j++) {
                tmp = tmp ^ arr[j];
            }
            result[i] = tmp;
        }
        return result;
    }
}