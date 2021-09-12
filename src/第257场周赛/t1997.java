package 第257场周赛;

public class t1997 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t1997 {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        int[] count = new int[n];  //每个房间的被访问次数
        int visited = 0;  // 被访问过的房间数目
        int day = -1;  //天数
        int i = 0;  // 被访问的房间下标
        while (visited < n) {
            // 更新天数
            day = (int) ((day + 1) % (1e9 + 7));
            // 访问房间i
            if (count[i] == 0) {
                visited++;
            }
            count[i]++;
            // 更新下一个被访问的房间下标
            if (count[i] % 2 == 1) {
                i = nextVisit[i];
            } else {
                i = (i + 1) % n;
            }

        }
        return day;
    }
}