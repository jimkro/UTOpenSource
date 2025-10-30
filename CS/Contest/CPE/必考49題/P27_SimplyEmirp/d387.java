package CPE;
import java.util.*;

public class d387 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int loop = n;
            int s = 0;
            int count = 0;
            boolean o = false;
            for (int i = 2; i < (int)Math.sqrt(loop) + 1; i++){
                //非質數
                if (n % i == 0){
                    System.out.println((int)n + " is not prime.");
                    break;
                }else{
                    count += 1;
                }
            }

            if (count == (int)Math.sqrt(loop) - 1){
                o = true;
            }

            while (o){
                o = false;
                //顛倒數字
                int a = (int)n;
                while (a != 0){
                    int temp = a % 10;
                    a = a / 10;
                    s += temp;
                    s = s * 10;
                }
                s = s / 10;

                if (s == n){
                    System.out.println((int)n + " is prime.");
                    o = false;
                    break;
                }

                loop = s;
                boolean l = false;
                count = 0;
                //檢查反轉數字是不是質數
                for (int j = 2; j < loop; j++){
                    if (s % j == 0){
                        break;
                    }else{
                        count += 1;
                    }
                }

                //反轉後還是質數
                if (count == loop - 2){
                    l = true;
                }

                if (l) {
                    System.out.println((int)n + " is emirp.");
                    o = false;
                    break;
                }else{
                    System.out.println((int)n + " is prime.");
                    o = false;
                    break;
                }
            } 
        }
        sc.close();
    } 
}

