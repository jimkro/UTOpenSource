import java.util.*;

public class PE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 事先計算 0 ~ 92 的值是多少
        long[] dp = new long[93];
        dp[1] = 1;
        for (int i = 2; i <= 92; i++) dp[i] = dp[i-1] + dp[i-2];
        while (sc.hasNext()) {
            int n = sc.nextInt();
            // 直接跟陣列拿值
            System.out.println(dp[n]);
        }
        sc.close();
    }
}