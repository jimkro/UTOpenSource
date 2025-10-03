/*
解題想法
假設 2 2 2 2 往左2次，相當於4 0 4 0 -> 4 4 0 0 -> 8 0 0 0
可以先排好再計算再排好，最後輸出
1. 排好 (數字都往一邊放，另一邊補零)
我用一個函數zero做排好，傳入陣列及布林值(true代表向左，false代表向右)
把非0數字照方向記錄起來(陣列的預設值是0所以可以直接回傳)
2. 計算(以向左為例)
如果陣列a中 a[i] 和 a[i+1] 的值相同
把 a[i] * 2 ，a[i+1] = 0

重複以上動作
*/

package UTCS_program_contest;
import java.util.*;

public class pa_113_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            int len = sc.nextInt();
            String order = sc.next();
            int[] rec = new int[len];
            boolean flag = true;
            for (int i = 0; i < len; i++){
                rec[i] = sc.nextInt();
            }

            for (int i = 0; i < order.length(); i++){
                //先排好
                if (order.charAt(i) == 'L') flag = true;
                else flag = false;
                rec = zero(rec, flag);

                //再計算
                if (flag){ //往左
                    for (int j = 0; j < len-1; j++){
                        if (rec[j] == rec[j+1]){
                            rec[j] *= 2;
                            rec[j+1] = 0;
                        }
                    }
                }else{
                    for (int j = len-1; j > 0; j--){
                        if (rec[j] == rec[j-1]){
                            rec[j] *= 2;
                            rec[j-1] = 0;
                        }
                    }
                }
                //再排好
                rec = zero(rec, flag);
            }

            for (int c = 0; c <  len; c++){
                System.out.print(rec[c] + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    public static int[] zero(int[] a, boolean L){
        int[] temp = new int[a.length];
        
        if (L){
            int count = 0;
            for (int i = 0; i < a.length; i++){ //往左，數字從左開始記
                if (a[i] != 0){
                    temp[count] = a[i];
                    count++;
                }
            }
        }else{
            int count = a.length-1;
            for (int i = a.length-1; i >= 0; i--){ //往右，數字從右開始記
                if (a[i] != 0){
                    temp[count] = a[i];
                    count--;
                }
            }
        }
        return temp;
    }
}
