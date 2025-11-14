import java.util.*;

public class PC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();

            int[] time = new int[n];
            for (int i = 0; i < n; i++) time[i] = sc.nextInt();
            int dura = sc.nextInt();
            
            int total = 0;
            for (int i = 0; i < n-1; i++) {
                // 取時間差跟持續時間的最小值
                total += Math.min(dura, time[i+1] - time[i]);
            }

            // 加上最後一個的中毒持續時間
            total += dura;

            // 處理 n = 0 的情況
            if (n == 0) System.out.println(0);
            else System.out.println(total);
        }
        sc.close();
    }
}