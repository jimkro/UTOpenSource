import java.util.*;

public class ProblemF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int s1 = sc.nextInt();
            int s2 = sc.nextInt();
            int e1 = sc.nextInt();
            int e2 = sc.nextInt();
            int first = s1 * 60 + s2;
            int second = e1 * 60 + e2;
            System.out.println(second - first);
        }
        sc.close();
    }
}
