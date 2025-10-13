import java.util.*;

public class ProblemE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double s = sc.nextDouble();
            double n = sc.nextDouble();
            double k = sc.nextDouble();
            double score = s * (n - 2 * k) / n;
            if (score <= 0)
                System.out.println(0.0);
            else
                System.out.println(score);
        }
        sc.close();
    }
}
