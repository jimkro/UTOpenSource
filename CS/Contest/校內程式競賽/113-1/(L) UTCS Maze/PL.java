import java.util.Scanner;

public class PL {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int cases = sc.nextInt(); 
        while (cases-- > 0) {
            int N = sc.nextInt(); // row
            int M = sc.nextInt(); // col
            int K = sc.nextInt(); // 初始能力值

            //建立地圖
            int[][] maze = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    maze[i][j] = sc.nextInt();
                }
            }

            // dp[i][j] 代表到達 (i, j) 位置時的最大能力值
            long[][] dp = new long[N][M];
            
            // 初始條件(剛進入起點時)
            if (maze[0][0] != -1 && K >= maze[0][0]) {
                dp[0][0] = K + maze[0][0];
            } else { //若根本進不去就報錯並跳下一輪
                System.out.println(-1);
                continue;
            }
            
            // dp過程
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    // 跳過牆壁
                    if (maze[i][j] == -1) continue;
                    
                    // 可以從上面或左邊過來
                    // 上面
                    if (i > 0 && dp[i-1][j] != -1 && dp[i-1][j] >= maze[i][j]) { 
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + maze[i][j]);
                    }
                    // 左邊
                    if (j > 0 && dp[i][j-1] != -1 && dp[i][j-1] >= maze[i][j]) { 
                        dp[i][j] = Math.max(dp[i][j], dp[i][j-1] + maze[i][j]); 
                    }
                }
            }

            // 輸出結果
            if (dp[N-1][M-1] != 0) {
                System.out.println(dp[N-1][M-1]);
            }else{
                System.out.println(-1);
            }

        }
        
        sc.close();
    }
}
/*
 * key:
 * dp要用long
 * 因為 N*M < 50,000,000 ，故 N + M (要經過的boss數量) 最多可在 1 * 49,999,999 時出現 共 50,000,000個boss
 * 而每個boss的力量值<10000，以及K<10000
 * 故dp中最大可能的值將會是 K_max + boss_ability_max * boss_max = 9,999 + 9,999 * 50,000,000 = 499,950,009,999 > int
 * 
 * 
 */