package Contest.CPE.一星題.必考49題.P30_498bis;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            int x = sc.nextInt();
            sc.nextLine();
            // 因為有未知個係數所以接整行
            String[] arr = sc.nextLine().split(" ");
            // String -> int
            int[] coefs = new int[arr.length];
            for(int i=0;i<arr.length;i++){
                coefs[i] = Integer.parseInt(arr[i]);
            }
            // 計算微分後的值
            int sum = 0; // 和
            int count = 0; // 指數
            for(int i=coefs.length-1;i>=0;i--){
                sum += coefs[i] * count * Math.pow(x,count-1);  
                count++;
            }
            // 輸出
            System.out.println(sum);
        }
    }
}
