import java.util.*;

public class PB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            String s = sc.next();
            for (char c : s.toCharArray()) {
                if (c == 'A') System.out.print( "U");
                if (c == 'T') System.out.print( "A");
                if (c == 'C') System.out.print( "G");
                if (c == 'G') System.out.print( "C");
            }
            System.out.println();
        }
        sc.close();
    }
}