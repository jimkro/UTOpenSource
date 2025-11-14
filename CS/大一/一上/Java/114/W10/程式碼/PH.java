import java.util.*;

public class PH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            String s = sc.next();
            
            int l = 0, r = s.length()-1;
            while (l <= r) {
                int m = l + (r-l) / 2;
                System.out.print(m + " ");
                if (s.charAt(m) == 'X') r = m - 1;
                else l = m + 1;
            }

            System.out.println();
            System.out.println(l);
        }
        sc.close();
    }
}