package CPE;
import java.util.*;

public class e555 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            int one = sc.nextInt();
            long day = sc.nextLong();
            long count = one;
            long temp = 0;

            for (long i = one; i < day; i++){
                temp += i;
                if (temp >= day){
                    break;
                }
                count ++;
            }

            System.out.println(count);
        }
        sc.close();
    }
}
