import java.util.*;
import java.lang.Math;

public class ProblemG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            long total = 0;
            long now = 0;
            int a = Integer.parseInt(s);
            for (int j = s.length(); j >= 1; j--) {
                if (a % 10 == a) {
                    total = a;
                    break;
                }

                int result = (int) Math.pow(10, j);
                int result1 = (int) Math.pow(10, j - 1);
                now = a % result1;
                total += (a % result - now) / result1;
            }

            System.out.println(total);
        }

        sc.close();
    }
}
