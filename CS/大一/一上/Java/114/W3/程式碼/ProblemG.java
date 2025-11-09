import java.util.*;

public class ProblemG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long ans = (long)(((a + b) + (a - b) + (a * b) + (a / b)) % (a % b));

            System.out.println(ans);
        }
        sc.close();
    }
}
