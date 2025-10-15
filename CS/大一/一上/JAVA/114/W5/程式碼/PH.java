import java.util.*;

public class PH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0)
                break;
            String s = sc.next();
            int a = (int) (s.charAt(0));
            if (a - 'a' + n < 0)
                a += 26;
            a = (a - 'a' + n) % 26;

            System.out.println((char) (a + 'a'));
        }
        sc.close();
    }
}
