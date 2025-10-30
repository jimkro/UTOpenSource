package CPE;
import java.util.*;

public class c022 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 0;i < cases; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int sum = 0;
            int big = Math.max(a, b);
            int small = Math.min(a,b);

            for (int j = small; j <= big; j++){
                if (j % 2 != 0){
                    sum += j;
                }
            }
            System.out.println("Case " + (i+1) + ": " + sum);
        }
        sc.close();
    }
}
