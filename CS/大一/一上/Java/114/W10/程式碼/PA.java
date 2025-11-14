import java.util.*;

public class PA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 用dx dy先判斷所在位置的九宮格會不會超出範圍
        int[] dx = {1,-1,0,0,1,1,-1,-1}; // 下 上 左 右 右下 左下 右上 左上 row
        int[] dy = {0,0,1,-1,1,-1,1,-1}; // 下 上 左 右 右下 左下 右上 左上 column
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            if(n == 0) break;
            double[][] m = new double[n][n];
            double[][] ans = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) m[i][j] = sc.nextDouble();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (m[i][j] == 0.0) {
                        double sum = 0;
                        int total_w = 0;
                        // 看九宮格哪些是合法的
                        for (int k = 0; k < 8; k++) {
                            int new_i = i + dx[k];
                            int new_j = j + dy[k];
                            if (check(new_i, new_j, n)) {
                                int w = 1;
                                // 上下左右的權重是2
                                if(k < 4) w = 2;
                                sum += m[new_i][new_j] * w;
                                total_w += w;
                            }
                        }
                        ans[i][j] = sum / total_w;
                    } else ans[i][j] = m[i][j];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%.1f ", ans[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
        sc.close();
    }

    // 檢查有沒有越界
    private static boolean check(int i, int j, int n){
        return i >= 0 && i < n && j >= 0 && j < n;
    }
}