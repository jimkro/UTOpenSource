package CPE;
import java.util.*;

public class d189 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int quantity = sc.nextInt();
            int ans = 0;

            if (quantity < 2){
                ans = quantity;
            }else if (quantity == 2){
                ans = 3;
            }else if (quantity % 2 == 0){
                int have = quantity + 1;
                while (have != 1){                    
                    ans = ans + have - (have % 3);
                    have = (have % 3) + (have / 3);
                }
            }else{
                int have = quantity + 1;
                while (have != 2){
                    ans += have - (have % 3);
                    have = (have % 3) + (have / 3);
                }
                ans += 1;
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
