/*
有用到超綱的東東，建議可以先看Allen張寫的
使用到的超綱函數：Integer.parseInt
用途是把字串轉數字
 */

package UTCS_program_contest;
import java.util.*;

public class pb_113_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            String s = sc.next();

            for (int i = 0; i < s.length(); i += 3){ //每次取三個元素，i代表開頭的位置，i = 0 3 6.....
                int temp = Integer.parseInt(s.substring(i, i+3)); //三個字元為一組去轉換，substring取左不取右
                System.out.print((char)temp);
            }
            System.out.println();
        }
        sc.close();
    }
}
