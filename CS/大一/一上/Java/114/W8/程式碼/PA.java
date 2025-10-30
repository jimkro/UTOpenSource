import java.util.*;

public class PA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            int n = sc.nextInt();
            String s = sc.next();
            while (n-->0) {
                String s1 = sc.next();
                String ans = "";
                for (int i = 0; i < s.length(); i++) {
                    int first = s.charAt(i) - '0';
                    int second = s1.charAt(i) - '0';
                    ans += (first^second) + "";
                }
                System.out.println(ans);
            }
        }
        sc.close();
    }
}