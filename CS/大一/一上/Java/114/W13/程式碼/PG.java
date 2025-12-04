import java.util.*;
public class PG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int n = sc.nextInt();
            String s1 = sc.next();
            String s2 = sc.next();

            // 紀錄字母出沒出現過
            boolean[] alpha1 = new boolean[26];
            boolean[] alpha2 = new boolean[26];
            for (char c : s1.toCharArray()) alpha1[c-'A'] = true;
            for (char c : s2.toCharArray()) alpha2[c-'A'] = true;

            // 總得分
            int res = n;
            for (int i = 0; i < n; i++) {
                // 只要有一方出現但另一方沒出現過則扣 2
                if (alpha1[i] ^ alpha2[i]) res -= 2;
            }
            
            System.out.println(res);
        }
        sc.close();
    }
}







































// 哈囉佳衛我是蘇電神亮亮沂！！！！