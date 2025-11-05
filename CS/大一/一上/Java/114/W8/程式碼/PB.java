import java.util.*;

public class PB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            long a = sc.nextLong();
            System.out.println(a + " is the input number");
        }

        while (sc.hasNext()) {
            long b = sc.nextLong();
            if (b < 0) break;
            System.out.println(b + " is the input number");
        }

        while (sc.hasNext()) {
            long c = sc.nextLong();
            System.out.println(c + " is the input number");
        }

        sc.close();
    }
}


// 另一種解法 : 讀完第一筆輸入後 後續只要跳過唯一負數情況即可正常輸出
// int T = sc.nextInt();
// while (sc.hasNext()) {
//     long a = sc.nextLong();
//     if (a < 0) continue;
//     System.out.println(a + " is the input number");
// }