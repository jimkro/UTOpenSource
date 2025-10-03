import java.util.*;
public class PI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();

        while(cases--!=0){
            // 輸入
            int a = sc.nextInt(); // 不循環長度
            int b = sc.nextInt(); // 循環節長度
            String s1 = sc.next(); // 不循環
            String s2 = sc.next(); // 循環

            // 算res1(分子)
            long res1 = Long.parseLong(s1+s2) - Long.parseLong(s1);
            // 算res2(分母)
            long res2 = 9;
            for(int i=0;i<b-1;i++){ // 999...
                res2 = res2 * 10 + 9;
            }
            for(int i=0;i<a;i++){ // ...000
                res2 *= 10;
            }

            // 除gcd來約分
            long gcd = gcd(res1,res2);
            res1 /= gcd;
            res2 /= gcd;
            // 輸出
            System.out.println(res1+" "+res2);
        }
    }

    //找最大公因數
    private static long gcd(long a,long b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
/*
 * 無限循環小數知識點:
 * 以0.1232323232323....為例子
 * 1不循環23循環(不循環長度(a) = 1;循環長度(b) = 2)
 * 分子 = 123 - 1 = 122 全部 - 不循環
 * 分母 = b 個 9 + a個零 = 990
 * 
 * 約分:
 * 分子分母同除最大公因數即可
 * 
 * 最大公因數:
 * 輾轉相除法
 * 
 */