import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            // 檢查 n 或 m 小於等於 1 的情況
            if (n <= 1 || m <= 1) {
                System.out.println("Boring!");
                continue;  // 直接跳到下一組測試數據
            }

            boolean isBoring = false;
            ArrayList<Integer> data = new ArrayList<>();
            data.add(n);

            while (n != 1) {
                // 無法整除的情況，序列無法形成
                if (n % m != 0) {
                    System.out.println("Boring!");
                    isBoring = true;
                    break;
                }

                n = n / m;
                data.add(n);
            }

            // 如果序列是合法的，輸出數列
            if (!isBoring) {
                for (int i = 0; i < data.size(); i++) {
                    if (i == data.size() - 1) {
                        System.out.println(data.get(i));
                    } else {
                        System.out.print(data.get(i) + " ");
                    }
                }
            }
        }
    }
}
