import java.util.*;

public class PG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 符號表
        char[] note = {'C', 'D', 'E', 'F', 'G', 'A', 'B'};
        // 移動步數表
        int[] step = {0, 2, 4, 5, 7, 9, 11};
        
        while (sc.hasNext()) {
            String s1 = sc.next();

            // 紀錄 s1 在哪一個音符
            int idx1 = 0;
            for (int i = 0; i < 7; i++) {
                if (s1.charAt(0) == note[i]) idx1 = i;
            }

            int T = sc.nextInt();
            while (T-->0) {
                String s2 = sc.next();
                
                // 紀錄 s2 在哪一個音符
                int idx2 = 0;
                for (int i = 0; i < 7; i++) {
                    if (s2.charAt(0) == note[i]) idx2 = i;
                }

                // 分開計算 level 相同與不相同的情況
                if (s1.charAt(1) == s2.charAt(1)) {
                    System.out.println(step[idx1] - step[idx2]);
                } else {
                    int total = 0;
                    total += (s1.charAt(1) - s2.charAt(1)) * 12 + (step[idx1] - step[idx2]);
                    System.out.println(total);
                }
            }
        }
        sc.close();
    }
}
