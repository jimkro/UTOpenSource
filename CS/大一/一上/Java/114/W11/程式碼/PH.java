import java.util.*;

public class PH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int s = sc.nextInt();
            int[][] arr = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
            }

            // 先找他在哪一排 介於區間內就離開
            int l = 0, r = m-1, find = 0;
            while (l <= r) {
                int mid = l + (r-l) / 2;
                if (s >= arr[mid][0] && s <= arr[mid][n-1]) {
                    System.out.println("true");
                    find = mid;
                    break;
                } else if (arr[mid][n-1] > s) r = mid - 1;
                else l = mid + 1;
                System.out.print("false ");
            }

            // 再找他在哪一個位置 找到該值就離開
            l = 0;
            r = n-1;
            while (l <= r) {
                int mid = l + (r-l) / 2;
                if (arr[find][mid] == s) {
                    System.out.println("true");
                    System.out.println(find + " " + mid);
                    break;
                } else if (arr[find][mid] > s) r = mid - 1;
                else l = mid + 1;
                System.out.print("false ");
            }
        }
        sc.close();
    }
}
