import java.util.*;

public class PI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int x3 = sc.nextInt();
            int y3 = sc.nextInt();
            int x4 = sc.nextInt();
            int y4 = sc.nextInt();

            int a1 = y2-y1;
            int b1 = -(x2-x1);
            int c1 = a1*x1 + b1*y1;
            int a2 = y4-y3;
            int b2 = -(x4-x3);
            int c2 = a2*x3 + b2*y3;

            int d = (a1*b2) - (a2*b1);
            int dx = (c1*b2) - (c2*b1);
            int dy = (a1*c2) - (a2*c1);

            if (d == 0 && dx == 0 && dy == 0) System.out.println("LINE");
            else if (d == 0 && (dx != 0 || dy != 0)) System.out.println("NONE");
            else {
                double x = (double)dx / d;
                double y = (double)dy / d;
                if (x == -0.0) x = 0.0;
                if (y == -0.0) y = 0.0;
                System.out.printf("POINT %.2f %.2f\n", x, y);
            }
        }
        sc.close();
    }
}