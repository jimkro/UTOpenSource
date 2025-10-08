import java.util.*;
class uva348{
    public static void main(String[] args) {
        // uva 348 zerojudge c112 java參考解法，leetcode 1547有類似題可以寫，leetcode 1000為進階題也可以嘗試
        Scanner sc =new Scanner(System.in);
        int cases=1;
        while(sc.hasNextInt()){
            int n=sc.nextInt();
            if(n==0)break;
            int matrix[]=new int[n+1];
            int split[][]=new int[n+1][n+1];

            for(int i=1;i<=n;i++){
                matrix[i-1]=sc.nextInt();
                matrix[i]=sc.nextInt();
            }

            int dp[][]=new int [n+1][n+1];
            
            for(int len=2;len<=n;len++){
                //合併長度
                for(int i=1;i+len-1<=n;i++){
                    int j=i+len-1;
                    dp[i][j]=Integer.MAX_VALUE;
                    for(int k=i;k<j;k++){
                        //計算在此合併的花費
                        int cost=dp[i][k]+dp[k+1][j]+matrix[i-1]*matrix[k]*matrix[j];
                        //用 <= 是因為zerojudge沒有special judge，沒辦法處理多種解。在uva上 < 就可以了
                        if(cost<=dp[i][j]){
                            dp[i][j]=cost;
                            //紀錄分割點
                            split[i][j]=k;
                        }
                    }
                }
            }
            //輸出分割點
            // System.out.println("Split Table:");
            // for(int i=1;i<=n;i++){
            //     for(int j=1;j<=n;j++){
            //         System.out.print(split[i][j] + "\t");
            //     }
            //     System.out.println();
            // }

            System.out.print("Case "+cases+++": ");
            //具現矩陣相乘順序
            printOrder(1, n,split);
            System.out.println("");
        }
    }
    private static void printOrder(int i,int j,int split[][]){
        if(i==j){
            System.out.print("A"+i);
        }else{
            System.out.print("(");
            printOrder(i, split[i][j],split);
            System.out.print(" x ");
            printOrder(split[i][j]+1,j,split);
            System.out.print(")");
        }
    }
}