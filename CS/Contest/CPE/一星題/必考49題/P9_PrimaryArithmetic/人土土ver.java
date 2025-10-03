import java.util.*;

public class c014 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int ans = 0;

        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a == 0 && b == 0) break;
            int[] x = new int[11];
            int[] y = new int[11];
            int count1 = 0;
            int count2 = 0;

            while(a != 0){
                x[count1] = a % 10;
                a /= 10;
                count1++;
            }
            while(b != 0){
                y[count2] = b % 10;
                b /= 10;
                count2++;
            }
            
            int big = Math.max(count1, count2);
            for(int i = 0; i <= big; i++){
                if(x[i] + y[i] >= 10){
                    ans += 1;
                    x[i + 1] += 1;
                }
            }

            if(ans == 0){
                System.out.println( "No carry operation.");
            }else if(ans == 1){
                System.out.println( "1 carry operation.");
            }else{
                System.out.println(ans + " carry operations.");
            }
            ans = 0;
            
        }
        sc.close();
    }
}
