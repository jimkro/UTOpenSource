import java.util.*;

public class PF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int d = sc.nextInt();
            if (d == -1)
                break;
            int l = sc.nextInt();
            int a = sc.nextInt();
            int s = sc.nextInt();
            int mi = Math.min(Math.min(d, l), Math.min(a, s));
            int ma = Math.max(Math.max(d, l), Math.max(a, s));
            int total = l + a + s + d;
            if (total >= 350 && ma - mi <= 25)
                System.out.println("In");
            else
                System.out.println("Nah");
        }
        sc.close();
    }
}
