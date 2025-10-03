package CPE;
import java.util.*;

public class d672 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            String in = sc.next();
            int count = 1;
            int n = 0;
            
            if (in.charAt(0) == '0'){
                break;
            }

            for (int i = 0; i < in.length(); i++){
                n += in.charAt(i) - '0';
            }
            int temp = n;
            
            while (temp / 10 != 0){
                boolean go = true;
                n = temp;
                temp = 0;
                count ++;
                while (go){
                    temp += n % 10;
                    n = n / 10;
                    if (n == 0){
                        go = false;
                    }
                }
            }
                        
            if (temp == 9){
                System.out.println(in + " is a multiple of 9 and has 9-degree " + count + ".");
            }else{
                System.out.println(in + " is not a multiple of 9.");
            }
        }
        sc.close();
    }
}
