import java.util.*;
import java.io.*;
public class Pc {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output=new StringBuilder();
        while(true){
            String line =br.readLine();
            if(line==null||line.isEmpty())break;
            StringTokenizer st=new StringTokenizer(line);
            int n=Integer.parseInt(st.nextToken());
            if(n==0)break;
            int e=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            List<List<int[]>>relation=new ArrayList<>();
            boolean visited[]=new boolean[n+1];
            for(int i=0;i<=n;i++){
                relation.add(new ArrayList<>());
            }
            for(int i=0;i<e;i++){
                st=new StringTokenizer(br.readLine());
                int node1=Integer.parseInt(st.nextToken());
                int node2=Integer.parseInt(st.nextToken());
                int stamina=Integer.parseInt(st.nextToken());
                int social=Integer.parseInt(st.nextToken());
                relation.get(node1).add(new int[]{node2,stamina,social});
                relation.get(node2).add(new int[]{node1,stamina,social});
            }
            PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->{
                return a[1]==b[1]?a[2]-b[2]:a[1]-b[1];
            });
            pq.add(new int[]{start,0,0});
            boolean find=false;
            while(!pq.isEmpty()){
                int temp[]=pq.poll();
                int node=temp[0],sta=temp[1],se=temp[2];
                visited[node]=true;
                if(node==end){
                    int cnt1=100-sta;
                    int cnt2=100-se;
                    output.append(cnt1).append("% ").append(cnt2).append("%\n");
                    find=true;
                    break;
                }
                for(int next[]:relation.get(node)){
                    if(visited[next[0]])continue;
                    int nsta=sta+next[1];
                    int nse=se+next[2];
                    if(nsta<100&&nse<100){
                        pq.add(new int[]{next[0],nsta,nse});
                    }
                }
            }
            if(!find){
                output.append("Passed out").append("\n");
            }
        }
        System.out.print(output);
    }
}
// import java.util.*;
// class Pc{
//     public static void main(String args[]){
//         Scanner sc=new Scanner(System.in);
//         while(true){
//             int n=sc.nextInt();
//             int e=sc.nextInt();
//             if(n==0&&e==0)break;
//             int start=sc.nextInt();
//             int end=sc.nextInt();
//             Map<Integer,ArrayList<int[]>> mpp=new HashMap();
//             for(int i=0;i<e;i++){
//                 int v1=sc.nextInt();
//                 int v2=sc.nextInt();
//                 int stamina=sc.nextInt();
//                 int social=sc.nextInt();
//                 mpp.computeIfAbsent(v1,k->new ArrayList<>()).add(new int[]{v2,stamina,social});
//                 mpp.computeIfAbsent(v2,k->new ArrayList<>()).add(new int[]{v1,stamina,social});
//             }
//             int ans[]=new int[2];
//             ans[0]=Integer.MAX_VALUE;
//             ans[1]=Integer.MAX_VALUE;
//             int temp[]=new int[2];
//             int[][] best=new int[n+1][101];
//             for(int i=0;i<=n;i++) {
//                 Arrays.fill(best[i],Integer.MAX_VALUE);
//             }
//             best[start][0]=0;
//             dfs(mpp,start,end,ans,temp,best);
//             System.out.println(ans[0]<100&&ans[1]<100?100-ans[0]+"% "+(100-ans[1])+"%":"Passed out");
//         }
//         sc.close();
//     }
//     public static void dfs(Map<Integer,ArrayList<int[]>> mpp,int cur,int end,int ans[],int temp[],int best[][]){
//         if(cur==end){
//             if(temp[0]<ans[0]){
//                 ans[0]=temp[0];
//                 ans[1]=temp[1];
//             }
//             else if(temp[0]==ans[0]&&temp[1]<ans[1]){
//                 ans[1]=temp[1];
//             }
//             return;
//         }
//         else{
//             List<int[]> neighbors = mpp.get(cur);
//             if(neighbors==null)return;
//             for(int neighbor[]:neighbors){
//                 int next=neighbor[0];
//                 int stamina=neighbor[1];
//                 int social=neighbor[2];
//                 int newst=temp[0]+stamina;
//                 int newso=temp[1]+social;
//                 if(newst>=100||newso>=100) continue;
//                 if(best[next][newst]<newso)continue;
//                 best[next][newst]=newso;
//                 temp[0]+=stamina;
//                 temp[1]+=social;
//                 dfs(mpp,next,end,ans,temp,best);
//                 temp[0]-=stamina;
//                 temp[1]-=social;
//             }   
//         }
//     }
// }
