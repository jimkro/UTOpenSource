import java.util.*;

public class ProblemB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            float s = sc.nextFloat();
            float n = sc.nextFloat();
            float k = sc.nextFloat();
            float score = s * (n - 2 * k) / n;
            if (score > 0)
                System.out.println(score);
            else
                System.out.println(0.0);
        }

        sc.close();
    }
}
