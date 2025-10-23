import java.util.*;
class uva10304{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int n=sc.nextInt();
            int node[]=new int[n];
            int prefix[]=new int[n+1]; // 前綴和陣列，方便計算區間總和
            int dp[][]=new int [n][n]; // dp[i][j] 表示節點 i 到 j 的最小成本
            for(int i=0;i<n;i++){
                node[i]=sc.nextInt();
                prefix[i+1]=prefix[i]+node[i];
            }
            // len 表示子序列長度，從 1 到 n
            for(int len=1;len<=n;len++){
                // i 為子序列的起點
                for(int i=0;i+len-1<n;i++){
                    int j=i+len-1; // 子序列的終點
                    dp[i][j]=Integer.MAX_VALUE;
                    // 嘗試選 k 為根節點
                    for(int k=i;k<=j;k++){
                        int sum=prefix[j+1]-prefix[i];
                        
                        int left=(k>i)?dp[i][k-1]:0; // 左子樹成本
                        int right=(k<j)?dp[k+1][j]:0; // 右子樹成本

                        // 總成本 = 左子樹 + 右子樹 + 區間總和 - 根節點
                        int cost=sum+left+right-node[k];


                        dp[i][j]=Math.min(dp[i][j],cost);
                    }
                }
            }
            System.out.println(dp[0][n-1]);
        }
    }
}