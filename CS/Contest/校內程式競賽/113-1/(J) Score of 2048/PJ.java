import java.util.*;
class PJ{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while(sc.hasNext()){

            long n = sc.nextLong();
            n *= n; //共要讀n*n個整數
            long res = 0; //存結果

            //接收並處理數字
            while(n--!=0){
                long num = sc.nextLong();
                res += F(num);
            }
            
            //輸出
            System.out.println(res);
        }
        
    }
    //遞迴解 F(n) = n + 2*F(n/2) ，其中0不算，生成的2不被計算為獲得的分數，故2的分數也是0;
    public static long F(long n){
        return (n==0 || n==2) ? 0 : n + 2 * F(n/2);
    }
}
