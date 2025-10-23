package CPE;
import java.util.*;

public class c039 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int max = Math.max(a, b);
            int min = Math.min(a, b);
            int ans = 0;

            for (int i = min; i <= max; i++){
                //System.out.println(a);
                int count = 1;
                int now = i;
                while (now != 1){
                    if (now % 2 ==0){
                        now /= 2;
                        count ++;
                    }else{
                        now = now * 3 + 1;
                        count ++;
                    }                    
                }
                if (count > ans){                        
                    ans = count;
                }                
            }
            System.out.println(a + " " + b + " " + ans);
        }
        sc.close();
    }
}
