import java.util.*;

public class PF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][] arr = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) arr[i][j] = sc.nextInt();
            }

            // 紀錄有沒有人掉下去
            boolean[][] seen = new boolean[r][c];
            int n = sc.nextInt();
            while (n-->0) {
                int sR = sc.nextInt();
                int sC = sc.nextInt();
                int dir = sc.nextInt();
                String s = sc.next();
                boolean fall = false;
                for (char step : s.toCharArray()) {
                    // 左轉
                    if (step == 'L') dir = (dir - 1 + 4) % 4;
                    // 右轉
                    else if (step == 'R') dir = (dir + 1) % 4;
                    // 直走
                    else {
                        // 紀錄走路之前的位置
                        int beforeR = sR;
                        int beforeC = sC;

                        if (sR > 0 && dir == 0) sR--;
                        if (sC < c-1 && dir == 1) sC++;
                        if (sR < r-1 && dir == 2) sR++;
                        if (sC > 0 && dir == 3) sC--;

                        // 站在會掉落的地方
                        if (arr[sR][sC] == 1) {
                            // 如果之前有人掉下去 -> 回到原來位置 ; 沒有 -> 紀錄掉落位置
                            if (seen[sR][sC]) {
                                sR = beforeR;
                                sC = beforeC;
                            } else {
                                fall = true;
                                seen[sR][sC] = true;
                                break;
                            }
                        }
                    }
                }

                if (fall) System.out.printf("Fall at (%d, %d)\n", sR, sC);
                else System.out.printf("Safe at (%d, %d)\n", sR, sC);
            }
        }
        sc.close();
    }
}