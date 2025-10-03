import java.util.*;

public class PD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // 讀取蚊子數量 N
            int N = sc.nextInt();
            if (N == 0) break;

            List<double[]> mosquitoes = new ArrayList<>();

            // 讀取每隻蚊子的資料
            for (int i = 0; i < N; i++) {
                int no = sc.nextInt();
                double weight = sc.nextDouble();
                double speed = sc.nextDouble();
                int decibel = sc.nextInt();
                //一律當浮點數
                mosquitoes.add(new double[]{no, weight, speed, decibel});
            }

            // 排序規則：分貝降序 -> 速度降序 -> 體重升序 -> 編號升序
            mosquitoes.sort(new Comparator<double[]>() {
                public int compare(double[] m1, double[] m2) {
                    // 分貝降序
                    if (m1[3] != m2[3]) {
                        return Double.compare(m2[3], m1[3]);
                    }
                    // 速度降序
                    if (m1[2] != m2[2]) {
                        return Double.compare(m2[2], m1[2]);
                    }
                    // 體重升序
                    if (m1[1] != m2[1]) {
                        return Double.compare(m1[1], m2[1]);
                    }
                    // 編號升序
                    return Double.compare(m1[0], m2[0]);
                }
            });

            // 輸出排序後的結果
            for (double[] mosquito : mosquitoes) {
                System.out.print((int) mosquito[0] + " "); // 輸出蚊子的編號
            }
            System.out.println();
        }

        sc.close();
    }
}
