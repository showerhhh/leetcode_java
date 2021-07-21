import java.util.HashMap;
import java.util.Map;

public class t447 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t447 {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            // map记录points[i]到所有点的距离的个数，距离:个数
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                int dist = dx * dx + dy * dy;
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int v = entry.getValue();
                count += v * (v - 1);
            }
        }
        return count;
    }
}