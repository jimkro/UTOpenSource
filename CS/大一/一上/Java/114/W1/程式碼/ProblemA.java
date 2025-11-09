import java.util.*;

public class ProblemA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        for (int i = 0; i < a; i++) {
            int b1 = sc.nextInt();
            int b2 = sc.nextInt();
            if (b1 > b2) {
                int q = b1;
                b1 = b2;
                b2 = q;
            }

            for (int j = b1; j >= 1; j--) {
                if (b1 % j != 0) continue;
                if (b2 % j == 0) {
                    System.out.println(j);
                    break;
                }
            }
        }

        sc.close();
    }
}
