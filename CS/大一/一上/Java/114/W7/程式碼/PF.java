import java.util.*;

public class PF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-->0) {
            String s = sc.nextLine();
            boolean p = true;
            int l = 0, r = s.length()-1;
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) {
                    p = false;
                    break;
                }
                l++;
                r--;
            }

            if (p) System.out.println("Yes");
            else System.out.println("No");
        }
        sc.close();
    }
}