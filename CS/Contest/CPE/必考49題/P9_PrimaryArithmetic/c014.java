package CPE;
import java.util.*;

public class c014 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int ans = 0;
            int[] x = new int[11];
            int[] y = new int[11];

            if (a == 0 & b == 0){
                break;
            }

            //儲存資料
            int count1 = 0;
            int count2 = 0;
            while (a != 0){
                x[count1] = a % 10;
                a /= 10;
                count1 ++;
            }
            while (b != 0){
                y[count2] = b % 10;
                b /= 10;
                count2 ++;
            }

            //計算
            int cases = Math.max(count1,count2);
            for (int i = 0; i <= cases; i++){
                if (x[i] + y[i] >= 10){
                    ans += 1;
                    x[i+1] += 1;
                }
            }

            //輸出
            if (ans == 0){
                System.out.println("No carry operation.");
            }else if (ans == 1){
                System.out.println("1 carry operation.");
            }else{
                System.out.println(ans + " carry operations.");
            }
        }
        sc.close();
    }
}
