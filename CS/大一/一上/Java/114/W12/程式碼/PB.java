import java.util.*;
public class PB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-->0) {
            String[] s = sc.nextLine().split(" ");
            long x = -1;
            
            // 紀錄是不是第一個出現的數字
            boolean first = true;
            
            for (int i = 0; i < s.length; i ++) {
                if (s[i].equals("f")) continue;
                // 是第一個數字 -> 紀錄當前 x ; 不是第一個數字 -> 計算
                if (first) {
                    x = Long.parseLong(s[i]);
                    first = false;
                } else x = f(x, Long.parseLong(s[i]));
            }
            System.out.println(x);
        }
        sc.close();
    }

    public static long f(long x, long y){
        return x * x * x + 2 * x * x - 3 * x - 1 + y * y * y - y * y + 4 * y;
    }
}


















/*
蘇亮亮睡著了... 咕嚕咕嚕咕嚕...
*/