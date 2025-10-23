import java.util.*;

public class PA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for (int i = 0; i < s.length(); i+=2) {
            String first = s.charAt(i) + "";
            String second = s.charAt(i+1) + "";
            String a = first + second;

            int ans = 0, two = 1;
            for (int j = 1; j >= 0; j--) {
                if (a.charAt(j) == '1') ans += two;
                two *= 2;
            }
            System.out.print((char)(ans + 'A'));
        }
        sc.close();
    }
}

// int ans = 0;
// for (int j = 0; j < 2; j++) {
//     ans *= 2;
//     ans += a.charAt(j) - '0';
// }