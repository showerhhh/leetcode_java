package 蔚来笔试练习2;

public class t2 {

    String f(String s, int k) {
        // 将大小为k的窗口内的字符串翻转，然后向右移动滑动窗口，继续翻转，求最终字符串
        int n = s.length();
        String s1 = s.substring(0, k-1);
        if ((n - k) % 2 == 0) {
            s1 = reverse(s1);
        }
        String s2 = s.substring(k-1);
        return s2 + s1;
    }

    String reverse(String s) {
        // 翻转字符串s
        char[] t = s.toCharArray();
        int n = t.length;
        for (int i = 0; i < n / 2; i++) {
            char tmp = t[i];
            t[i] = t[n - i - 1];
            t[n - i - 1] = tmp;
        }
        return t.toString();
    }
}
