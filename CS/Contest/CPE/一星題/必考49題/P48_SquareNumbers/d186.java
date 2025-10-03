package CPE;
import java.util.*;

public class d186 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            double a = sc.nextInt();
            double b = sc.nextInt();

            if (a == 0 & b == 0){
                break;
            }

            int count = 0;
            for (double j = a; j <= b; j++){
                if ((Math.sqrt(j) * 10) % 10 == 0){
                    count += 1;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}