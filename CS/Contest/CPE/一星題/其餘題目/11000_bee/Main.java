import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int N = sc.nextInt();
            //終止條件
            if(N==-1) break;
            //開公母分別開dp，用long因為題目說上限可達2^32
            long[] dpboy = new long[N+1];
            long[] dpgirl = new long[N+1];

            //設定初始狀態
            dpboy[0] = 0;
            dpgirl[0] = 1;
            for(int i=1;i<N+1;i++){
                dpboy[i] = dpboy[i-1] + dpgirl[i-1]; // 今年公 = 去年公 + 去年母
                dpgirl[i] = dpboy[i-1] + 1;          // 今年母 = 去年公 + 1(最一開始那隻母的)
            }
            //輸出
            System.out.println(dpboy[N]+" "+(dpboy[N]+dpgirl[N]));
        }
    }
}