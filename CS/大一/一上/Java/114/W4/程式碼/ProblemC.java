import java.util.*;

public class ProblemC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long total = 0;
        for (int i = 0; i < t; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            if (total <= a) total = a;
            total += b;
        }
        System.out.println(total);
        sc.close();
    }
}
