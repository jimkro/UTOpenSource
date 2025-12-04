import java.util.*;

public class PA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            String s1 = sc.next();
            String s2 = sc.next();
            String s3 = sc.next();

            // 二進位轉十進位
            double r = (double)Integer.parseInt(s1, 2);
            double g = (double)Integer.parseInt(s2, 2);
            double b = (double)Integer.parseInt(s3, 2);

            double maxC = Math.max(Math.max(r/255, g/255), b/255);
            double minC = Math.min(Math.min(r/255, g/255), b/255); 
            double s = 0.0;
            if (maxC != 0) s = (maxC - minC) / maxC;

            if (maxC * s <= 0.87) System.out.println("pending");
            else System.out.println("skip");
        }
        sc.close();
    }
}