public class t剑指_Offer_05 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_05 {
    public String replaceSpace(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
        }
        int n = s.length() + 2 * count;
        char[] res = new char[n];
        int i = s.length() - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (s.charAt(i) != ' ') {
                res[j] = s.charAt(i);
            } else {
                res[j] = '0';
                j--;
                res[j] = '2';
                j--;
                res[j] = '%';
            }
            i--;
            j--;
        }
        return new String(res, 0, n);
        // 字符数组转字符串
        // String str = new String(array);
        // String str = String.valueOf(array);
        // 字符串转字符数组：
        // char[] array = str.toCharArray();
    }
}