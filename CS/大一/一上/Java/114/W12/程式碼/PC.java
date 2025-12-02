import java.util.*;
public class PC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 卡牌字母 方便對號
        String[] card = {"0", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) break;

            // 卡牌出現的數字
            int[] c = new int[n];
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                if (s.equals("A")) c[i] = 1;
                else if (s.equals("J")) c[i] = 11;
                else if (s.equals("Q")) c[i] = 12;
                else if (s.equals("K")) c[i] = 13;
                else c[i] = Integer.parseInt(s);
            }

            // 排序 方便對號
            Arrays.sort(c);

            // 紀錄有沒有找到順子
            boolean find = false;
            for (int i = 0; i <= n-5; i++) {
                // 存當下的順子
                StringBuilder sb = new StringBuilder();
                sb.append(card[c[i]]);

                // 紀錄當下的牌能不能創造順子
                boolean ok = true;
                for (int j = i+1; j < i+5; j++) {
                    if (c[j] == c[j-1]+1) sb.append(" " + card[c[j]]);
                    else {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    System.out.println(sb.toString());
                    find = true;
                }
            }

            // 最後確認有沒有 10 J Q K A
            if (c[0] == 1 && c[n-4] == 10 && c[n-3] == 11 && c[n-2] == 12 && c[n-1] == 13) {
                System.out.println("10 J Q K A");
                find = true;
            }

            if (!find) System.out.println("NONE");
            
        }
        sc.close();
    }
}


















/*
蘇亮亮睡著了... 咕嚕咕嚕咕嚕...
*/