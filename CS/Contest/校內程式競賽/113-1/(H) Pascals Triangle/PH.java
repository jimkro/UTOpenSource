import java.util.*;
public class PH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            long n = sc.nextInt();
            for(long i=0;i<=n;i++){
                System.out.print(C(n,i));
                if(i!=n) System.out.print(" ");
            }
            System.out.println();

            //手動算次方
            long sum = 1;
            while(n--!=0){
                sum *= 2;
            }
            System.out.println(sum);

        }

    }
    // 求組合數C(m,n)
    private static long C(long m,long n){
        long result = 1;
        long times = Math.min(m, m-n);
        
        long i = m; // 跑分子
        long j = 1; // 跑分母

        // 一邊乘一邊除數字才不會太大(雖然不知道有沒有必要)
        while(times--!=0){
            result = result * i / j;
            i--;
            j++;
        }

        return result;
    }
}
