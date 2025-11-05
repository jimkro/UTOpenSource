import java.util.*;

public class ProblemG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int total = 0;
            while (n > 0) {
                total += n % 10;
                n /= 10;
            }

            System.out.println(total);
        }

        sc.close();
    }
}
