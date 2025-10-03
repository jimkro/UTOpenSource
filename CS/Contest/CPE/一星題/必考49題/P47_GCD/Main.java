package 一星題.必考49題.P47_GCD;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int N = sc.nextInt();
            //接收到0就結束
            if(N==0){
                break;
            }

            int G=0;
            
            for(int i=1;i<N;i++){

                for(int j=i+1;j<=N;j++){
                    G+=gcd(i,j);
                }
            }
            System.out.println(G);
        
        }
    }







    //gcd
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
