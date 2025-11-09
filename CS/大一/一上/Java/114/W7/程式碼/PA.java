import java.util.*;

public class PA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for (int i = 0; i < s.length(); i+=2) {
            String first = s.charAt(i) + "";
            String second = s.charAt(i+1) + "";
            String a = first + second;

            int ans = toDec(a);
            System.out.print((char)(ans + 'A'));
        }
        sc.close();
    }

    public static int toDec(String s) {
        int sum = 0, two = 1;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '1') sum += two;
            two *= 2;
        }
        return sum;
    }
}

// int ans = 0;
// for (int j = 0; j < 2; j++) {
//     ans *= 2;
//     ans += a.charAt(j) - '0';
// }