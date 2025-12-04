import java.util.*;

public class PB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) arr[i][j] = sc.nextInt();
            }
            
            int target = sc.nextInt();

            // 存答案
            int[][] ans = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == target) {
                        // 存跟 target 在同一 column 的數字
                        for (int k = 0; k < n; k++) ans[k][j] = arr[k][j];
                        // 存跟 target 在同一 row 的數字
                        for (int k = 0; k < m; k++) ans[i][k] = arr[i][k];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) System.out.printf("%3d ", ans[i][j]);
                System.out.println();
            }
            System.out.println();
        }
        sc.close();
    }
}