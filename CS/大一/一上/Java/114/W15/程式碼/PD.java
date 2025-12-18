import java.util.*;

public class PD {
    static long MOD, base;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            base = sc.nextLong();
            long exp = sc.nextLong();
            MOD = sc.nextLong();
            System.out.println(recursive(exp));
        }
        sc.close();
    }

    // 遞迴
    public static long recursive(long exp) {
        // base case
        if (exp == 0) return 1 % MOD;
        if (exp == 1) return base % MOD;

        long half = recursive(exp / 2) % MOD;
        long ans = half * half % MOD;
        if (exp % 2 == 1) return ans * base % MOD;
        return ans;
    }
}