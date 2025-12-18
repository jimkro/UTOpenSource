import java.util.*;

public class PH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            
            // 士兵累計多少個
            int cnt = 1;
            // 記錄雙方戰力值
            long team0 = 0, team1 = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i-1] == arr[i]) cnt++;
                else {
                    if (arr[i-1] == 0) team0 += solve(cnt);
                    else team1 += solve(cnt);
                    cnt = 1;
                }
            }

            // 處理最後一筆
            if (arr[n-1] == 0) team0 += solve(cnt);
            else team1 += solve(cnt);

            if (team0 == team1) System.out.printf("%d : %d Balance\n", team0, team1);
            else if (team0 > team1) System.out.printf("%d : %d Advantages\n", team0, team1);
            else System.out.printf("%d : %d Disadvantages\n", team0, team1);
        }
        sc.close();
    }

    // 計算戰力值
    public static long solve(long cnt) {
        return (1 + (cnt - 1)) * (cnt - 1) / 2;
    }
}