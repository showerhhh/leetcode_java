public class t面试题_0103 {
    public static void main(String[] args) {
        Solution_t面试题_0103 solution = new Solution_t面试题_0103();
        String S = "ds sdfs afs sdfa dfssf asdf             ";
        int length = 27;
        System.out.println(solution.replaceSpaces(S, length));
    }
}

class Solution_t面试题_0103 {
    public String replaceSpaces(String S, int length) {
        char[] tmp = S.toCharArray();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (tmp[i] == ' ') {
                count++;
            }
        }
        char[] arr = new char[length + count * 2];
        for (int i = 0; i < length; i++) {
            arr[i] = tmp[i];
        }

        int i = length - 1;
        int j = arr.length - 1;
        while (i != j) {
            if (arr[i] != ' ') {
                arr[j] = arr[i];
                i--;
                j--;
            } else {
                i--;
                arr[j] = '0';
                arr[j - 1] = '2';
                arr[j - 2] = '%';
                j -= 3;
            }
        }
        return String.valueOf(arr);
    }
}