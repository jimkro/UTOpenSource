import java.util.*;

public class PB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(m-n);
        }
        sc.close();
    }
}