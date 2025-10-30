package CPE;
import java.util.*;

public class e513 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        
        for (int i = 0; i < cases; i++){
            String f = sc.next();
            String p = sc.next();
            int floor = Integer.parseInt(sc.next());
            boolean b = true;
            floor *= floor;
            
            long[] ans = new long[floor];
            for (int k = 0; k < floor; k++){
                ans[k] = Long.parseLong(sc.next());
            }

                for (int j = 0; j < floor; j++){
                    if (ans[j] != ans[floor-1-j] || ans[j] < 0){
                        System.out.println("Test #"+(i+1)+": Non-symmetric.");
                        b = false;
                        break;
                    }
                }
                if (b){
                    System.out.println("Test #"+(i+1)+": Symmetric.");
                }
        }
        sc.close();
    }
}