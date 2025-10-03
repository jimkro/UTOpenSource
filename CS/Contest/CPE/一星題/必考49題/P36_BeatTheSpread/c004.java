package CPE;
import java.util.*;

public class c004 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for (int i = 0; i < cases; i++){
            int s = sc.nextInt();
            int d = sc.nextInt();

            if ((s - d) % 2 != 0){
                System.out.println("impossible");
            }else{
                int a = (s - d) / 2;
                int b = s - a;
    
                if (a < 0){
                    System.out.println("impossible");
                }else{
                    System.out.println(b + " " + a);
                }
            }           
        }
        sc.close();
    }
}
