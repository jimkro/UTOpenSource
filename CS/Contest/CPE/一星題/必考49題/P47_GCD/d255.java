package CPE;
import java.util.*;

public class d255 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int in = sc.nextInt();
            int ans = 0;

            if (in == 0){
                break;
            }

            for (int j = 1; j < in; j++){//j是比較小的數
                for (int k = j + 1; k <= in; k++){
                    for (int n = j; n > 0; n--){
                        if (j % n == 0 & k % n == 0){
                            ans += n;
                            break;
                        }
                    }
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
