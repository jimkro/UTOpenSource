import java.util.*;
// import java.lang.Math;

public class ProblemF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == -1 && b == -1)
                break;
            int total1 = 0;
            int total2 = 0;
            if (a > b) {
                int q = a;
                a = b;
                b = q;
            }
            total1 = b - a;
            total2 = (100 - b) + a;

            if (total1 < total2)
                System.out.println(total1);
            else
                System.out.println(total2);
        }

        sc.close();
    }
}
