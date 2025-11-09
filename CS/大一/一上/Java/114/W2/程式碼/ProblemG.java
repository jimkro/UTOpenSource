import java.util.*;

public class ProblemG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int sum = b * b - 4 * a * c;
            if (sum > 0) System.out.println(2);
            else if (sum == 0) System.out.println(1);
            else if (sum < 0) System.out.println(0);
        }
        sc.close();
    }
}
