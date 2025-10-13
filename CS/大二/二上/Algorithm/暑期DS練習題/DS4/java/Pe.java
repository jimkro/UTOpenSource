import java.util.*;
class Pe{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int v=sc.nextInt();
            int e=sc.nextInt();
            List<List<int[]>> graph=new ArrayList<>();
            for(int i=0;i<=v;i++) {
                graph.add(new ArrayList<>());
            }

            for(int i=0;i<e;i++){
                int v1=sc.nextInt();
                int v2=sc.nextInt();
                int value=sc.nextInt();
                graph.get(v1).add(new int[]{v2, value});
                graph.get(v2).add(new int[]{v1, value});
            }
            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
            boolean visited[]=new boolean[v+1];
            int ans=0,count=0;
            pq.add(new int[]{1,0});
            while(!pq.isEmpty()&&count<v){
                int cur[]=pq.poll();
                int node=cur[0],value=cur[1];
                if(visited[node])continue;
                visited[node]=true;
                ans+=value;
                count++;
                for(int n[]:graph.get(node)){
                    int next=n[0],va=n[1];
                    if(!visited[next]) pq.add(new int[]{next,va});
                    
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
