import java.util.*;

public class PD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) break;
            int a = 0, b = 0;
            for (int i = 2; i <= n/2; i++) {
                int j = n - i;
                if (isPrime(i) && isPrime(j)) {
                    a = i;
                    b = j;
                    break;
                }
            }

            System.out.println(n + " = " + a + " + " + b);
        }
        sc.close();
    }

    public static boolean isPrime(int a) {
        for (int i = 2; i < a; i++) {
            if (a % i == 0) return false;
        }
        return true;
    }
}