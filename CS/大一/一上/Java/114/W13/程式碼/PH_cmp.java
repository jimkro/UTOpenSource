import java.util.*;
public class PH_cmp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();

            // 記字母出現頻率 [[字母順序, 出現次數]]
            int[][] alpha = new int[128][2];

            // 先將二維陣列的第一位初始化字母順序
            for (int i = 0; i < 128; i++) alpha[i][0] = i;

            // 記字母出現頻率
            for (char c : s2.toCharArray()) {
                if (Character.isAlphabetic(c)) alpha[c-'A'][1]++;
            }

            // 自訂排序 出現頻率不同 -> 大到小 ; 頻率相同 -> ASCII小到大
            Arrays.sort(alpha, (m1, m2) -> {
                if (m1[1] != m2[1]) return Integer.compare(m2[1], m1[1]);
                return Integer.compare(m1[0], m2[0]);
            });

            for (int i = 0; i < 3; i++) {
                // 遇到零就離開
                if (alpha[i][1] == 0) break;
                System.out.print((char)(alpha[i][0] + 'A') + " ");
            }
            System.out.println();

        }
        sc.close();
    }
}
