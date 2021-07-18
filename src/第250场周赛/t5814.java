package 第250场周赛;

public class t5814 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t5814 {
    public int addRungs(int[] rungs, int dist) {
        // 超时
        int cur = 0;
        int count = 0;
        for (int i = 0; i < rungs.length; i++) {
            int next = rungs[i];
            if (next - cur <= dist) {
                cur = next;
            } else {
                while (next - cur > dist) {
                    count++;
                    cur += dist;
                }
                cur = next;
            }
        }
        return count;
    }

    public int addRungs_2(int[] rungs, int dist) {
        // 通过
        double[] cha = new double[rungs.length];
        cha[0] = rungs[0];
        for (int i = 1; i < rungs.length; i++) {
            cha[i] = rungs[i] - rungs[i - 1];
        }
        int count = 0;
        for (int i = 0; i < cha.length; i++) {
            count += Math.ceil(cha[i] / dist) - 1;
        }
        return count;
    }
}