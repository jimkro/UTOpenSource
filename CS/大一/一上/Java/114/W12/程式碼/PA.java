import java.util.*;

public class PA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String[][] name = new String[n][m];
            int idx1 = -1, idx2 = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    name[i][j] = sc.next();
                    if ("Wally".equals(name[i][j])) {
                        idx1 = i+1;
                        idx2 = j+1;
                    }
                }
            }

            if (idx1 == -1 && idx2 == -1) System.out.println("Wally Not Found");
            else System.out.println(idx1 + " " + idx2);

        }
        sc.close();
    }
}