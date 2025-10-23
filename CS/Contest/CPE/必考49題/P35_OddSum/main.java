package 一星題.必考49題.P35_OddSum;
import java.util.*;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        int sum = 0;
        int times = 0;
        while(cases--!=0){
            times++;
            int left = sc.nextInt();
            int right = sc.nextInt();

            for(int i=left;i<=right;i++){
                if(i%2==1){
                    sum += i;
                }
            }
            System.out.println("Case "+times+": "+sum);
            sum = 0;
        }

    }
}
