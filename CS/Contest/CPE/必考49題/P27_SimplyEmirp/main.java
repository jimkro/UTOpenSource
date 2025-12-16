package 一星題.必考49題.P27_SimplyEmirp;
import java.util.*;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(isPrime(n)){
                if(isPrime(reverse(n)) && n!=reverse(n)){
                    System.out.println(n+" is emirp.");
                }else{
                    System.out.println(n+" is prime.");
                }
            }else{
                System.out.println(n+" is not prime.");
            }
        }
        
    }

    //判斷是否為質數
    public static boolean isPrime(int num) {
        // 如果數字小於 2 則不是質數
        if (num < 2) {
            return false;
        }

        // 只檢查到 num 的平方根
        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false; // 如果能被整除，則不是質數
            }
        }

        return true; // 否則是質數
    }
    
    //反轉int
    public static int reverse(int x) {
        int reversed = 0;
        
        while (x != 0) {
            int pop = x % 10;  // 取出最後一位
            x /= 10;           // 移除最後一位
            
            // 檢查是否會溢出
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;  // 正向溢出
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;  // 負向溢出
            }
            
            // 將最後一位加到反轉後的數字上
            reversed = reversed * 10 + pop;
        }
        
        return reversed;
    }
}
