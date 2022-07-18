package 蔚来笔试练习2;

public class t1 {
    public static void main(String[] args) {
        t1 t = new t1();
        System.out.println(t.f("abc123aee22"));
        System.out.println(t.f("abc12321a"));
        System.out.println(t.f("lxab321yyy"));
        System.out.println(t.f("flww12345677"));
    }

    boolean f(String s) {
        boolean flag = false;
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int start = i;
                int end = i;
                while (end < s.length() && Character.isDigit(s.charAt(end))) {
                    end++;
                }
                flag |= func(s.substring(start, end));
                i = end;
            } else {
                i++;
            }
        }
        return flag;
    }

    boolean func(String s) {
        // 判断数字字符串是否连续递增或递减
        boolean inc = true;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) - s.charAt(i - 1) != 1) {
                inc = false;
            }
        }
        boolean dec = true;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) - s.charAt(i - 1) != -1) {
                dec = false;
            }
        }
        return inc || dec;
    }
}
