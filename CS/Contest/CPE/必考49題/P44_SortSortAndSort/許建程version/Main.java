import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            if (N == 0 && M == 0) {
                System.out.println("0 0");
                break;
            }

            // 讀取所有的數字
            int[] numbers = new int[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = sc.nextInt();
            }

            // 分組並處理
            List<Integer> sortedList = new ArrayList<>();
            
            // mod範圍可以是負的，所以i從負的開始
            for (int mod = -M + 1; mod < M; mod++) {
                // 暫時的列表來存儲當前模數的數字
                List<Integer> odds = new ArrayList<>();
                List<Integer> evens = new ArrayList<>();

                // 按模數分類
                for (int num : numbers) {
                    
                    int currentMod = num % M;

                    if (currentMod == mod) {
                        if (num % 2 == 0) {
                            evens.add(num);  // 偶數
                        } else {
                            odds.add(num);   // 奇數
                        }
                    }
                }

                // 對奇數降序排列
                Collections.sort(odds, Collections.reverseOrder());

                // 對偶數升序排列
                Collections.sort(evens);

                // 合併結果
                sortedList.addAll(odds);  // 先加入奇數
                sortedList.addAll(evens); // 然後加入偶數
            }

            // 輸出結果
            System.out.println(N + " " + M);
            for (int num : sortedList) {
                System.out.println(num);
            }
        }

        sc.close();
    }
}
