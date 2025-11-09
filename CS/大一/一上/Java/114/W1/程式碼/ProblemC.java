import java.util.*;

public class ProblemC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long total = sc.nextLong();
        while (sc.hasNext()) {
            long now = sc.nextLong();
            total += now;
            System.out.println(total);
        }

        sc.close();
    }
}
