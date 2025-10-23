import java.util.*;

public class PD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            int d = sc.nextInt();
            int total = 0, count = 0;
            while (d-->0) {
                int a = sc.nextInt();
                if (a == 1) count = 0;
                else {
                    count += 10;
                    total += count;
                }
            }
            System.out.println(total);
        }
        sc.close();
    }
}