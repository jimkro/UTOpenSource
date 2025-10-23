import java.util.*;

public class PB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int n = sc.nextInt();
            
            int total = 0;
            while (n-->0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                if (Math.abs(x - a) + Math.abs(y - b) <= c) total++;
            }

            if (total < 3) System.out.println(0);
            else System.out.println(total);
        }
        sc.close();
    }
}
