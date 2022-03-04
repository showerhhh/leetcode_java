public class t344 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t344 {
    public void reverseString(char[] s) {
        char tmp;
        int n = s.length;
        for (int i = 0; i < n / 2; i++) {
            tmp = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = tmp;
        }
    }
}