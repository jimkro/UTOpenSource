import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // 輸入
            long num1 = sc.nextLong();
            long num2 = sc.nextLong();

            // 終止條件
            if (num1 == 0 && num2 == 0) {
                break;
            }

            int carryCount = 0;  // 進位次數
            int carry = 0; // 當前的進位

            // 相加直到都歸0
            while (num1 > 0 || num2 > 0) {
                // 取出 num1 和 num2 的最右邊的一位進行相加
                int digit1 = (int) (num1 % 10);
                int digit2 = (int) (num2 % 10);

                // 求和(要加上進位)
                int sum = digit1 + digit2 + carry;

                // 處理進位
                if (sum >= 10) {
                    carry = 1;  // 進位
                    carryCount++;  // 計數
                } else {
                    carry = 0;  // 沒有進位
                }

                // 移動到下一位
                num1 /= 10;
                num2 /= 10;
            }

            // 輸出
            if (carryCount == 0) {
                System.out.println("No carry operation.");
            } else if (carryCount == 1) {
                System.out.println("1 carry operation.");
            } else {
                System.out.println(carryCount + " carry operations.");
            }
        }
        sc.close();
    }
}
