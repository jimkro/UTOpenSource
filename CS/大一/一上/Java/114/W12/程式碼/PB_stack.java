import java.util.*;
public class PB_stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-->0) {
            // input
            String[] s = sc.nextLine().split(" ");
            
            // 用 stack 來存 x
            Stack<Long> x = new Stack<>();
            for (int i = 0; i < s.length; i++) {
                if (s[i].equals("f")) continue;
                // 空的代表還沒數字出現 -> 加入第一個 x
                if (x.isEmpty()) x.push(Long.parseLong(s[i]));
                // 有數字在裡面 -> 把它拿出來並做運算再塞回去繼續當下一個 x
                else {
                    long x1 = x.pop();
                    x.push(f(x1, Long.parseLong(s[i])));
                }
            }
            System.out.println(x.pop());
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