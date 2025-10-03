// By Allen Chang
/* Idea
三個為一組ASCII code，所以我們只要把字串分段以ASCII解碼為文字即可。
實際做法是先以int取ASCII code，輸出時再強制轉型成char

Solution 1:
第一個字元 * 100 + 第二個字元 * 10 + 第三個字元 * 1 = 一組ASCII code

Solution 2:
如果你會內建函式的話，先用 substring() 取出ASCII code，再用
Interger.parseInt() 把String轉成int。 */

// Solution
import java.util.*;
public class pB {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String s = input.next();
            int ans = 0;
            for(int i=0;i<s.length();i=i+3){
                ans = 0;

                // Solution 1
                ans += (s.charAt(i) - '0') * 100;
                ans += (s.charAt(i+1) - '0') * 10;
                ans += s.charAt(i+2) - '0';

                /* Solution 2
                ans += Integer.parseInt(s.substring(i,i+3));
                */

                System.out.print((char)ans);
            }
            System.out.println();
        }
        input.close();
    }
}
