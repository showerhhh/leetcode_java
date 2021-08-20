public class t541 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t541 {
    public String reverseStr(String s, int k) {
        char[] s_list = s.toCharArray();
        boolean flag = true;
        int start = 0;
        while (start < s_list.length) {
            int end = Math.min(s_list.length, start + k);
            if (flag) {
                reverse(s_list, start, end);
                flag = false;
            } else {
                flag = true;
            }
            start = end;
        }
        return String.valueOf(s_list);
    }

    void reverse(char[] s_list, int start, int end) {
        // 反转，从start开始（包含），到end截止（不包含）
        int len = end - start;
        for (int i = 0; i < len / 2; i++) {
            char tmp = s_list[start + i];
            s_list[start + i] = s_list[end - 1 - i];
            s_list[end - 1 - i] = tmp;
        }
    }
}