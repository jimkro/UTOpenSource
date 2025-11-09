import java.util.*;

public class PE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-->0) {
            String s = sc.nextLine().trim();
            String ans = "";
            boolean hasNum = false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    if (s.charAt(i) == '0' && !hasNum) continue;
                    ans += s.charAt(i);
                    hasNum = true;
                }
            }

            boolean p = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    if (i != 0 && s.charAt(i-1) == '-') p = false;
                    break;
                }
            }

            if (ans.length() == 0) System.out.println(0);
            else if (p) System.out.println(ans);
            else System.out.println("-" + ans);
        }
        sc.close();
    }
}