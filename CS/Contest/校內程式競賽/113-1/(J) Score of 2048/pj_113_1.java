/*
算分方式
自己+前一項的分數*2
例如16 = 16 + 16*2
            (8的分數)
 */

package UTCS_program_contest;
import java.util.*;

public class pj_113_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            int n = sc.nextInt();
            long ans = 0;

            //輸入一個算一個，可以不用陣列紀錄
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    long in = sc.nextLong();
                    if (in != 0 || in != 2){ //0和2不算分
                        ans += point(in);
                    }
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }

    public static long point(long a){
        if (a == 4) return 4;
        if (a == 0 || a == 2) return 0;
        long point = a + point(a/2)*2;
        return point;
    }
}
