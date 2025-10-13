import java.util.*;

public class ProblemH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            float k = sc.nextFloat();
            float w = sc.nextFloat();
            float ans = k / 100 * w;

            System.out.println(ans);
        }
        sc.close();
    }
}
