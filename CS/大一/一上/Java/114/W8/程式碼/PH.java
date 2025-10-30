import java.util.*;

public class PH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String a = sc.next();
            String b = sc.next();
            int first = Integer.parseInt(a, 2);
            int second = Integer.parseInt(b, 2);
            System.out.println(first + ":" + second);
        }
        sc.close();
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}