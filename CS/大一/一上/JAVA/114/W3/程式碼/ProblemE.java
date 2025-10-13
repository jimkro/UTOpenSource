import java.util.*;

public class ProblemE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int mp = sc.nextInt();
            int a = 0, b = 0, c = 0, now = 0;
            c = mp / 3;
            now = mp % 3;
            b = now / 2;
            now %= 2;
            a = now;

            System.out.println(a + " " + b + " " + c);
            System.out.println(a * 1 + b * 3 + c * 6);
        }
        sc.close();
    }
}
