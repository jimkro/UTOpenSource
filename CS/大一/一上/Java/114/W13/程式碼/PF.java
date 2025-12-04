import java.util.*;

public class PF {
    // 移動次數
    static int cnt = 1;

    // 三個位置對照表
    static char[] rods = {'A', 'B', 'C'};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n == 0) break;

            // 初始化 cnt
            cnt = 1;
            Hanoi(n, 0, 2);
            System.out.println();
        }
        sc.close();
    }

    public static void Hanoi(int n, int from, int to) {
        if (n == 1) {
            // 輸出目前移動步驟
            System.out.println(cnt++ + " - " + rods[from] + " to " + rods[to]);
            return;
        }

        // 中繼站
        int tmp = 3 - from - to;

        // 將 n-1 個移到中間
        Hanoi(n-1, from, tmp);
        // 將底層移到右邊
        Hanoi(1, from, to);
        // 將 n-1 個移到右邊
        Hanoi(n-1, tmp, to);
    }
}