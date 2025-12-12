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

            int sR = sc.nextInt();
            int sC = sc.nextInt();
            int dir = sc.nextInt();
            String s = sc.next();

            int cnt = 0;
            for (char toward : s.toCharArray()) {
                if (toward == 'R') dir = (dir + 1) % 4;
                else if (toward == 'L') dir = (dir - 1 + 4) % 4;
                else {
                    // 紀錄有沒有移動
                    boolean go = false;

                    if (dir == 0 && sR > 0) {sR--; go = true;}
                    if (dir == 1 && sC < c-1) {sC++; go = true;}
                    if (dir == 2 && sR < r-1) {sR++; go = true;}
                    if (dir == 3 && sC > 0) {sC--; go = true;}

                    if (go && arr[sR][sC] == 1) cnt++;
                }
            }

            System.out.println(cnt);
        }
        sc.close();
    }
}