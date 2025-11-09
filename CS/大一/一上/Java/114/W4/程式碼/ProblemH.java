import java.util.*;

public class ProblemH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int d = sc.nextInt();
            int maxProfit = 0, q = 100000;
            for (int j = 0; j < d; j++) {
                int a = sc.nextInt();
                if (a < q) {
                    q = a;
                    continue;
                }
                int profit = a - q;
                maxProfit = Math.max(maxProfit, profit);
            }
            System.out.println(maxProfit);
        }
        sc.close();
    }
}
