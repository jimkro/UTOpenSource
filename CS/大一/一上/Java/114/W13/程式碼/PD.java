import java.util.*;

public class PD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int p = sc.nextInt();
            if (n == 0 && m == 0 && p == 0) break;
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
            }

            double[][] ans = new double[n][n];
            int idx1 = 0, idx2 = 0;
            for (int i = 0; i <= n-m; i+=p) {
                idx2 = 0;
                for (int j = 0; j <= n-m; j+=p) {
                    double total = 0;
                    for (int k = i; k < i+m; k++) {
                        for (int q = j; q < j+m; q++) {
                            total += arr[k][q];
                        }
                    }
                    ans[idx1][idx2] = total / (m*m);
                    idx2++;
                }
                idx1++;
            }

            for (int i = 0; i < idx1; i++) {
                for (int j = 0; j < idx2; j++) System.out.printf("%.2f ", ans[i][j]);
                System.out.println();
            }
            System.out.println();
        }
        sc.close();
    }
}