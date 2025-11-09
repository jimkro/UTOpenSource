import java.util.*;

public class PJ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            String s = sc.next();
            String[] arr = s.split("=");
            String left = arr[0];
            String right = arr[1];
            if (left.charAt(0) != '-') left = "+" + left;
            if (right.charAt(0) != '-') right = "+" + right;

            int left_x = 0, left_num = 0, right_x = 0, right_num = 0;
            int l = left.length()-1;
            int r = l;
            while (r >= 0) {
                int sign = 1;
                while (!(left.charAt(l) == '+' || left.charAt(l) == '-')) l--;
                if (left.charAt(r) == 'x') {
                    if (left.charAt(l) == '-') sign = -1;
                    String now = left.substring(l+1, r);
                    if (now.length() == 0) left_x += 1 * sign;
                    else left_x += Integer.parseInt(now) * sign;
                } else {
                    if (left.charAt(l) == '-') sign = -1;
                    String now = left.substring(l+1, r+1);
                    if (now.length() == 0) left_num += 1 * sign;
                    else left_num += Integer.parseInt(now) * sign;
                }
                r = l - 1;
                l = r;
            }

            l = right.length()-1;
            r = l;
            while (r >= 0) {
                int sign = 1;
                while (!(right.charAt(l) == '+' || right.charAt(l) == '-')) l--;
                if (right.charAt(r) == 'x') {
                    if (right.charAt(l) == '-') sign = -1;
                    String now = right.substring(l+1, r);
                    if (now.length() == 0) right_x += 1 * sign;
                    else right_x += Integer.parseInt(now) * sign;

                } else {
                    if (right.charAt(l) == '-') sign = -1;
                    String now = right.substring(l+1, r+1);
                    if (now.length() == 0) right_num += 1 * sign;
                    else right_num += Integer.parseInt(now) * sign;
                }
                r = l - 1;
                l = r;
            }

            int x = left_x - right_x;
            int num = right_num - left_num;
            if (x == 0 && num == 0) System.out.println("INF");
            else if (x == 0) System.out.println("NONE");
            else System.out.println((int)Math.floor((double)num/x));
        }
        sc.close();
    }
}