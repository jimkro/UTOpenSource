import java.util.*;
public class PE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while(T--!=0){
            String num = sc.next();
            int base = sc.nextInt();

            long n = Long.parseLong(num,base); // 先轉成10進位
            long times = num.length(); // 決定各個數字要幾次方
            long count = 0; //算總和，最後拿來檢查有沒有等於n

            for(char c:num.toCharArray()){
                long k = 0; // 把字元轉換成數字

                if(c>='A' && c<='F'){ // 11~16進位會用到A~F，所以字母要額外處理
                    
                    k = (long)(c-'A' + 10);
                }else{
                    k = (long)(c-'0');
                }
                
                
                long curr = 1; // 算次方，但其實應該可以用函式就好
                for(int i=0;i<times;i++){
                    curr *= k;
                }
                
                count += curr;
                
            }
            // 輸出
            if(n==count) System.out.println("YES");
            else System.out.println("NO");

        }
    }
}
