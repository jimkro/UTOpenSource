import java.util.*;

public class PD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            int n = sc.nextInt();
            int c = sc.nextInt();
            int[] tiles = new int[n];
            for (int i = 0; i < n; i++) tiles[i] = sc.nextInt();

            int sum = 0, count = 0;
            for (int i = 0; i < n; i++) {
                // 加上目前海綿會超出最大吸水量則換一塊新的海綿
                if (sum + tiles[i] > c) {
                    sum = tiles[i];
                    count++;
                } else {
                    sum += tiles[i];
                }
            }
            
            // 如果海綿還有吸到東西 -> 再加一塊海綿
            if(sum > 0) count++;
            System.out.println(count);
        }
        sc.close();
    }
}