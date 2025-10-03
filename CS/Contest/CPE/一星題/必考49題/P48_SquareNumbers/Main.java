import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int result = 0;
            //取得區間
            int left = sc.nextInt();
            int right = sc.nextInt();
            //結束條件
            if(left==0 && right==0)break;
            //如果 0 b的狀況
            if (left==0) result++;

            for(int i=left;i<=right;i++){
                if(Math.sqrt(i)%1==0){
                    result++;
                }
            }
            System.out.println(result);


        }

    }
}