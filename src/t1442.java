public class t1442 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 6, 7};
        Solution_t1442 solution = new Solution_t1442();
        System.out.println(solution.countTriplets(arr));
    }
}

class Solution_t1442 {
    public int countTriplets(int[] arr) {
        int[] copyArr = new int[arr.length + 1];
        for (int i = 1; i < copyArr.length; i++) {
            copyArr[i] = arr[i - 1];
        }

        int[] preXor = new int[arr.length + 1];
        preXor[0] = 0;
        for (int i = 1; i < preXor.length; i++) {
            preXor[i] = preXor[i - 1] ^ copyArr[i];
        }

        int count = 0;
        for (int i = 1; i < copyArr.length; i++) {
            for (int j = i + 1; j < copyArr.length; j++) {
                for (int k = j; k < copyArr.length; k++) {
                    int a = preXor[i - 1] ^ preXor[j - 1];
                    int b = preXor[j - 1] ^ preXor[k];
                    if (a == b) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}