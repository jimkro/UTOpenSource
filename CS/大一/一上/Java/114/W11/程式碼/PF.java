import java.util.*;

public class PF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) break;
            int m = sc.nextInt();
            int[] s = new int[n];
            int[] t = new int[m];
            int total = 0;
            for (int i = 0; i < n; i++) s[i] = sc.nextInt();
            for (int i = 0; i < m; i++) t[i] = sc.nextInt();

            for (int i = 0; i < n; i++) {
                // 本身繁忙程度就是 10 的情況
                if (s[i] == 10) total++;
                else {
                    for (int j = 0; j < m; j++) {
                        // 看學生能接的工作量加上繁忙程度有沒有剛好為 10
                        if (s[i] + t[j] == 10) {
                            total++;
                            // 工作負荷量改為 0 代表被接走了
                            t[j] = 0;
                            break;
                        }
                    }
                }
            }

            System.out.println(total);
        }
        sc.close();
    }
}
// 2 2 10
// 9 9 8 6 5 3