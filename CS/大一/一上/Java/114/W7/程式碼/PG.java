import java.util.*;

public class PG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int total = 0;
        while (T-->0) {
            String s = sc.next();
            if (s.charAt((s.length()-1)/2) == 'X') total++;

        }
        System.out.println(total);
        sc.close();
    }
}