/*
解題想法
因為進位制最大會到16
所以可能會有英文字母
先用陣列把每一位元的數存起來再運算(英文換成數字 e.g. A = 10)
 */

package UTCS_program_contest;
import java.util.*;

public class pe_113_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        while(cases-- > 0){
            String in = sc.next();
            int base = sc.nextInt();
            int len = in.length();
            long after = 0; //一開始的輸入轉十進位的值
            long befoer = 0; //次方運算出來的值
            int[] rec = new int[len];
            long base_1 = 1; //用來把輸入轉十進位

            //把輸入轉成數字陣列
            for (int i = 0; i < len; i++){
                char temp = in.charAt(i);
                if (temp > 47 && temp < 58){
                    rec[i] = temp - '0';
                }else if (temp > 64 && temp < 72){
                    rec[i] = temp - 'A' + 10;
                }
            }

            for (int i = len-1; i >= 0; i--){ //從個位數往前跑
                after += rec[i] * base_1;
                base_1 *= base;
                befoer += (long)Math.pow(rec[i], len);
            }

            if (after == befoer) System.out.println("YES");
            else System.out.println("NO");
        }
        sc.close();
    }
}
