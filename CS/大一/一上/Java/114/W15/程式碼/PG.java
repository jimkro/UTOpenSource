import java.util.*;

public class PG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) break;

            int[] arr = new int[12];
            // 計算總共有多少空閒時間可以交換時間
            int cntZero = 0;
            for (int i = 0; i < 12; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] == 0) cntZero++;
            }
            
            int idx = 12;
            for (int i = 0; i <= 12-n; i++) {
                int cnt = 0;
                for (int j = i; j < i+n; j++) {
                    if (arr[j] == 1) cnt++;
                }

                // 符合可調整次數並且可移動到其他天
                if (cnt <= m && cntZero - (n - cnt) >= cnt) {
                    idx = i;
                    break;
                }
            }

            System.out.println(idx == 12 ? "busy" : 8 + idx);

        }
        sc.close();
    }
}