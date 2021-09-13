import java.util.Arrays;

public class t面试题_1610 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_1610 {
    public int maxAliveYear(int[] birth, int[] death) {
        Arrays.sort(birth);
        Arrays.sort(death);
        int count = 0, maxCount = 0, maxYear = 1900;
        int i = 0, j = 0;
        while (i < birth.length && j < death.length) {
            if (birth[i] <= death[j]) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                    maxYear = birth[i];
                }
                i++;
            } else {
                count--;
                j++;
            }
        }
        while (i < birth.length) {
            count++;
            if (count > maxCount) {
                maxCount = count;
                maxYear = birth[i];
            }
            i++;
        }
        return maxYear;
    }

    public int maxAliveYear_2(int[] birth, int[] death) {
        int[] change = new int[102];
        for (int i = 0; i < birth.length; i++) {
            change[birth[i] - 1900]++;
            change[death[i] - 1900 + 1]--;
        }
        int count = 0, maxCount = 0, maxYear = 1900;
        for (int i = 0; i < change.length; i++) {
            count += change[i];
            if (count > maxCount) {
                maxCount = count;
                maxYear = i + 1900;
            }
        }
        return maxYear;
    }
}