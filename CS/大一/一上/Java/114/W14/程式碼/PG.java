import java.util.*;

public class PG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        double m = sc.nextDouble();
        double e = sc.nextDouble();
        
        while (sc.hasNext()) {
            double k = sc.nextDouble();
            n += k;
            if (n >= m - e) {
                System.out.println("dangerous");
                break;
            } else System.out.println("save"); 
        }
        sc.close();
    }
}