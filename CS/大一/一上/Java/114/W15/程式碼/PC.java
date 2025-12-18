import java.util.*;

public class PC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 天數表
        int[] date = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for(int i = 1; i <= 12; i++) date[i] += date[i-1];
        while (sc.hasNext()) {
            // input：用斜線切割月 日
            String[] day1 = sc.next().split("/");
            // 計算開始總天數
            int start = date[Integer.parseInt(day1[0])-1] + Integer.parseInt(day1[1]);
            int n = sc.nextInt();
            while (n-->0) {
                String name = sc.next();
                String[] day2 = sc.next().split("/");
                // 計算生日日期總天數
                int end = date[Integer.parseInt(day2[0])-1] + Integer.parseInt(day2[1]);

                // output
                if (end - start > 0) System.out.printf("Happy %d days before birthday, %s\n", end - start, name);
                else if (end - start < 0) System.out.printf("Happy %d days after birthday, %s\n", -(end - start), name);
                else System.out.printf("Happy Birthday, %s\n", name);
            }
            System.out.println();
        }
        sc.close();
    }
}