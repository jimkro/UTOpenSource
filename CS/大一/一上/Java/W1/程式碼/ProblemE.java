import java.util.*;

public class ProblemE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int ans = (b * b) - (4 * a * c);

            if (ans > 0)
                System.out.println(2);
            else if (ans == 0)
                System.out.println(1);
            else
                System.out.println(0);
        }

        sc.close();
    }
}
