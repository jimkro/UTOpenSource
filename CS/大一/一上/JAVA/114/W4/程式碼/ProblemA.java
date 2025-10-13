import java.util.*;

public class ProblemA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            float a = sc.nextFloat();
            float b = sc.nextFloat();

            System.out.println(a / 100 * b);
        }
        sc.close();
    }
}
