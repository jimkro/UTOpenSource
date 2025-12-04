import java.util.*;

public class PE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][] arr = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j  < c; j++) arr[i][j] = sc.nextInt();
            }
            int sR = sc.nextInt();
            int sC = sc.nextInt();
            int dir = sc.nextInt();
            String step = sc.next();

            // 記錄掉沒掉下去
            boolean fall = false;
            for (char c1 : step.toCharArray()) {
                // 往前
                if (c1 == 'F') {
                    // 
                    if (dir == 0 && sR > 0) sR--;
                    else if (dir == 1 && sC < c-1) sC++;
                    else if (dir == 2 && sR < r-1) sR++;
                    else if (dir == 3 && sC > 0) sC--;

                    if (arr[sR][sC] == 1) {
                        fall = true;
                        break;
                    }
                } 
                // 右轉
                else if (c1 == 'R') dir = (dir + 1) % 4;
                // 左轉
                else if (c1 == 'L') dir = (dir - 1 + 4) % 4;
            }

            if (fall) System.out.println("Fall");
            else System.out.println("Safe");
        }
        sc.close();
    }
}