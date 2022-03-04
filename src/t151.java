public class t151 {
    public static void main(String[] args) {
        String s = "the sky is blue";
        Solution_t151 solution = new Solution_t151();
        System.out.println(solution.reverseWords(s));
    }
}

class Solution_t151 {
    public String reverseWords(String s) {
        char[] t = s.toCharArray();
        int n = removeExtraSpace(t);
        reverse(t, 0, n - 1);
        int i = 0, j = 0;
        while (i < n) {
            while (i < n && t[i] != ' ') {
                i++;
            }
            reverse(t, j, i - 1);
            i++;
            j = i;
        }
        return new String(t, 0, n);
    }

    int removeExtraSpace(char[] t) {
        // 移除开头末尾空格，移除中间多余空格，返回值为移除后的字符串长度
        int i = 0, j = 0;
        while (i < t.length && t[i] == ' ') {
            i++;
        }
        while (i < t.length) {
            if (t[i] != ' ') {
                t[j++] = t[i++];
            } else {
                if (t[i - 1] != ' ') {
                    t[j++] = t[i++];
                } else {
                    i++;
                }
            }
        }
        while (j - 1 >= 0 && t[j - 1] == ' ') {
            j--;
        }
        return j;
    }

    void reverse(char[] t, int start, int end) {
        char tmp;
        while (start < end) {
            tmp = t[start];
            t[start] = t[end];
            t[end] = tmp;
            start++;
            end--;
        }
    }
}