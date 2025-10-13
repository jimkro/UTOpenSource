import java.util.*;
class Pc{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        while(true){
            int n=sc.nextInt();
            int e=sc.nextInt();
            if(n==0&&e==0)break;
            int start=sc.nextInt();
            int end=sc.nextInt();
            Map<Integer,ArrayList<int[]>> mpp=new HashMap();
            for(int i=0;i<e;i++){
                int v1=sc.nextInt();
                int v2=sc.nextInt();
                int stamina=sc.nextInt();
                int social=sc.nextInt();
                mpp.computeIfAbsent(v1,k->new ArrayList<>()).add(new int[]{v2,stamina,social});
                mpp.computeIfAbsent(v2,k->new ArrayList<>()).add(new int[]{v1,stamina,social});
            }
            int ans[]=new int[2];
            ans[0]=Integer.MAX_VALUE;
            ans[1]=Integer.MAX_VALUE;
            int temp[]=new int[2];
            int[][] best=new int[n+1][101];
            for(int i=0;i<=n;i++) {
                Arrays.fill(best[i],Integer.MAX_VALUE);
            }
            best[start][0]=0;
            dfs(mpp,start,end,ans,temp,best);
            System.out.println(ans[0]<100&&ans[1]<100?100-ans[0]+"% "+(100-ans[1])+"%":"Passed out");
        }
        sc.close();
    }
    public static void dfs(Map<Integer,ArrayList<int[]>> mpp,int cur,int end,int ans[],int temp[],int best[][]){
        if(cur==end){
            if(temp[0]<ans[0]){
                ans[0]=temp[0];
                ans[1]=temp[1];
            }
            else if(temp[0]==ans[0]&&temp[1]<ans[1]){
                ans[1]=temp[1];
            }
            return;
        }
        else{
            List<int[]> neighbors = mpp.get(cur);
            if(neighbors==null)return;
            for(int neighbor[]:neighbors){
                int next=neighbor[0];
                int stamina=neighbor[1];
                int social=neighbor[2];
                int newst=temp[0]+stamina;
                int newso=temp[1]+social;
                if(newst>=100||newso>=100) continue;
                if(best[next][newst]<newso)continue;
                best[next][newst]=newso;
                temp[0]+=stamina;
                temp[1]+=social;
                dfs(mpp,next,end,ans,temp,best);
                temp[0]-=stamina;
                temp[1]-=social;
            }   
        }
    }
}