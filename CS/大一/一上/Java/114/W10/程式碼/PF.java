import java.util.*;

public class PF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int p = sc.nextInt();
            if (n == 0 && m == 0 && p == 0) break;

            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
            }

            // 紀錄最大值
            int[][] ans = new int[n][n];
            int idx1 = 0, idx2 = 0;

            // 從 0 開始到 n-m 就停止 否則會超出範圍
            for (int k = 0; k <= n-m; k+=p) {
                idx2 = 0;
                for (int q = 0; q <= n-m; q+=p) {
                    int maxNum = 0;
                    for (int i = k; i < k+m; i++) {
                        for (int j = q; j < q+m; j++) {
                            maxNum = Math.max(maxNum, arr[i][j]);
                        }
                    }
                    ans[idx1][idx2] = maxNum;
                    idx2++;
                }
                idx1++;
            }

            for (int i = 0; i < idx1; i++) {
                for (int j = 0; j < idx2; j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println();
        }
        sc.close();
    }
}