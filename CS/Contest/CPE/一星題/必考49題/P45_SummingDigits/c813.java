package CPE;
import java.util.*;

public class c813 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            boolean loop = true;
            int sum = 0;

            if (num == 0){
                break;
            }

            if (num / 10 == 0){
                sum = num;
                loop = false;
            }

            while (loop){
                sum += num % 10;
                num /= 10;
                if (num == 0){
                    if (sum / 10 == 0){
                        loop = false;
                    }else{
                        num = sum;
                        sum = 0;
                    }
                }
            }
            System.out.println(sum);
        }
        sc.close();
    }
}