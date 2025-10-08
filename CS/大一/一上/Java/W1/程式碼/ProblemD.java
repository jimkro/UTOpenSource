import java.util.*;

public class ProblemD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a1 = 1, a2 = 2, now = 0;
            int n = sc.nextInt();
            for (int j = 0; j < n - 2; j++) {
                now = a1 + a2;
                a1 = a2;
                a2 = now;
                // System.out.println(a1 + " " + a2 + " " + now);
            }
            System.out.println(now);
        }

        sc.close();
    }
}
