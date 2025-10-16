import java.util.*;

public class PH  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int total = 0;
        while (T-->0) {
            String s = sc.next();

            int count = 0;
            for (char c : s.toCharArray()) {
                if (c == 'O') count++;
            }
            
            if (count < (float)s.length() / 2) total++;
        }
        System.out.println(total);
        sc.close();
    }
}



// 許電神的一行解
// total += ( s.charAt( (s.length() / 2) - 1 + ( s.length() % 2 ) ) == 'X' ? 1 : 0);