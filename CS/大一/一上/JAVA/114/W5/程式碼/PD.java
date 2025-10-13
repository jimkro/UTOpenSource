import java.util.*;

public class PD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int minI = m, maxI = 0, minJ = n, maxJ = 0;
            for (int j = 0; j < m * n; j++) {
                int a = sc.nextInt();
                if (a == 1) {
                    minI = Math.min(minI, j / n);
                    maxI = Math.max(maxI, j / n);
                    minJ = Math.min(minJ, j % n);
                    maxJ = Math.max(maxJ, j % n);
                }
            }
            int area = (maxI - minI + 1) * (maxJ - minJ + 1);
            System.out.println(area);
        }
        sc.close();
    }
}
