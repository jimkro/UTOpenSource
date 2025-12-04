import java.util.*;

public class PC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            long[] colors = new long[n];
            long total = 0;
            for (int i = 0; i < n; i++) {
                colors[i] = sc.nextLong();
                total += colors[i];
            }

            long deno = C(total, k); // 分母

            long nume = 0; // 分子
            for (int i = 0; i < n; i++) {
                nume += C(colors[i], k);
            }

            // 找最大公因數去約分
            long g = gcd(deno, nume);
            deno /= g;
            nume /= g;
            
            if (nume == 0) System.out.println(0);
            else if (deno == nume) System.out.println(1);
            else System.out.println(nume + "/" + deno);
        }
        sc.close();
    }

    // 找最大公因數
    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // 組合
    public static long C(long n, long k) {
        if (n < k) return 0l;
        long total = 1;
        k = Math.min(n-k, k);
        for (int i = 1; i <= k; i++) {
            total *= n-i+1;
            total /= i;
        }
        return total;
    }
}