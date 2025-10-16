import java.util.*;

public class PG  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // 讀掉換行符號(\n)
        while (T-->0) {
            String s = sc.nextLine();
            int l = 0, r = s.length()-1;
            boolean palindrome = true;
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) {
                    palindrome = false;
                    break;
                }
                l++;
                r--;
            }
            if (palindrome) System.out.println("Yes");
            else System.out.println("No");


        }
        sc.close();
    }
}


// StringBuilder解法
// StringBuilder sb = new StringBuilder(s);
// if (s.equals(sb.reverse().toString())) System.out.println("Yes");
// else System.out.println("No");
// 同下
// System.out.println(s.equals(new StringBuilder(s).reverse().toString()) ? "Yes" : "No");