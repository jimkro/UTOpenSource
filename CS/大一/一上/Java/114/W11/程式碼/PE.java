import java.util.*;

public class PE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int h = sc.nextInt();
            int d = sc.nextInt();
            int dura = sc.nextInt();
            int n = sc.nextInt();
            int[] times = new int[n];
            for (int i = 0; i < n; i++) times[i] = sc.nextInt();

            // total * d 有可能超出範圍 要開 long
            long total = 0;
            for (int i = 1; i < n; i++) {
                total += Math.min(dura, times[i] - times[i-1]);
            }

            // 加上最後的中毒時間 另外處理 n = 0 的情況
            if (n != 0) total += dura;

            if (total * d < h) System.out.println("Alive");
            else System.out.println("Dead");
        }
        sc.close();
    }
}