import java.util.*;

public class PB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int total = 0;
        for (int i = 0; i < t; i++) {
            int p = sc.nextInt();
            int v = sc.nextInt();
            if (total <= p) total = p;
            total += v;
        }
        System.out.println(total);
        sc.close();
    }
}
