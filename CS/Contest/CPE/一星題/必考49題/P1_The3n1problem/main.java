package 一星題.必考49題.P1_The3n1problem;
import java.util.*;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){

            int max = 1;
            int left = sc.nextInt();
            int right = sc.nextInt();
            int a = left;
            int b = right;

            //排大小
            if(right<left){
                int temp = left;
                left = right;
                right = temp;
            }
            //找最大值
            for(int i=left;i<=right;i++){
                if(cycleLength(i)>max){
                    max = cycleLength(i);
                }
            }
            //輸出
            System.out.println(a+" "+ b + " " + max);            
        }     
    }

    //算cycle length
    public static int cycleLength(int n){
        int result = 1;

        while(n!=1){
            result++;
            if(n%2==0){
                n /= 2;
            }else{
                n = 3*n + 1;
            }
        }

        return result;
    }
}
