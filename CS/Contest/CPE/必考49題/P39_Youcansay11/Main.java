import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) { 
            String N = sc.nextLine();

            if(N.charAt(0)=='0') break;
            int sum = 0;
            for(int i=0;i<N.length();i++){
                if(i%2==0){
                    sum += N.charAt(i) - '0'; //把字元轉整數 加
                }else{
                    sum -= N.charAt(i) - '0'; //把字元轉整數 減
                }
            }
            System.out.printf( (sum%11==0) ? (N+" is a multiple of 11.%n"):(N+" is not a multiple of 11.%n") ); //%n(換行),printf((判斷) ? true:false) 

        }
        sc.close();
    }
}