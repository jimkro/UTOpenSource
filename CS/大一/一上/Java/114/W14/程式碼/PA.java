import java.util.*;

public class PA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) break;

            int[] sche = new int[12];
            for (int i = 0; i < 12; i++) sche[i] = sc.nextInt();
            
            // 最左邊的時間 及 最小交換次數
            int minLeft = 12, minCnt = m+1;
            
            for (int i = 0; i <= 12-n; i++) {
                // 這一回合的交換次數
                int cnt = 0;
                
                // 跑區間內的 1 有多少個
                for (int j = i; j < i+n; j++) {
                    if (sche[j] == 1) cnt++;
                }

                // 更新
                if (cnt < minCnt) {
                    minCnt = cnt;
                    minLeft = i;
                }
            }

            // output 沒有區間成立 -> busy ; 有區間成立 -> 輸出時間
            System.out.println(minLeft == 12 ? "busy" : 8 + minLeft);
        }
        sc.close();
    }
}