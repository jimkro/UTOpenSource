import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = 0;
        
        while (true) {

            // 讀取行數和列數
            int M = sc.nextInt();
            int N = sc.nextInt();

            //暫停條件
            if (M == 0 && N == 0) break;
            
            //建地圖
            char[][] field = new char[M][N];
            
            // 讀取輸入的地圖
            for (int i = 0; i < M; i++) {
                String line = sc.next();
                field[i] = line.toCharArray(); //可以一次讀一行來存，比較方便
            }
            
            // 處理結果
            if (testCase > 0) {
                System.out.println();
            }

            System.out.println("Field #" + (++testCase) + ":");
            
            // 建立結果陣列
            int[][] result = new int[M][N];
            
            // 方向數組，用於表示 8 個方向(AI提供的方便好方法)
            int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
            
            // 遍歷所有位置
            for (int i = 0; i < M; i++) { //橫列
                for (int j = 0; j < N; j++) {  //直行
                    if (field[i][j] == '*') { //找到星號
                        // 遍歷 8 個方向
                        for (int k = 0; k < 8; k++) {
                            int ni = i + dx[k];
                            int nj = j + dy[k];
                            if (ni >= 0 && ni < M && nj >= 0 && nj < N && field[ni][nj] != '*') { //看有無超出邊界或是地雷
                                result[ni][nj]++;
                            }
                        }
                    }
                }
            }
            
            // 輸出結果
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (field[i][j] == '*') {
                        System.out.print('*');
                    } else {
                        System.out.print(result[i][j]); //把"..."都改成數字
                    }
                }
                System.out.println();
            }
        }
        sc.close();
    }
}
