package CPE;
import java.util.*;

public class a134 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for (int i = 0; i < cases; i++) {
            long in = sc.nextLong();
            long g = in;
            List<Long> arr = new ArrayList<Long>();
            List<Integer> ans = new ArrayList<Integer>();
            arr.add((long)1);
            arr.add((long)1);
            boolean big = true;
            boolean one = true;
            int a = 0;//算數列長度

            if (in == (long)1){
                System.out.println("1 = 1 (fib)");
                big = false;
                one = false;
            }

            while (big){//找小於輸入的最大值
                long temp = arr.get(a) + arr.get(a+1);//下一個值
                arr.add(temp);
                if (temp >= in){//找到了
                    big = false;
                    break;
                }
                a ++;
            }

            arr.remove(1);

            for (int j = arr.size()-1; j >= 0; j--){
                if (arr.get(j) <= in){
                    in -= arr.get(j);
                    ans.add(1);
                }else if (j != arr.size()-1){
                    ans.add(0);
                }
            }

            if (one){
                System.out.print(g + " = ");
                for (int y = 0; y < ans.size(); y++){
                    System.out.print(ans.get(y));
                }
                System.out.print(" (fib)");
                System.out.print("\n");
            }
        }
        sc.close(); 
    }
}
