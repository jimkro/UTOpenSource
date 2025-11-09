import java.util.*;

public class PC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            if (solve(s)) System.out.println("nice gift");
            else System.out.println("skip");
        }
        sc.close();
    }

    public static boolean solve(String s) {
        if (s.charAt(s.length()-1) != '0') return false;

        int even = 0, odd = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) odd += s.charAt(i) - '0';
            else even += s.charAt(i) - '0';
        }

        if ((even + odd) % 3 != 0) return false;
        if ((even - odd) % 11 != 0) return false;

        return true;
    }
}