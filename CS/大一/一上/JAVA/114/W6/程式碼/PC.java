import java.util.*;

public class PC  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            double r = sc.nextDouble();
            double g = sc.nextDouble();
            double b = sc.nextDouble();
            double maxC = Math.max(Math.max(r/255, g/255), b/255);
            double minC = Math.min(Math.min(r/255, g/255), b/255);
            double s = 0.0;
            if (maxC != 0) s = (maxC - minC) / maxC;
            if (s * maxC <= 0.87) System.out.println("pending");
            else System.out.println("skip");
        }
        sc.close();
    }
}