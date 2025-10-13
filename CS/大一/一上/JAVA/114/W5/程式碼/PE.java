import java.util.*;

public class PE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int total = 0;
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            total += a;
        }
        t = (total + t) % 7;
        if (t == 0)
            System.out.println("Sunday");
        else if (t == 1)
            System.out.println("Monday");
        else if (t == 2)
            System.out.println("Tuesday");
        else if (t == 3)
            System.out.println("Wednesday");
        else if (t == 4)
            System.out.println("Thursday");
        else if (t == 5)
            System.out.println("Friday");
        else
            System.out.println("Saturday");
        sc.close();
    }
}
