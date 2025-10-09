import java.util.*;

public class PC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            double r = sc.nextDouble();
            double g = sc.nextDouble();
            double b = sc.nextDouble();
            double maxC = Math.max(Math.max(r / 255, g / 255), b / 255);
            double minC = Math.min(Math.min(r / 255, g / 255), b / 255);
            double s;
            if (maxC == 0)
                s = 0.0;
            else
                s = (maxC - minC) / maxC;
            if (s * maxC <= 0.87)
                System.out.println("pending");
            else
                System.out.println("skip");
        }
        sc.close();
    }
}
