package CPE;
import java.util.*;

public class d235 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNextLine()){
            String in = sc.next();
            //long use = in;
            //int count = 0;
            long ans = 0;

            if (in.charAt(0) == '0'){
                break;
            }

            for (int i = 0; i < in.length(); i++){
                //int use = in.charAt(i) - '0';
                //long temp = use % 10;
                //use /= 10;
                //count += 1;
                if (i % 2 == 0){
                    ans -= in.charAt(i) - '0';
                }else{
                    ans += in.charAt(i) - '0';
                }
            }

            if (ans % 11 != 0){
                System.out.println(in + " is not a multiple of 11.");
            }else{
                System.out.println(in + " is a multiple of 11.");
            }

        }
        sc.close();
    }
}
