import java.util.*;

public class PC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            long x = sc.nextLong();
            long v = sc.nextLong();
            long a = sc.nextLong();
            long t = sc.nextLong();

            System.out.println((v*t+a*t*t/2) + x);
        }
        sc.close();
    }
}
