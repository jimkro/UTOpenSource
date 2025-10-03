/*
有用到超綱的東東，建議可以先看Allen張寫的
使用到的超綱東東：ArrayList
一種不用宣告長度的容器
 */

package UTCS_program_contest;
import java.util.*;

public class ph_113_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //先建立整個三角形

        ArrayList<ArrayList<Long>> rec = new ArrayList<>(); //二維arraylist，用來記錄算過的值
        ArrayList<Long> now = new ArrayList<>(); //儲存新產生的值

        //先把零次方和一次方的值存起來
        now.add((long)1);
        rec.add(now);
        now = new ArrayList<>(); //清空now
        now.add((long)1);
        now.add((long)1);
        rec.add(now);

        //long sum = 0; //係數總和
        

        for (int i = 2; i <= 50; i++){ //零次方和一次方已經存好了，從二次方開始算
            now = new ArrayList<>();
            now.add((long)1); //先放入第一個係數
            for (int j = 1; j < i; j++){ //把前一個次方的係數拿來運算(前項+後項)
                now.add((rec.get(i-1)).get(j-1) + (rec.get(i-1)).get(j));
            }
            now.add((long)1);//放入最後一個係數
            rec.add(now);
        }
        
        while (sc.hasNext()){
            int num = sc.nextInt();
            long ans = 0;
            
            for (int i = 0; i < num; i++){ //輸入哪個印哪個
                System.out.print((rec.get(num)).get(i) + " ");
                ans += (rec.get(num)).get(i);
            }
            System.out.println((rec.get(num)).get(num)); //最後一項不用空格但要換行
            ans += (rec.get(num)).get(num);
            System.out.println(ans); //係數和是2的num次方
            
        }
        sc.close();
    }
}
