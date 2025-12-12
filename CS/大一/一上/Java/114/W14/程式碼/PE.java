import java.util.*;

public class PE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            long sum = 1;
            while (n-->1) {
                sum += 1;
                sum *= 2;
            }
            System.out.println(sum);
        }
        sc.close();
    }
}