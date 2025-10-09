import java.util.*;

public class PG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int d = sc.nextInt();
            int maxProfit = 0, minI = 10000;
            for (int j = 0; j < d; j++) {
                int p = sc.nextInt();
                if (p < minI)
                    minI = p;
                else
                    maxProfit = Math.max(maxProfit, p - minI);
            }
            System.out.println(maxProfit);
        }
        sc.close();
    }
}
