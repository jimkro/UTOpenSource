import java.util.*;
public class uva10496 {                         
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int x=sc.nextInt(),y=sc.nextInt();
            int sx=sc.nextInt(),sy=sc.nextInt();

            int n=sc.nextInt()+1;//包含起點所以加一

            point points[]=new point[n];
            points[0]=new point(sx,sy);
            for(int i=1;i<n;i++){
                points[i]=new point(sc.nextInt(),sc.nextInt());
            }

            int size=1<<n;// 狀態數量，因為用 bitmask 表示哪些點已經訪問過
            int dist[][]=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dist[i][j]=Math.abs(points[i].x-points[j].x)+Math.abs(points[i].y-points[j].y);
                }
            }

            int dp[][]=new int[size][n];
            for(int row[]:dp){
                Arrays.fill(row,-1);
            }

            int ans=tsp(1,0,dp,dist,n);
            System.out.println("The shortest path has length "+ans);
        }
    }
    private static int tsp(int mask,int pos,int dp[][],int dist[][],int n){
        if(mask==(1<<n)-1){
            return dist[pos][0];
        }
        if(dp[mask][pos]!=-1)return dp[mask][pos];
        
        int ans=Integer.MAX_VALUE;
        
        // 嘗試下一個還沒走過的點
        for(int next=0;next<n;next++){
            // 如果 next 點沒被訪問過
            if((mask&(1<<next))==0){
                // 更新最短路徑: 當前距離 + 從 next 繼續走的最短距離
                ans=Math.min(dist[pos][next]+tsp(mask|(1<<next), next,dp,dist,n),ans);
            }
        }
        dp[mask][pos]=ans;
        return ans;
    } 



    static class point{
        int x;
        int y;
        point(int x,int y){
            this.x=x;
            this.y=y;
        }
    } 
}
