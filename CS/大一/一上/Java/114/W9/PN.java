import java.util.*;

public class PN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            float k = sc.nextFloat();
            float w = sc.nextFloat();
            System.out.println(k/100*w);
        }
        sc.close();
    }
}