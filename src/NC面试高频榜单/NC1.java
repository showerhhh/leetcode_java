package NC面试高频榜单;

public class NC1 {
    public static void main(String[] args) {
        Solution_NC1 solution = new Solution_NC1();
        solution.solve("1", "99");
    }
}

class Solution_NC1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        // write code here
        StringBuilder builder = new StringBuilder();
        char[] sl = s.toCharArray();
        char[] tl = t.toCharArray();
        int carry = 0;
        int i = sl.length - 1, j = tl.length - 1;
        while (i >= 0 && j >= 0) {
            int sch = sl[i] - '0';
            int tch = tl[j] - '0';
            builder.insert(0, (char) ((sch + tch + carry) % 10 + '0'));
            carry = (sch + tch + carry) / 10;
            i--;
            j--;
        }
        while (i >= 0) {
            int sch = sl[i] - '0';
            builder.insert(0, (char) ((sch + carry) % 10 + '0'));
            carry = (sch + carry) / 10;
            i--;
        }
        while (j >= 0) {
            int tch = tl[j] - '0';
            builder.insert(0, (char) ((tch + carry) % 10 + '0'));
            carry = (tch + carry) / 10;
            j--;
        }
        if (carry != 0) {
            builder.insert(0, (char) (carry + '0'));
        }
        return builder.toString();
    }
}