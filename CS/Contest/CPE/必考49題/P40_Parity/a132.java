package CPE;
import java.util.*;

public class a132 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()){
            int a = sc.nextInt();
            int ans = 0;

            if (a == 0){
                break;
            }

            String n = Integer.toBinaryString(a);
            for (int i = 0; i < n.length(); i++){
                if (n.charAt(i) == '1'){
                    ans += 1;
                }
            }

            System.out.println("The parity of " + n + " is " + ans + " (mod 2).");

        }
        sc.close();
    }
}