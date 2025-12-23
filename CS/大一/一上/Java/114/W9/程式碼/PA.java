import java.util.*;

public class PA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            
            if (a == 1) System.out.print("handsome");
            else if (a == 2) System.out.print("rich");
            else System.out.print("smart");

            if (b == 1) System.out.print(" Allcky");
            else if (b == 2) System.out.print(" Jimmy");
            else System.out.print(" Chen");

            if (c == 1) System.out.println(" dances");
            else if (c == 2) System.out.println(" eats");
            else System.out.println(" writes");
        }
        sc.close();
    }
}