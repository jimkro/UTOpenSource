import java.util.*;

public class ProblemF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long total = sc.nextLong();
        while (sc.hasNext()) {
            long s = sc.nextLong();
            total += s;
            System.out.println(total);
        }
        sc.close();
    }
}
