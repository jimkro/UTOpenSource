import java.util.*;

public class PE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] alpha = {'C', 'D', 'E', 'F', 'G', 'A', 'B'};
        while (sc.hasNext()) {
            String s = sc.next();
            int idx = 0;
            for (int i = 0; i < 7; i++) {
                if (s.charAt(0) == alpha[i]) idx = i;
            }

            int n = sc.nextInt();
            while (n-->0) {
                String s1 = sc.next();
                int idx1 = 0;
                for (int i = 0; i < 7; i++) {
                    if (s1.charAt(0) == alpha[i]) idx1 = i;
                }

                boolean plan = true;
                if (s1.charAt(1) > s.charAt(1)) plan = false;
                else if (s1.charAt(1) == s.charAt(1)) {
                    if (idx < idx1) plan = false;
                }

                if (plan) System.out.println("Plan Singing");
                else System.out.println("Plan Toilet");
            }

        }
        sc.close();
    }
}