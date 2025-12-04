import java.util.*;
public class PH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();

            // 記出現頻率
            int[] alpha = new int[128];

            for (char c : s2.toCharArray()) {
                // 判斷是不是字母
                if (Character.isAlphabetic(c)) alpha[c-'A']++;
            }

            for (int i = 0; i < 3; i++) {
                // 紀錄最大的索引值 及 最大出現次數
                int maxIdx = 0, maxSum = 0;
                for (int j = 0; j < 128; j++) {
                    if (alpha[j] > maxSum) {
                        maxSum = alpha[j];
                        maxIdx = j;
                    }
                }
                // 出現次數為零代表已經沒有字母出現過 -> 離開迴圈
                if (maxSum == 0) break;

                System.out.print((char)(maxIdx+'A') + " ");
                // 次數歸零不然會一直找到同樣的字母
                alpha[maxIdx] = 0;
            }

            System.out.println();

        }
        sc.close();
    }
}
