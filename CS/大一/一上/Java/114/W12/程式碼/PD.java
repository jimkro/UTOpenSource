import java.util.*;

public class PD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int total = 0;
        while (T-->0) {
            String s = sc.next();

            // 紀錄 B F I A 出現的次數
            int[] count = new int[4];
            
            for (char c : s.toCharArray()) {
                if (c == 'B') count[0]++;
                if (c == 'F') count[1]++;
                if (c == 'I') count[2]++;
                if (c == 'A') count[3]++;
            }

            if (count[3] > 0) total++;
            else if (count[0] < 2 || count[1] < 3 || count[2] < 3) total++;
        }

        System.out.println(total);
        sc.close();
    }
}