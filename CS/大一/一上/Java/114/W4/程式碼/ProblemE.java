import java.util.*;

public class ProblemE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int up = m - 1, down = 0, right = 0, left = m - 1;
            for (int j = 0; j < m * n; j++) {
                int a = sc.nextInt();
                if (a == 1) {
                    up = Math.min(up, j / n);
                    down = Math.max(down, j / n);
                    left = Math.min(left, j % n);
                    right = Math.max(right, j % n);
                }
            }
            System.out.println(((down - up) + 1) * ((right - left) + 1));
        }
        sc.close();
    }
}
