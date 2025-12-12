import java.util.*;

public class PB {
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            n = sc.nextInt();
            m = sc.nextInt();
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) arr[i][j] = sc.nextInt();
            }

            int k = sc.nextInt();
            while (k-->0) {
                int opera = sc.nextInt();

                if (opera == 1) arr = Up(arr);
                if (opera == 2) arr = Down(arr);
                if (opera == 3) arr = Left(arr);
                if (opera == 4) arr = Right(arr);
                if (opera == 5) arr = Clockise(arr);
                if (opera == 6) arr = Counterclockwise(arr);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) System.out.print(arr[i][j] + " ");
                System.out.println();
            }
            System.out.println();
        }
        sc.close();
    }

    // 往上
    public static int[][] Up(int[][] arr) {
        int[][] ans = new int[n][m];
        // 最上面移動到最下面
        for (int i = 0; i < m; i++) ans[n-1][i] = arr[0][i];

        // 其餘往上移動一格
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) ans[i-1][j] = arr[i][j];
        }

        return ans;
    }

    // 往下
    public static int[][] Down(int[][] arr) {
        int[][] ans = new int[n][m];
        // 最下面移動到最上面
        for (int i = 0; i < m; i++) ans[0][i] = arr[n-1][i];

        // 其餘往下移動一格
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) ans[i][j] = arr[i-1][j];
        }

        return ans;
    }

    // 往左
    public static int[][] Left(int[][] arr) {
        int[][] ans = new int[n][m];
        // 最左邊移動到最右邊
        for (int i = 0; i < n; i++) ans[i][m-1] = arr[i][0];

        // 其餘往左移動一格
        for (int i = 0; i < m-1; i++) {
            for (int j = 0; j < n; j++) ans[j][i] = arr[j][i+1];
        }

        return ans;
    }

    // 往右
    public static int[][] Right(int[][] arr) {
        int[][] ans = new int[n][m];
        // 最右邊移動到最左邊
        for (int i = 0; i < n; i++) ans[i][0] = arr[i][m-1];

        // 其餘往右移動一格
        for (int i = 0; i < m-1; i++) {
            for (int j = 0; j < n; j++) ans[j][i+1] = arr[j][i];
        }

        return ans;
    }

    // 順時針轉 90 度
    public static int[][] Clockise(int[][] arr) {
        int[][] ans = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) ans[j][n-i-1] = arr[i][j];
        }

        // 更新 arr 的大小 因為翻轉後 n m 會互換 大小會有差異
        arr = new int[m][n];
        
        // 交換 n m
        int tmp = n;
        n = m;
        m = tmp;

        return ans;
    }

    // 逆時針轉 90 度
    public static int[][] Counterclockwise(int[][] arr) {
        int[][] ans = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) ans[m-j-1][i] = arr[i][j];
        }

        // 更新 arr 的大小 因為翻轉後 n m 會互換 大小會有差異
        arr = new int[m][n];
        
        // 交換 n m
        int tmp = n;
        n = m;
        m = tmp;

        return ans;
    }

}