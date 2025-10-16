import java.util.*;

public class PF  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-->0) {
            String s = sc.nextLine().trim();
            StringBuilder sum = new StringBuilder();
            boolean positive = true, firstNum = false;

            // 算數字
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) continue;
                if (!firstNum && s.charAt(i) == '0') continue;
                sum.append(s.charAt(i));
                firstNum = true;
            }

            // 找正負號
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    if (i != 0 && s.charAt(i-1) == '-') {
                        positive = false;
                    }
                    break;
                }
            }

            if (!firstNum) System.out.println(0);
            else if (positive) System.out.println(sum.toString());
            else System.out.println("-" + sum.toString());
        }
        sc.close();
    }
}



/*
 *  test case
 *  abc -> 0
 *  9-27 -> 927
 *  -9+2 -> -92
 *  +A-1 -> -1
 */