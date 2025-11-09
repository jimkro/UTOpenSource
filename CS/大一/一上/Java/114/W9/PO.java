import java.util.*;

public class PO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int idx1 = 0, idx2 = 0;
            for (int i = 0; i < n*m; i++) {
                String name = sc.next();
                if (name.equals("Wally")) {
                    idx1 = i / m + 1;
                    idx2 = i % m + 1;
                }
            }
            System.out.println(idx1 + " " + idx2);
        }
        sc.close();
    }
}