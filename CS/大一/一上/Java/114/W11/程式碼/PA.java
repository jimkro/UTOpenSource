import java.util.*;

public class PA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 九宮格移動變化量
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int d1 = sc.nextInt();
            int d2 = sc.nextInt();
            String[] s = new String[n];
            for (int i = 0; i < n; i++) s[i] = sc.next();

            // 紀錄答案 多開兩格在外圍多包一圈避免溢位
            int[][] ans = new int[n+2][m+2];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (s[i-1].charAt(j-1) == 'V') {
                        // 透過 dx dy 跑完九宮格
                        for (int k = 0; k < 8; k++) {
                            int new_i = i + dx[k];
                            int new_j = j + dy[k];
                            if (k < 4) ans[new_i][new_j] = d1;
                            else ans[new_i][new_j] = Math.max(d2, ans[new_i][new_j]);
                        }
                    }
                }
            }

            System.out.println("Airplane #" + t + ":");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    // 另外輸出 V
                    if (s[i-1].charAt(j-1) == 'V') System.out.print("V");
                    else System.out.print(ans[i][j]);
                }
                System.out.println();
            }
        }
        sc.close();
    }
}
