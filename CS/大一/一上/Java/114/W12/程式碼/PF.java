import java.util.*;

public class PF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) break;
            int[] y = new int[n];
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                y[i] = sc.nextInt();
            }

            // 排序
            Arrays.sort(y);

            // 找中位數並計算它的值
            System.out.println(y[(n-1)/2] + " " + solve(y, n));
        }
        sc.close();
    }

    // 計算
    public static int solve(int[] y, int n) {
        int mid = y[(n-1)/2], total = 0;
        for (int i = 0; i < n; i++) {
            total += Math.abs(y[i] - mid);
        }
        return total;
    }
}