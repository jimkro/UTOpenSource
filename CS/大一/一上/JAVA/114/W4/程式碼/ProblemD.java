import java.util.*;

public class ProblemD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            double x3 = sc.nextDouble();
            double y3 = sc.nextDouble();
            double x4 = sc.nextDouble();
            double y4 = sc.nextDouble();
            double m1 = (y2 - y1) / (x2 - x1), m2 = (y4 - y3) / (x4 - x3);
            double b1 = y1 - m1 * x1, b2 = y3 - m2 * x3;
            double x, y;
            if (x1 == x2 && x3 != x4) {
                x = x1;
                y = (x * m2) + b2;
                System.out.printf("POINT %.2f %.2f\n", x, y);
            } else if (x1 != x2 && x3 == x4) {
                x = x3;
                y = (x * m1) + b1;
                System.out.printf("POINT %.2f %.2f\n", x, y);
            } else if (x1 == x2 && x3 == x4 && x1 == x3) {
                System.out.println("LINE");
            } else if (x1 == x2 && x3 == x4 && x1 != x3) {
                System.out.println("NONE");
            } else if (m1 != m2) {
                x = (b2 - b1) / (m1 - m2);
                y = m1 * x + b1;
                System.out.printf("POINT %.2f %.2f\n", x, y);
            } else if (m1 == m2 && b1 != b2)
                System.out.println("NONE");
            else if (m1 == m2 && b1 == b2)
                System.out.println("LINE");
        }
        sc.close();
    }
}
