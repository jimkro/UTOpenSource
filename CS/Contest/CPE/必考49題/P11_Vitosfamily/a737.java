package CPE;
import java.util.*;
//記憶體與時間不符規定
public class a737 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();

        //陣列長度
        for (int i = 0; i < times; i++){
            int len = sc.nextInt();
            int[] num = new int[len];
            int ans = 0;
            int middle = 0;

            for (int j = 0; j < len; j++){
                num[j] = sc.nextInt();
            }

            Arrays.sort(num);
            if (len % 2 != 0){
                middle = num[(len-1)/2];
            }else{
                middle = (num[(len/2)] + num[(len/2)-1])/2;
            }
            //System.out.println(middle);
            for (int k = 0; k < len; k++){
                ans += Math.abs(middle - num[k]);
            }

            System.out.println(ans);
        }
        sc.close();
    }
}
