// By Allen Chang
/* Idea 
當使用Java時，幾種可能的解法：
1. 遞迴解，但這會導致TLE
2. 階乘，但從21!開始值會超過long的範圍，會需要用BigInteger
3. 直接做Pascals Triangle，此時需要用DP方式解題，我們可以用陣列
紀錄
基於還沒學過BigInteger，使用第三種解法是比較好的選擇。 */

/* What's DP?
DP(Dynamic programming)是一種解題技巧，以空間換取時間，如果題
目中有某些值是我們可以重複使用的，我們就可以記錄起來避免重複計算。 */

// Solution
import java.util.*;
public class pH {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long[][] pascal = new long[51][51];
        pascal[0][0] = 1;
        pascal[1][0] = 1;
        pascal[1][1] = 1;
        for(int i=2;i<=50;i++){
            for(int j=0;j<=i;j++){
                if(j==0) pascal[i][j] = 1;
                else if(j==i) pascal[i][j] = 1;
                else{
                    pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
                }
            }
        }
        while(input.hasNext()){
            int n = input.nextInt();
            long sum = 0;
            long tmp = 0;
            for(int k=0; k<=n; k++){
                tmp = pascal[n][k];
                System.out.print(tmp+" ");
                sum += tmp;
            }
            System.out.println();
            System.out.println(sum);
        }
        input.close();
    }
}