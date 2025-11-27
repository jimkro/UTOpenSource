import java.util.*;

public class PD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int key = sc.nextInt();
        int delta = sc.nextInt();
        int[] loss = new int[n];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) loss[i] = sc.nextInt();
        for (int i = 0; i < n; i++) result[i] = sc.nextInt();
        
        int[] ans = new int[n];

        // dalta 奇數 -> 偶加奇減  偶數 -> 偶減奇加
        if (delta % 2 == 1) {
            for (int i = 0; i < n; i++) {
                if (result[i] % 2 == 0) ans[i] = result[i] + delta + loss[i];
                else ans[i] = result[i] - delta + loss[i];
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (result[i] % 2 == 0) ans[i] = result[i] - delta + loss[i];
                else ans[i] = result[i] + delta + loss[i];
            }
        }

        for (int i : ans) System.out.print(i + " ");
        sc.close();
    }
}