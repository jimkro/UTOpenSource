package CPE;
import java.util.*;

public class e561 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();


        for (int i = 0; i < cases; i++){
            int q = sc.nextInt();
            int times = 0;
            int[] num = new int[q];
            for (int y = 0; y < q; y++){
                num[y] = sc.nextInt();
            }

            for (int t = 0; t < q - 1; t++){
                for (int z = 0; z < q-1; z++){
                    if (num[z+1] < num[z]){                    
                        int a = num[z];
                        int b = num[z+1];                    
                        num[z+1] = a;
                        num[z] = b;
                        times ++;
                    }
                }
            }


            System.out.println("Optimal train swapping takes " + times + " swaps.");
            
        }
        sc.close();
    } 
}
