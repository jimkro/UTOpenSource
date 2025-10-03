package Contest.CPE.一星題.必考49題.P44_SortSortandSort;
import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int N = sc.nextInt();
            int M = sc.nextInt();
            
            if(N==0 && M==0){
                System.out.println("0 0");
                break;
            }
            System.out.println(N + " " + M);

            Integer[] nums = new Integer[N];
            for(int i=0;i<N;i++){
                nums[i] = sc.nextInt();
            }

            Arrays.sort(nums,new Comparator<Integer>(){
                public int compare(Integer n1,Integer n2){
                    int m1 = n1 % M;
                    int m2 = n2 % M;
                    if(m1 != m2){
                        return m1 - m2;
                    }
                    if(n1 % 2 == 0 && n2 % 2 == 1){
                        return 1;
                    }
                    if(n1 % 2 == 1 && n2 % 2 == 0){
                        return -1;
                    }
                    if(n1 % 2 == 1 && n2 % 2 == 1){
                        return n2 - n1;
                    }

                    if(n1 % 2 == 0 && n2 % 2 == 0){
                        return n1 - n2;
                    }
                    return 0;
                }
            });
            for(int i=0;i<nums.length;i++){
                System.out.println(nums[i]);
            }
        }
    }
}
