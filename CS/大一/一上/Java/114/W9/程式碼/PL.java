import java.util.*;

public class PL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) break;
            int m = sc.nextInt();
            Integer[] s = new Integer[n];
            Integer[] t = new Integer[m];
            for (int i = 0; i < n; i++) s[i] = 10 - sc.nextInt();
            for (int i = 0; i < m; i++) t[i] = sc.nextInt();

            // 升序
            Arrays.sort(s);
            // 降序
            Arrays.sort(t, (m1, m2) -> {
                return m2 - m1;
            });

            // 較忙碌的人接小任務 較空閒的人接大任務
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (t[i] <= s[j]) {
                        count++;
                        s[j] -= t[i];
                        Arrays.sort(s);
                        break;
                    }
                }
            }

            System.out.println(count);
        }
        sc.close();
    }
}