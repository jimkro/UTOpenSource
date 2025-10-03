package CPE;
import java.util.*;

public class d097 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int len = sc.nextInt();
            int[] arr = new int[len];
            int d = len - 1;
            boolean se = true;
            List<Integer> ans = new ArrayList<Integer>();//存間隔

            //存輸入
            for (int i = 0; i < len; i++){
                arr[i] = sc.nextInt();
            }

            for (int j = 0; j < d; j++){
                int temp = Math.abs(arr[j] - arr[j + 1]);
                if (temp < 1 | temp > d){//如果間隔差超出範圍，就是Not
                    se = false;
                    break;
                }else{
                    if (!ans.contains(temp)){
                        ans.add(temp);
                    }
                }
            }

            //如果間隔差的數量和間隔數不同 就是Not
            while (se) {
                if (ans.size() != len-1){
                    se = false;
                }
                break;
            }
            
            if (se){
                System.out.println("Jolly");
            }else{
                System.out.println("Not jolly");
            }
        }
        sc.close();
    }
}
