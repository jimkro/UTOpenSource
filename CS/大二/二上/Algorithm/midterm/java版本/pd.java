import java.io.*;
import java.util.*;
class pd{
    public static void main(String args[]) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String line = br.readLine();
            if(line==null||line.equals("0")) break;
            int n=Integer.parseInt(line);
            Map<String,Integer>mpp=new HashMap<>();//用index去對應string
            List<List<Integer>>tree=new ArrayList<>();
            long weight[]=new long[n];
            for(int i=0;i<n;i++){
                tree.add(new ArrayList<>());
            }
            for(int i=0;i<n;i++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                String c=st.nextToken();
                long w=Long.parseLong(st.nextToken());
                mpp.put(c,i);
                weight[i]=w;
            }
            boolean hp[]=new boolean[n];

            for(int i=0;i<n-1;i++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                String p=st.nextToken();
                String c=st.nextToken();
                int v1=mpp.get(p);
                int v2=mpp.get(c);
                hp[v2]=true;//代表v2有parent，所以標true
                tree.get(v1).add(v2);
            }
            int root=0;
            for(int i=0;i<n;i++){
                if(!hp[i]){
                    root=i;
                    break;
                }
            }
            long dp[][]=new long[n][2];
            dfs(dp,tree,root,weight);
            System.out.println(Math.max(dp[root][0],dp[root][1]));
        }
    }
    private static void dfs(long dp[][],List<List<Integer>>tree,int node,long weight[]){
        dp[node][1]=weight[node];
        dp[node][0]=0;
        for(int next:tree.get(node)){
                dfs(dp,tree,next,weight);
                dp[node][1]+=dp[next][0];
                dp[node][0]+=Math.max(dp[next][0],dp[next][1]);
        }
    }
}