import java.util.*;

public class PH {
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] course = new int[n];
            int total = 0;
            for (int i = 0; i < n; i++) {
                course[i] = sc.nextInt();
                total += course[i];
            }
            
            cnt = 0;
            backtracking(n, 0, course, 0, (total + 1) / 2);
            System.out.println(cnt);
        }
        sc.close();
    }

    // 遞迴 - 回朔 (有多少門課, 目前在陣列的哪一門課, 所有課程, 被當的學分數, 會被二一的目標學分數)
    public static void backtracking(int n, int idx, int[] course, int failed, int target) {
        // Base Case
        if (idx == n) {
            if (target <= failed) cnt++;
            return;
        }

        // 沒被當
        backtracking(n, idx + 1, course, failed, target);
        
        // 被當 (加上目前課程的學分數)
        backtracking(n, idx + 1, course, failed + course[idx], target);
    }
}