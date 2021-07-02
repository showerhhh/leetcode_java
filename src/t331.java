public class t331 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t331 {
    public boolean isValidSerialization(String preorder) {
        String[] list = preorder.split(",");
        int n = list.length;
        boolean[] left = new boolean[n];
        boolean[] right = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (list[i].equals("#")) {
                left[i] = true;
                right[i] = true;
            }
        }

        for (int i = 1; i < n; i++) {
            boolean flag = false;
            for (int j = i - 1; j >= 0; j--) {
                if (!left[j]) {
                    left[j] = true;
                    flag = true;
                    break;
                } else if (!right[j]) {
                    right[j] = true;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!left[i]) {
                return false;
            }
            if (!right[i]) {
                return false;
            }
        }
        return true;
    }
}