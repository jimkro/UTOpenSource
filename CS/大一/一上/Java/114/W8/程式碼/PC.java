import java.util.*;

public class PC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            double x = sc.nextDouble();
            double v = sc.nextDouble();
            double a = sc.nextDouble();
            double t = sc.nextDouble();

            System.out.println((int)(v*t+0.5*a*t*t + x));
        }
        sc.close();
    }
}
